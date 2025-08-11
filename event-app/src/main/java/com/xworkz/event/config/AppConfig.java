package com.xworkz.event.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.event")
public class AppConfig{

    public AppConfig() {
        System.out.println("App Configuration....");
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        System.out.println("InternalResourceViewResolver...");
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }
}
