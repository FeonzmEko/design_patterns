package com.itheima.pattern.decorator;

public class Client {
    public static void main(String[] args) {
        FastFood food = new FiredNoodles();
        System.out.println(food.getPrice());
        System.out.println("----------");

        // 在炒饭中加一个鸡蛋
        food = new Egg(food);
        System.out.println(food.getDesc() + ": " + food.cost());

        food = new Egg(food);
        System.out.println(food.getDesc() + ": " + food.cost());

        food = new Bacon(food);
        System.out.println(food.getDesc() + ": " + food.cost());

    }
}
