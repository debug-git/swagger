package com.example.swagger2.controller;

import com.example.swagger2.configuration.Env;
import com.example.swagger2.configuration.MySessionListener;
import com.example.swagger2.vo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(tags = "这是一个启动action")
@RestController
public class IndexController {
    @Value("${value}")
    private String value;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private ServletContext servletContext;
    @Autowired
    private ApplicationContext context;
    @Autowired
    private Env Eenv;

    @ApiOperation(value = "用于进入首页", notes = "这里写一些备注说明,比如姓名不能为空")
    @ApiImplicitParam(name = "addr", value = "这是地址")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    //@Validated 发现添加了此注解,在swagger就无法显示User类的字段信息
    public String index(/*@Validated*/ User user, String addr){
//        System.out.println(env);
        return user.getName() + "---" + value + addr;
    }

    @GetMapping("/asd/test")
    public String testInterCeptor(String name){
        return name;
    }

    @GetMapping("/online")
    public Integer getOnlineCount(){
        System.out.println(request.getRequestURI());
        System.out.println(request.getContextPath());
        System.out.println(request.getAttribute("jjj"));
        ServletContext servletContext = request.getServletContext();
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        IndexController f = context.getBean(IndexController.class);

        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();

        return MySessionListener.count;
    }

}
