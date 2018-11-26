package com.thingtrust.trend.util.ssh;

import com.jcraft.jsch.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * lombok 注解get set;无参构造，全参构造
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class ScpClient {
    private String ip;
    private int port;
    private String username;
    private String password;
    static private ScpClient instance;

    static synchronized public ScpClient getInstance(final String ip, final int port, final String username, final String password) {
        if (instance == null) {
            instance = new ScpClient(ip, port, username, password);
        }
        return instance;
    }

    public boolean putFile(final String localFile, final String remoteTarget) {
        Boolean bool = false;
        final java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        final JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession(username, ip, port);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
        } catch (final JSchException e) {
            log.error("connect dns server error=> ip: {} username: {} port: {} password: {} message: {}", ip, username, port, password, e.getMessage());
            bool = false;
            return bool;
        }

        ChannelSftp channelSftp = null;
        InputStream inputStream = null;

        try {
            channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect(5000);
            inputStream = new FileInputStream(new File(localFile));
            channelSftp.setInputStream(inputStream);
            channelSftp.put(inputStream, remoteTarget);
        } catch (final JSchException | FileNotFoundException | SftpException e) {
            log.error("put error: {}", e.getMessage());
            bool = false;
            return bool;
        } finally {
            if (channelSftp != null) {
                channelSftp.disconnect();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (final IOException e) {
                    log.error("inputStream close error: {}", e.getMessage());
                    bool = false;
                    return bool;
                }
            }
            if (session != null && session.isConnected()) {
                session.disconnect();
            }
        }
        bool = true;
        return bool;
    }
}