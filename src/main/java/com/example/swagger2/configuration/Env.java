package com.example.swagger2.configuration;

import lombok.Data;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.jsp.PageContext;

@Data
public class Env {
    private HttpServletRequest request;
    private HttpServletResponse response;
//    private PageContext pageContext;
    private ServletContext servletContext;

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
}
