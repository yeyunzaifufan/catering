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
        registry.addViewController("/login").setViewName("/login");

        registry.addViewController("/manager/top").setViewName("/manager/top");
        registry.addViewController("/manager/left").setViewName("/manager/left");
        registry.addViewController("/manager/main").setViewName("/manager/main");

        registry.addViewController("/customer/top").setViewName("/customer/top");
        registry.addViewController("/customer/left").setViewName("/customer/left");
        registry.addViewController("/customer/main").setViewName("/customer/main");

        registry.addViewController("/chef/top").setViewName("/chef/top");
        registry.addViewController("/chef/left").setViewName("/chef/left");
        registry.addViewController("/chef/main").setViewName("/chef/main");

        registry.addViewController("/employee/top").setViewName("/employee/top");
        registry.addViewController("/employee/left").setViewName("/employee/left");
        registry.addViewController("/employee/main").setViewName("/employee/main");
    }

}
