package com.zto.sxy.spring;

import com.zto.sxy.spring.bean.Person;
import com.zto.sxy.spring.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//		Person bean = (Person) applicationContext.getBean("person");
//		System.out.println(bean);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);

        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name : namesForType) {
            System.out.println(name);
        }

    }

}