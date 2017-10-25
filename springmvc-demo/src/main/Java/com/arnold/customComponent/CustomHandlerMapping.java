package com.arnold.customComponent;

import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

public class CustomHandlerMapping implements HandlerMapping{
    @Override
    public HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {
        String url = request.getRequestURI().toString();
        String method = request.getMethod();
        if (url.startsWith("/testcustom")) {
            if (method.equalsIgnoreCase("GET")) {
                return null;
            }
        }
        return null;
    }
}
