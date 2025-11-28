package com.itheima.principles.demo6;

public class ElectricCar implements MoveBehavior{
    @Override
    public void move() {
        System.out.println("Car is moving using electricity.");
    }
}
