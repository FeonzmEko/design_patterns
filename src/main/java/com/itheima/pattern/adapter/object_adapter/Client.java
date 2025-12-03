package com.itheima.pattern.adapter.object_adapter;

public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();

        String msg = computer.readSD(new SDCardImpl());
        System.out.println(msg);

        System.out.println("=============");

        String ms1 = computer.readSD(new SDAdapterTF());
        System.out.println("ms1 = " + ms1);
    }
}
