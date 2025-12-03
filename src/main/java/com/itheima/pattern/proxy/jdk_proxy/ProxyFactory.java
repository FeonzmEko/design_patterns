package com.itheima.pattern.proxy.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    // 声明目标对象
    private TrainStation station = new TrainStation();
    public SellTickets getProxyObject(){
        SellTickets proxyObject = (SellTickets) Proxy.newProxyInstance(
                station.getClass().getClassLoader(),
                station.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代售点收取一定的服务费用（jdk动态代理）");
                        Object obj = method.invoke(station,args);

                        return obj;
                    }
                }
        );
        return proxyObject;
    }
}
