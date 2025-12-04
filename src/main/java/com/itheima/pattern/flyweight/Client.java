package com.itheima.pattern.flyweight;

public class Client {
    public static void main(String[] args) {
        AbstractBox box1 = BoxFactory.getInstance().getShape("I");
        box1.display("灰色");

        AbstractBox box2 = BoxFactory.getInstance().getShape("I");
        box1.display("白色");

        System.out.println(box1 == box2);
    }
}