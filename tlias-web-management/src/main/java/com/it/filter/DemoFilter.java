package com.it.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 还需要在启动类上加一个@servletcomponentscan注解，开启Servlet组件支持
 */

@Slf4j
//webfilter是设置拦截哪些请求的，/*是指所有请求

//@WebFilter(urlPatterns = "/*")  //拦截所有请求
public class DemoFilter implements Filter {

    //初始化方法，web服务器启动的时候执行，只执行一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init 初始化方法 ....");
    }

    //拦截到请求之后执行，会执行多次
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("拦截到了请求....");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    //销毁方法，web服务器关闭时执行，只执行一次
    @Override
    public void destroy() {
        log.info("destroy 销毁方法 ....");
    }
}































