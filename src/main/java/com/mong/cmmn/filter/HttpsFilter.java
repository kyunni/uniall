package com.mong.cmmn.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpsFilter implements Filter {

    public HttpsFilter() { }

    public void destroy() { }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            RequestWrapper httpsRequest = new RequestWrapper((HttpServletRequest) request);

            httpsRequest.setResponse((HttpServletResponse) response);
            chain.doFilter(httpsRequest, response);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void init(FilterConfig arg0) throws ServletException {}
}
