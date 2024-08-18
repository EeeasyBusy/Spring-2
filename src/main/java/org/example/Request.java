package org.example;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class Request {
    public String[] requestLine;
    public List<String> headers;
    public List<NameValuePair> params;

    public Request(String[] requestLine, List<String> headers, List<NameValuePair> params) {
        this.requestLine = requestLine;
        this.headers = headers;
        this.params = params;
    }

    public List<NameValuePair> getQueryParams() {
        return params;
    }

    public List<NameValuePair> getQueryParam(String name) {
        List<NameValuePair> paramOfName = new ArrayList<>();
        for (NameValuePair param : params) {
            if (param.getName().contains(name)) {
                paramOfName.add(new BasicNameValuePair(param.getName(), param.getValue()));
                return paramOfName;
            }
        }
        return null;
    }

}