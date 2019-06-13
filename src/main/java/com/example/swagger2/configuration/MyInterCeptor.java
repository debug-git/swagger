package com.example.swagger2.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Configuration
public class MyInterCeptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle被调用");
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        if ("ming".equalsIgnoreCase(name)){
            return true;
        }else{
            response.setCharacterEncoding("UTF-8");
            PrintWriter pw = response.getWriter();
            pw.write("please login!");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle被调用");
        //设置支持跨域请求，用于前后端分离项目
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Method", "GET,POST,PUT,DELETE,OPTIONS");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion被调用");
    }
}
