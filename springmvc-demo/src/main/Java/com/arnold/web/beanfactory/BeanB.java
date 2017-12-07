package com.arnold.web.beanfactory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

//@Component("beanB")
public class BeanB implements InitializingBean{
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BeanB.afterPropertiesSet");
    }


    private void initB() {
        System.out.println("initB");
    }
}
