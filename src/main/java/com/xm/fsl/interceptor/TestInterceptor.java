package com.xm.fsl.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component(value = "测试拦截器")
public class TestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        log.info("在请求处理之前进行调用（Controller方法调用之前）");
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        request.setAttribute("startTime", System.currentTimeMillis());
        log.info("controller object is {}", handlerMethod.getBean().getClass().getName());
        log.info("controller method is {}", handlerMethod.getMethod());
        // 需要返回true，否则请求不会被控制器处理
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
        log.info( request.getParameter("Test"));
        log.info("请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后），如果异常发生，则该方法不会被调用");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
        log.info("在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
        long startTime = (long) request.getAttribute("startTime");
        log.info("time consume is {}", System.currentTimeMillis() - startTime);
    }
}
