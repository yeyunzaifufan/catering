package com.zy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Liu-Yang on 2018/3/27.
 */
@Configuration
public class WebMvcConfig  extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/xx").setViewName("/xx");
        registry.addViewController("/top").setViewName("/top");
        registry.addViewController("/left").setViewName("/left");
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/main").setViewName("/main");
        registry.addViewController("/computer").setViewName("/computer");
        registry.addViewController("/default").setViewName("/default");
        registry.addViewController("/error").setViewName("/error");
        registry.addViewController("/filelist").setViewName("/filelist");
        registry.addViewController("/imglist").setViewName("/imglist");
        registry.addViewController("/imglist1").setViewName("/imglist1");
        registry.addViewController("/imgtable").setViewName("/imgtable");
        registry.addViewController("/login").setViewName("/login");
        registry.addViewController("/right").setViewName("/right");
        registry.addViewController("/tab").setViewName("/tab");
        registry.addViewController("/tools").setViewName("/tools");


    }

}
