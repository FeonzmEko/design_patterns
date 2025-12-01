package com.itheima.pattern.proxy.jdk_proxy;

import com.itheima.pattern.proxy.static_proxy.SellTickets;
import com.itheima.pattern.proxy.static_proxy.TrainStation;

import java.lang.reflect.Proxy;

public class ProxyFactory {
    // 声明目标对象
    private TrainStation station = new TrainStation();
    public SellTickets getProxyObject(){
        //SellTickets proxyObject = (SellTickets) Proxy.newProxyInstance();
        return null;
    }
}
