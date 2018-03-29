package com.zy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig  extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/xx").setViewName("/xx");

        registry.addViewController("/emptyPage").setViewName("/emptyPage");

        registry.addViewController("/manager/top").setViewName("/manager/top");
        registry.addViewController("/manager/left").setViewName("/manager/left");
        registry.addViewController("/manager/main").setViewName("/manager/main");

        registry.addViewController("/customer/top").setViewName("/customer/top");
        registry.addViewController("/customer/left").setViewName("/customer/left");
        registry.addViewController("/customer/main").setViewName("/customer/main");


        registry.addViewController("/customer/computer").setViewName("/customer/computer");
        registry.addViewController("/customer/default").setViewName("/customer/default");
        registry.addViewController("/customer/error").setViewName("/customer/error");
        registry.addViewController("/customer/filelist").setViewName("/customer/filelist");
        registry.addViewController("/customer/imglist").setViewName("/customer/imglist");
        registry.addViewController("/customer/imglist1").setViewName("/customer/imglist1");
        registry.addViewController("/customer/right").setViewName("/customer/right");
        registry.addViewController("/customer/tab").setViewName("/customer/tab");
        registry.addViewController("/customer/tools").setViewName("/customer/tools");
    }

}
