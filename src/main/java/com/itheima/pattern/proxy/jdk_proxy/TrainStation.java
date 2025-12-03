package com.itheima.pattern.proxy.jdk_proxy;

public class TrainStation implements SellTickets {
    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }

    @Override
    public void eat() {
        System.out.println("eat something.");
    }
}
