package com.itheima.pattern.proxy.static_proxy;

public class ProxyPoint implements SellTickets{

    private TrainStation trainStation = new TrainStation();

    @Override
    public void sell() {
        System.out.println("代理点收取费用");
        trainStation.sell();
    }
}
