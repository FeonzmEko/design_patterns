package com.itheima.pattern.singleton.demo1;

import java.sql.SQLOutput;

public class Client {
    public static void main(String[] args) {

        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance2 == instance1);
    }
}
