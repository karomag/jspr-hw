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
                            "HTTP/1.1 200 OK\r\n" +
                            "charset = UTF - 8\r\n" +
                            "Content - Length:98\r\n\r\n" +

                            "<html>\r\n" +
                                "<head>\r\n" +
                                    "<title> An Messages Page</title>\r\n" +
                                "</head>\r\n" +
                                "<body>\r\n" +
                                    "<p>/messages</p>\r\n" +
                                "</body>\r\n" +
                            "</html >"
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