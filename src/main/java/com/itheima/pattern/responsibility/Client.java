package com.itheima.pattern.responsibility;

public class Client {
    public static void main(String[] args) {
        // 一个请假条对象
        LeaveRequest leave = new LeaveRequest("小明",9,"抱恙");

        // 各级领导对象
        GroupLeader groupLeader = new GroupLeader();
        Manager manager = new Manager();
        GeneralManager generalManager = new GeneralManager();

        // 设置职责链
        groupLeader.setNextHandler(manager);
        manager.setNextHandler(generalManager);

        groupLeader.submit(leave);
    }
}