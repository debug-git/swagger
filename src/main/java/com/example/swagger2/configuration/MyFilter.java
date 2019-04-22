package com.example.swagger2.configuration;


import com.sun.deploy.net.HttpResponse;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入过滤器");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
//        if (uri.indexOf("index") > -1){
            filterChain.doFilter(servletRequest, servletResponse);
//        }else {
//            response.sendRedirect("index.html");
//        }
    }

    @Override
    public void destroy() {

    }
}
