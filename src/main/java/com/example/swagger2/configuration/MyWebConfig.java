package com.example.swagger2.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterCeptor interCeptor;  //自定义拦截器
    @Autowired
    private MyFilter myFilter;    //自定义过滤器
    @Autowired
    private MySessionListener sessionListener;  //自定义监听器

    /**
     * 设置跳转列表
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index.html");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interCeptor).addPathPatterns("/asd/**");
    }


    @Bean
    public FilterRegistrationBean filterRegistration(){
        FilterRegistrationBean filter  = new FilterRegistrationBean();
        filter.setFilter(myFilter);
        filter.addUrlPatterns("/*");
        return filter;
    }

    @Bean
    public ServletListenerRegistrationBean listenerRegistration(){
        ServletListenerRegistrationBean<MySessionListener> listener = new ServletListenerRegistrationBean();
        listener.setListener(sessionListener);
        return listener;
    }
}
