package com.itheima.pattern.factory.simple_factory;

public class Client {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee coffee = coffeeStore.orederCoffee("latte");
        System.out.println(coffee.getName());
    }
}
