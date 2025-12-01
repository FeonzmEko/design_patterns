package com.itheima.pattern.build.demo1;

public class JavaBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("java");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("java");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
