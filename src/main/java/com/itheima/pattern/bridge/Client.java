package com.itheima.pattern.bridge;

public class Client {
    public static void main(String[] args) {
        OperatingSystem system = new Linux(new Mp4File());
        system.play("sun");
    }
}
