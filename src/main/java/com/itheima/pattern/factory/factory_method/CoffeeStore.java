package com.itheima.pattern.factory.factory_method;

public class CoffeeStore {
    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory){
        this.factory = factory;
    }

    public Coffee orederCoffee(){
        Coffee coffee = factory.createCoffee();

        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
