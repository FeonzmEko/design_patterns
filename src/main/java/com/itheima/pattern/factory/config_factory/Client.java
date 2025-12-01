package com.itheima.pattern.factory.config_factory;

public class Client {
    public static void main(String[] args) {
        Coffee coffee1 = CoffeeFactory.createCoffee("cheny");
        Coffee coffee2 = CoffeeFactory.createCoffee("cheny");
        System.out.println(coffee2 == coffee1);
    }
}
