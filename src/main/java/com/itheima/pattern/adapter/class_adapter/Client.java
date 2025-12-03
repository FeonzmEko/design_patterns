package com.itheima.pattern.adapter.class_adapter;

public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();

        String msg = computer.readSD(new SDCardImpl());
        System.out.println(msg);

        System.out.println("=============");

        String msg1 = computer.readSD(new SDAdapterTF());
        System.out.println(msg1);
    }
}
