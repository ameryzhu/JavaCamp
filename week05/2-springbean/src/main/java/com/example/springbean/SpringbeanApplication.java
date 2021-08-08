package com.example.springbean;

import com.example.springbean.beans.*;
import com.example.springbean.config.MyConfig;
import com.example.springbean.db.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class SpringbeanApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SpringbeanApplication.class, args);
//        testSchool();
        insertData();
    }


    public static void method1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyAnnotationSpringBean myAnnotationBean = (MyAnnotationSpringBean) ctx.getBean("myAnnotationBean");
        System.out.println("myAnnotationBean:" + myAnnotationBean.toString());
        System.out.println("myAnnotationBean:" + myAnnotationBean.name);
    }

    public static void method2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyXMLSpringBean myBean = (MyXMLSpringBean) ctx.getBean("myBean");
        System.out.println("mybean:" + myBean.toString());
        System.out.println("mybean:" + myBean.name);
    }

    public static void method3() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
        MyConfigBean bean = (MyConfigBean) ctx.getBean(MyConfigBean.class);
        System.out.println(bean.toString());

    }

    public static void testSchool(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student123 = (Student) ctx.getBean("student123");
        System.out.println(student123.toString());

        Student student100 = (Student) ctx.getBean("student100");
        System.out.println(student100.toString());

        Klass class1 = ctx.getBean(Klass.class);
        System.out.println(class1);

        ISchool school = ctx.getBean(ISchool.class);
        System.out.println(school);
        System.out.println("ISchool接口的对象"+school.getClass());

    }

    public static void insertData() throws IOException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = factory.openSession();
        User u = new User();
        u.setUser_name("zhuzhe2");
        u.setPhone("18566226037");
        int result =sqlSession.insert("insert into user",u);
//        sqlSession.insert("insert");
        System.out.println(result);
        sqlSession.close();
    }

}
