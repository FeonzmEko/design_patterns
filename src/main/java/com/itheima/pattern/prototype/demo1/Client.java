package com.itheima.pattern.prototype.demo1;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Citation c1 = new Citation("cheny",new Award());
        Citation c2 = c1.clone();
        c2.setName("feonzmeko");

        System.out.println(c2);
        System.out.println(c1);

        System.out.println(c1.getAward().medal);
        System.out.println(c2.getAward().medal);

        c2.getAward().setMedal("高级金牌");

        System.out.println(c1.getAward().medal);
        System.out.println(c2.getAward().medal);
    }
}
