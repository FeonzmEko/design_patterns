package com.itheima.pattern.proxy.jdk_proxy;

public class Client {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory();
        SellTickets proxyObject = (SellTickets) factory.getProxyObject();
        proxyObject.eat();
        System.out.println(proxyObject.getClass());
        while (true){

        }
    }
}
