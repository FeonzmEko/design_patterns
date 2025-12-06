package com.itheima.pattern.state.before;

public interface ILift {
    // 定义电梯的四个状态常量
    int OPENING_STATE = 1;
    int CLOSING_STATE = 2;
    int RUNNING_STATE = 3;
    int STOPPING_STATE = 4;

    // 设置电梯状态
    void setState(int state);

    // 电梯操作
    void open();
    void close();
    void run();
    void stop();


}
