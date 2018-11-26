package com.thingtrust.trend.util.ssh;

import com.jcraft.jsch.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;

import java.io.*;
import java.net.ConnectException;

/**
 * Created by terry on 17-9-11.
 */
@Slf4j
@EnableRetry
public class SshScp {

    @Retryable(value = ConnectException.class, maxAttempts = 10, backoff = @Backoff(value = 5000L))
    public static String scp(final String lfile, final String user, final String password, final String host, final int port, final String rfile) {

        FileInputStream fis = null;
        try {

            final java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            final JSch jsch = new JSch();
            final Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig(config);

            try {
                session.connect();
            } catch (final JSchException e) {
                log.error("JSch Session connect fail: {} time: {}", e, System.currentTimeMillis());
                throw new ConnectException("Connection refused");
            }
            final boolean ptimestamp = true;

            // exec 'scp -t rfile' remotely
            final StringBuilder comm = new StringBuilder("mkdir -p ").append(rfile).append(";");
            comm.append("scp " + (ptimestamp ? "-p" : "") + " -t " + rfile);
            String command = comm.toString();
            final Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);

            // get I/O streams for remote scp
            final OutputStream out = channel.getOutputStream();
            final InputStream in = channel.getInputStream();

            channel.connect();

            checkAck(in);

            final File _lfile = new File(lfile);

            if (ptimestamp) {
                command = "T" + (_lfile.lastModified() / 1000) + " 0";
                // The access time should be sent here,
                // but it is not accessible with JavaAPI ;-<
                command += (" " + (_lfile.lastModified() / 1000) + " 0\n");
                out.write(command.getBytes());
                out.flush();
                checkAck(in);
            }

            // send "C0644 filesize filename", where filename should not include '/'
            final long filesize = _lfile.length();
            command = "C0644 " + filesize + " ";
            if (lfile.lastIndexOf('/') > 0) {
                command += lfile.substring(lfile.lastIndexOf('/') + 1);
            } else {
                command += lfile;
            }
            command += "\n";
            out.write(command.getBytes());
            out.flush();
            checkAck(in);

            // send a content of lfile
            fis = new FileInputStream(lfile);
            final byte[] buf = new byte[1024];
            while (true) {
                final int len = fis.read(buf, 0, buf.length);
                if (len <= 0) {
                    break;
                }
                out.write(buf, 0, len); //out.flush();
            }
            fis.close();
            fis = null;
            // send '\0'
            buf[0] = 0;
            out.write(buf, 0, 1);
            out.flush();
            checkAck(in);
            out.close();

            channel.disconnect();
            session.disconnect();
            return "success";
        } catch (final JSchException | IOException e) {
            log.error("JSch or IO error: {}", e);
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (final Exception ee) {
                log.error("FileInputStream close error: {}", ee);
            }
            return "fail";
        }
    }

    static int checkAck(final InputStream in) throws IOException {
        final int b = in.read();
        // b may be 0 for success,
        //          1 for error,
        //          2 for fatal error,
        //          -1
        if (b == 0) {
            return b;
        }
        if (b == -1) {
            return b;
        }

        if (b == 1 || b == 2) {
            final StringBuffer sb = new StringBuffer();
            int c;
            do {
                c = in.read();
                sb.append((char) c);
            }
            while (c != '\n');
            if (b == 1 || b == 2) { // error
                throw new RuntimeException(sb.toString());
            }
        }
        return b;
    }

}