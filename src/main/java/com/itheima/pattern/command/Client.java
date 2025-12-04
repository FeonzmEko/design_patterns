package com.itheima.pattern.command;

public class Client {
    public static void main(String[] args) {
        Order order1 = new Order();
        order1.setDiningTable(1);
        order1.setFood("李晨做的扁粉菜",99);
        order1.setFood("可乐",1);

        Order order2 = new Order();
        order2.setDiningTable(2);
        order2.setFood("我做的好吃的",99);
        order2.setFood("雪碧",1);

        // 创建厨师对象
        SeniorChef receiver = new SeniorChef();
        // 创建命令对象
        OrderCommand cmd1 = new OrderCommand(receiver,order1);
        OrderCommand cmd2 = new OrderCommand(receiver,order2);

        // 创建调用者（服务员对象）
        Waiter invoke = new Waiter();
        invoke.setCommand(cmd1);
        invoke.setCommand(cmd2);

        // 让服务员发起命令
        invoke.orderUp();
    }
}
