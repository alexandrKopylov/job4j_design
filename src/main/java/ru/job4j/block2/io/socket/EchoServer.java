package ru.job4j.block2.io.socket;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean isServerWork = true;
            while (isServerWork) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {

                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {

                        if (str.contains("Hello")) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("Hello".getBytes());
                            break;
                        } else if (str.contains("Exit")) {
                            isServerWork = false;
                            break;
                        } else {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("What?".getBytes());
                            break;
                        }
                    }
                    out.flush();
                }
            }
        }
    }
}