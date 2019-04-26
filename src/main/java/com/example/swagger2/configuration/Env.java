package com.example.swagger2.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Data
@Configuration
public class Env {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
//    private PageContext pageContext;
    @Autowired
    private ServletContext servletContext;
    @Autowired
    private ApplicationContext context;

    /*
     * Bean factory part
     */
    public WebApplicationContext getApplicationContext(){
        if (request != null) {
            return WebApplicationContextUtils.getWebApplicationContext(servletContext);
        } else {
            return null;
        }
    }

//    public static getEnv(){
//
//    }

}
