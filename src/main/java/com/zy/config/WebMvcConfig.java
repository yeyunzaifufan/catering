package com.zy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig  extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/xx").setViewName("/xx");
        registry.addViewController("/manager/top").setViewName("/manager/top");
        registry.addViewController("/manager/left").setViewName("/manager/left");
        registry.addViewController("/manager/index").setViewName("/manager/index");
        registry.addViewController("/manager/main").setViewName("/manager/main");
        registry.addViewController("/manager/computer").setViewName("/manager/computer");
        registry.addViewController("/manager/default").setViewName("/manager/default");
        registry.addViewController("/manager/error").setViewName("/manager/error");
        registry.addViewController("/manager/filelist").setViewName("/manager/filelist");
        registry.addViewController("/manager/imglist").setViewName("/manager/imglist");
        registry.addViewController("/manager/imglist1").setViewName("/manager/imglist1");
        registry.addViewController("/manager/imgtable").setViewName("/manager/imgtable");
        registry.addViewController("/login").setViewName("/login");
        registry.addViewController("/manager/right").setViewName("/manager/right");
        registry.addViewController("/manager/tab").setViewName("/manager/tab");
        registry.addViewController("/manager/tools").setViewName("/manager/tools");

        registry.addViewController("/customer/top").setViewName("/customer/top");
        registry.addViewController("/customer/left").setViewName("/customer/left");
        registry.addViewController("/customer/index").setViewName("/customer/index");
        registry.addViewController("/customer/main").setViewName("/customer/main");
        registry.addViewController("/customer/computer").setViewName("/customer/computer");
        registry.addViewController("/customer/default").setViewName("/customer/default");
        registry.addViewController("/customer/error").setViewName("/customer/error");
        registry.addViewController("/customer/filelist").setViewName("/customer/filelist");
        registry.addViewController("/customer/imglist").setViewName("/customer/imglist");
        registry.addViewController("/customer/imglist1").setViewName("/customer/imglist1");
        registry.addViewController("/customer/imgtable").setViewName("/customer/imgtable");
        registry.addViewController("/customer/right").setViewName("/customer/right");
        registry.addViewController("/customer/tab").setViewName("/customer/tab");
        registry.addViewController("/customer/tools").setViewName("/customer/tools");
    }

}
