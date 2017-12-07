package com.arnold.web.beanfactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Object beanA = annotationConfigApplicationContext.getBean("beanA");
        //Object beanBSS = annotationConfigApplicationContext.getBean("beanA");

        Object beanB = annotationConfigApplicationContext.getBean("beanB");
    }
}
