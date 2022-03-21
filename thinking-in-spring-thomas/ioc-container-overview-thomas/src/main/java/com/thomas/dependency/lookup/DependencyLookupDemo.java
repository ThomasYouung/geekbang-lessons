package com.thomas.dependency.lookup;

import com.thomas.annotation.Super;
import com.thomas.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * 依赖查找案例
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        //读取配置文件，获取上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:dependency-lookup.xml");

        //通过名称查找-实时查找
        lookupRealtime(beanFactory);

        //通过名称查找-延迟查找（间接查找？）
        lookupLazytime(beanFactory);

        //通过类型查找-单个bean对象
        lookupBeanByType(beanFactory);

        //通过类型查找-多个bean对象
        lookupCollectionBeanByType(beanFactory);

        //通过注解查找-单个bean对象
        /*lookupBeanByAnnotation(beanFactory);*/

        //通过注解查找-多个bean对象
        lookupCollectionBeanByAnnotation(beanFactory);

    }

    private static void lookupCollectionBeanByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, Object> beansWithAnnotation = listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("通过注解查找-多个bean对象:" + beansWithAnnotation);
        }
    }


    private static void lookupCollectionBeanByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("通过类型查找-多个bean对象:" + userMap);
        }
    }

    private static void lookupBeanByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("通过类型查找-单个bean对象：" + user);
    }

    private static void lookupLazytime(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>)beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("通过名称查找-延迟查找:" + user);
    }

    private static void lookupRealtime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("通过名称查找-实时查找：" + user);
    }


}
