package com.itheima.principles.demo6;

public class Car {
    private final Color color;
    private final MoveBehavior moveBehavior;

    // 依赖注入
    public Car(Color color, MoveBehavior moveBehavior) {
        this.color = color;
        this.moveBehavior = moveBehavior;
    }

    // 使用组合对象来实现功能
    public void showInfo(){
        System.out.println("This car is " + color.getColor() + ".");
    }

    // 委派给组合对象
    public void move(){
        moveBehavior.move();
    }
}
