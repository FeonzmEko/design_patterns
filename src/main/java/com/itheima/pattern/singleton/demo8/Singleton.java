package com.itheima.pattern.singleton.demo8;

public class Singleton {

    private Singleton(){
        if(instance!=null){
            throw new RuntimeException();
        }
    }
    private static volatile Singleton instance;

    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


}

