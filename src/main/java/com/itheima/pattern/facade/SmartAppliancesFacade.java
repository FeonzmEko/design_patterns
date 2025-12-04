package com.itheima.pattern.facade;

public class SmartAppliancesFacade {
    private Light light;
    private TV tv;
    private AirCondition air;

    public SmartAppliancesFacade() {
        light = new Light();
        tv = new TV();
        air = new AirCondition();
    }

    public void say(String message){
        if(message.contains("打开")){
            this.on();
        } else if(message.contains("关闭")){
            this.off();
        } else {
            System.out.println("我听不懂");
        }
    }

    public void on(){
        light.on();
        tv.on();
        air.on();
    }

    public void off(){
        light.off();
        tv.off();
        air.off();
    }
}
