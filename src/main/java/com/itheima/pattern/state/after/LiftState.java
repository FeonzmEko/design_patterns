package com.itheima.pattern.state.after;

public abstract class LiftState {
    // 声明环境类成员
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    // 电梯的四种操作
    public abstract void open();
    public abstract void close();
    public abstract void run();
    public abstract void stop();

}