package com.example.demo;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class I18NConfig {
    @Bean("messageSource")
    public MessageSource getmMessageSource(){
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
ms.setDefaultEncoding("utf-8");
ms.setBasenames("classpath:i18n/messages" , "classpath:i18n.global");
    return ms;}
}
