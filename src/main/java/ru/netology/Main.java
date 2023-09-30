package ru.netology;

import java.io.BufferedOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(64);

        server.addHandler("GET", "/messages", new Handler() {
            public void handle(Request request, BufferedOutputStream responseStream) {
                try {
                    server.responseBadRequest(responseStream);
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
                    server.responseDefault(responseStream, "/spring.svg");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        server.listen(9999);
    }
}