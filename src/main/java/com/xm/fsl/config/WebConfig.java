package com.xm.fsl.config;


import com.xm.fsl.filter.TestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource(name = "测试过滤器")
    private TestFilter testFilter;

    @Resource(name = "测试拦截器")
    private HandlerInterceptor testInterceptor;


    /**
     * 注册第三方过滤器
     * 功能与spring mvc中通过配置web.xml相同
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean<TestFilter> RegisterFile1(){
        FilterRegistrationBean<TestFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(testFilter);//注册自定义过滤器
        bean.setName("测试过滤器1");//过滤器名称
        bean.setOrder(1);//优先级，最顶级
        List<String> urls = new ArrayList<>();
        // 匹配所有请求路径
        urls.add("/*");
//        bean.addUrlPatterns("","","","",...);
        bean.setUrlPatterns(urls);
        return bean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> urls = new ArrayList<>();
        // 匹配所有请求路径
        urls.add("/test");
        //注册过滤器
        registry.addInterceptor(testInterceptor).addPathPatterns(urls);
    }
}
