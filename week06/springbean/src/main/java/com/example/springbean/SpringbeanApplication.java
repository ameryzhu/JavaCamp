package com.example.springbean;

import com.example.springbean.beans.MyAnnotationSpringBean;
import com.example.springbean.beans.MyConfigBean;
import com.example.springbean.beans.MyXMLSpringBean;
import com.example.springbean.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringbeanApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbeanApplication.class, args);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        method3();
    }


    public static void method1(ApplicationContext ctx) {
        MyAnnotationSpringBean myAnnotationBean = (MyAnnotationSpringBean) ctx.getBean("myAnnotationBean");
        System.out.println("myAnnotationBean:" + myAnnotationBean.toString());
        System.out.println("myAnnotationBean:" + myAnnotationBean.name);
    }

    public static void method2(ApplicationContext ctx) {
        MyXMLSpringBean myBean = (MyXMLSpringBean) ctx.getBean("myBean");
        System.out.println("mybean:" + myBean.toString());
        System.out.println("mybean:" + myBean.name);
    }

    public static void method3() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
        MyConfigBean bean = (MyConfigBean) ctx.getBean(MyConfigBean.class);
        System.out.println(bean.toString());

    }

}
