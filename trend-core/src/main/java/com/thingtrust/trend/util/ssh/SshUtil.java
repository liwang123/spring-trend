package com.thingtrust.trend.util.ssh;

import com.jcraft.jsch.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.util.concurrent.TimeUnit;

@Slf4j
@EnableRetry
public class SshUtil {

    @Retryable(value = ConnectException.class, maxAttempts = 10, backoff = @Backoff(value = 5000L))
    public static synchronized String sudoExec(final String host, final int port, final String account, final String password, final String command, final boolean isSudo) {
        final JSch jsch = new JSch();
        Session session = null;
        Channel channel = null;
        try {
            final java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session = jsch.getSession(account, host, port);
            session.setPassword(password);
            session.setConfig(config);
            try {
                session.connect();
            } catch (final JSchException e) {
                log.error("JSch Session connect fail: {} time: {}", e, System.currentTimeMillis());
                throw new ConnectException("Connection refused");
            }
            channel = session.openChannel("exec");
            if (isSudo) {
                ((ChannelExec) channel).setCommand("sudo -S -p '' " + command);
            } else {
                ((ChannelExec) channel).setCommand(command);
            }
            final InputStream in = channel.getInputStream();
            final OutputStream out = channel.getOutputStream();
            ((ChannelExec) channel).setErrStream(System.err);

            channel.connect();

            out.write((password + "\n").getBytes());
            out.flush();

            final StringBuffer sb = new StringBuffer();
            while (true) {
                final byte[] tmp = new byte[2048];
                while (in.available() > 0) {
                    final int i = in.read(tmp, 0, 2048);
                    if (i < 0) {
                        break;
                    }
                    sb.append(new String(tmp, 0, i));
                }
                if (channel.isClosed()) {
                    log.info("Connection to {} closed", host);
                    break;
                }
                try {
                    TimeUnit.MICROSECONDS.sleep(500);
                } catch (final Exception ee) {
                }
            }
            return sb.toString();
        } catch (final JSchException | IOException e) {
            log.error("", e);
            throw new RuntimeException(e.getMessage());
        } finally {
            if (channel != null) {
                channel.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
        }
    }

    @Recover
    public String recover(final ConnectException e) throws ConnectException {
        throw new ConnectException("ConnectException");
    }
}