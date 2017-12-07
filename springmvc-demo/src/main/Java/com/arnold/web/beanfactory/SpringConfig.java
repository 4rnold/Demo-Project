package com.arnold.web.beanfactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.arnold.beanfactory")
public class SpringConfig {

    @Bean(initMethod = "init",destroyMethod = "destory")
    public BeanA beanA(){
        return new BeanA();
    }

    @Bean(initMethod = "initB")
    public BeanB beanB(){
        return new BeanB();
    }


}
