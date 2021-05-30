package com.example.demo.helper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
/**
 * 辅助类，在job中获取mapper
 * @author dy-xx
 *
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware{

    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }


    public  void setApplicationContext(ApplicationContext applicationContext) {
        ApplicationContextUtil.applicationContext = applicationContext;
    }
	//这里只写了根据id来获取bean，可以根据自己的需求在作更改
    public static Object getBean(String BeanName){
        return applicationContext.getBean(BeanName);
    }
   
}

