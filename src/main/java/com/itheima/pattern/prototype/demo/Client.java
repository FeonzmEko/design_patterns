package com.itheima.pattern.prototype.demo;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype r = new Realizetype();
        Realizetype clone = r.clone();
        System.out.println(r==clone);
    }
}
