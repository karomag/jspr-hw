package ru.netology;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.nio.charset.Charset;
import java.util.List;

public class Request {

    private final String method;
    private final String path;
    private String params = null;

    public Request(String method, String path) {
        this.method = method;
        var parts = path.split("\\?");
        this.path = parts[0];
        if (parts.length == 2) {
            this.params = parts[1];
        }
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public NameValuePair getQueryParam(String name) {
        var params = getQueryParams();
        for (NameValuePair pair:params) {
            if (pair.getName().equals(name)) return pair;
        }
        return null;
    }

    public List<NameValuePair> getQueryParams() {
        return URLEncodedUtils.parse(params, Charset.defaultCharset());
    }
}
