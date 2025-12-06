package com.itheima.pattern.observer.dev;

public class JmUser implements Observer{

    private String name;

    public JmUser(String name){
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("我叫" + name +"，我最爱的黄片" + message + "更新了，我要看!");
    }
}
