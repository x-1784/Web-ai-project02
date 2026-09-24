package com.it.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 定义拦截器
 */


@Slf4j
@Component  //拦截器intercopter是spring中提供的技术，要加上@component注解交给ioc容器管理
public class DemoInterceptor implements HandlerInterceptor {

//    //在目标资源（也就是controller之前）方法之前运行   返回true放行，false不放行
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        log.info("preHandle ...");
//        return true;
//    }
//
//    //在目标资源方法运行之后运行
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//        log.info("postHandle ....");
//    }
//
//    //视图渲染完毕后运行， 视图渲染是之前前后端混合开发的东西，现在前后端分离开发 一般不考虑这个方法
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//        log.info("afterCompletion ....");
//    }
}




































