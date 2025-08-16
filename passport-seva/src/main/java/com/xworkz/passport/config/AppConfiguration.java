package com.xworkz.passport.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.passport")
public class AppConfiguration {

    public AppConfiguration() {
        System.out.printf("App Configuration...");
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){

        System.out.printf("InternalResourceViewResolver...");
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }
}
