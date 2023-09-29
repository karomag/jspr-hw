package ru.netology;

import java.io.BufferedOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(64);

        server.addHandler("GET", "/messages", new Handler() {
            public void handle(Request request, BufferedOutputStream responseStream) {
                try {
                    responseStream.write((
                            "HTTP/1.1 404 Not Found\r\n" +
                                    "Content-Length: 0\r\n" +
                                    "Connection: close\r\n" +
                                    "\r\n"
                    ).getBytes());
                    responseStream.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        server.addHandler("POST", "/messages", new Handler() {
            public void handle(Request request, BufferedOutputStream responseStream) {
                try {
                    server.responseBadRequest(responseStream);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        server.addHandler("GET", "/", new Handler() {
            public void handle(Request request, BufferedOutputStream responseStream) {
                try {
                    server.responseDefault(responseStream, "/index.html");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        server.listen(9999);
    }
}