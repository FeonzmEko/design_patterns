package com.itheima.framework.beans.factory.support;

import com.itheima.framework.beans.BeanDefinition;

public interface BeanDefinitionRegistry {
    // 注册BeanDefinition对象到注册表中
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    // 从注册表中删除指定名称的BeanDefinition对象
    void removeBeanDefinition(String beanName) throws Exception;

    // 根据名称从注册表中获取BeanDefinition对象
    BeanDefinition getBeanDefinition(String beanName) throws Exception;

    // 是否包含某个BeanDefinition
    boolean containsBeanDefinition(String beanName);

    // 获取注册的bean的数量
    int getBeanDefinitionCount();

    // 获取BeanDefinition的名称数组
    String[] getBeanDefinitionNames();
}
