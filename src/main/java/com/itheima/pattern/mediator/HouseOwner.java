package com.itheima.pattern.mediator;

public class HouseOwner extends Person {

    public HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    // 和中介联系
    public void contact(String msg){
        mediator.contact(msg,this);
    }

    // 获取信息
    public void getMessage(String msg){
        System.out.println("房主" + name +"获取到的信息是：" +msg);
    }
}
