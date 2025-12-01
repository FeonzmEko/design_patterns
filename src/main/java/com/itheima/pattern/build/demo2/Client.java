package com.itheima.pattern.build.demo2;

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .cpu("cpu")
                .screen("screen")
                .memory("金士顿")
                .mainboard("华硕")
                .build();

        System.out.println(phone);
    }
}
