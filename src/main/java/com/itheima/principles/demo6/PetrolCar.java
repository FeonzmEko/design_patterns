package com.itheima.principles.demo6;

public class PetrolCar implements MoveBehavior{

    @Override
    public void move() {
        System.out.println("Car is moving using petrol.");
    }
}
