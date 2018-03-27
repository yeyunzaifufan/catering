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
    }

}
