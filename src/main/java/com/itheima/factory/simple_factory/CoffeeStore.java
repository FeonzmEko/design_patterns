package com.itheima.factory.simple_factory;

public class CoffeeStore {
    public Coffee orederCoffee(String type){
        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
        Coffee coffee = factory.createCoffee(type);

        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
