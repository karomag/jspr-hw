package ru.netology;

import java.util.HashMap;
import java.util.Map;

public class Request {

    private final String method;
    private final String path;

    public Request(String method, String path) {
        this.method = method;
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> requestHandler() {
        Map<String, String> map = new HashMap<>();
        map.put(method, path);
        return map;
    }
}
