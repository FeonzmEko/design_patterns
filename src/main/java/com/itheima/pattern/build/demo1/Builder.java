package com.itheima.pattern.build.demo1;

public abstract class Builder {
    // 声明Bike变量并赋值
    protected Bike bike = new Bike();

    public abstract void buildFrame();
    public abstract void buildSeat();

    public abstract Bike createBike();
}
