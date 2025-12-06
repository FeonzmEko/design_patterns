package com.itheima.controller;

import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserController {
    public static void main(String[] args) {
        // 创建spring的容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));

        // 从容器对象获取UserService对象
        UserService userService = (UserService) applicationContext.getBean("userService");

        //调用userService方法进行业务逻辑处理
        userService.add();

    }
}
