package ru.job4j.block2.io.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.block2.io.log4j.UsageLog4j;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean isServerWork = true;
            while (isServerWork) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {

                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());

                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        if (str.contains("Hello")) {
                            out.write("Hello".getBytes());
                            break;
                        } else if (str.contains("Exit")) {
                            isServerWork = false;
                            break;
                        } else {
                            out.write("What?".getBytes());
                            break;
                        }
                    }
                    out.flush();
                }
            }
        } catch (IOException e) {
            LOG.error("Exception ServerSocket", e);
        }
    }
}