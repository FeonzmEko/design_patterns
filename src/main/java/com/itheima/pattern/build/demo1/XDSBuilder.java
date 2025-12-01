package com.itheima.pattern.build.demo1;

public class XDSBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("xds");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("xds");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
