package com.itheima.pattern.build.demo1;

public class OfoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("ofo");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("ofo");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
