package com.itheima.pattern.facade;

public class Client {
    public static void main(String[] args) {
        SmartAppliancesFacade saf = new SmartAppliancesFacade();
        saf.say("打开，我要舒服一下");
    }
}
