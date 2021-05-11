package com.xm.fsl.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;



//过滤器(Filter)：它依赖于servlet容器。在实现上，基于函数回调，它可以对几乎所有请求进行过滤，
//但是缺点是一个过滤器实例只能在容器初始化时调用一次。使用过滤器的目的，是用来做一些过滤操作，获
//取我们想要获取的数据，比如：在JavaWeb中，对传入的request、response提前过滤掉一些信息，或
//者提前设置一些参数，然后再传入servlet或者Controller进行业务逻辑操作。通常用的场景是：在过
//滤器中修改字符编码（CharacterEncodingFilter）、在过滤器中修改HttpServletRequest的一
//些参数（XSSFilter(自定义过滤器)），如：过滤低俗文字、危险字符等。
@Component(value = "测试过滤器")
@Slf4j
public class TestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化过滤器：{}", filterConfig.getFilterName());
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse
            , FilterChain filterChain) throws IOException, ServletException {
        log.info("start to doFilter");
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        long endTime = System.currentTimeMillis();
        log.info("the request of {} consumes {}ms.", getUrlFrom(servletRequest), (endTime - startTime));
        log.info("end to doFilter");
    }

    @Override
    public void destroy() {
        log.info("销毁过滤器");
        Filter.super.destroy();
    }


    private String getUrlFrom(ServletRequest servletRequest){
        if (servletRequest instanceof HttpServletRequest){
            return ((HttpServletRequest) servletRequest).getRequestURL().toString();
        }
        return "";
    }



}
