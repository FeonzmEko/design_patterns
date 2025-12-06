package com.itheima.pattern.state.before;

// 评价为拉了一坨大的
public class Lift implements ILift{
    private int state;

    @Override
    public void setState(int state) {
        this.state = state;
    }

    @Override
    public void open() {
        switch (state){
            case OPENING_STATE:
                System.out.println("电梯已处于开启状态，请勿重复开启");
                break;
            case CLOSING_STATE:
                System.out.println("电梯开启");
                setState(OPENING_STATE);
                break;
            case RUNNING_STATE:
                System.out.println("电梯已处于运行状态，请勿重复开启");
                break;
            case STOPPING_STATE:
                System.out.println("电梯已处于停止状态，请勿重复开启");
                break;
        }
    }

    @Override
    public void close() {
        switch (state){
            case OPENING_STATE:
                System.out.println("电梯关闭");
                setState(CLOSING_STATE);
                break;
            case CLOSING_STATE:
                System.out.println("电梯已处于关闭状态，请勿重复关闭");
                break;
            case RUNNING_STATE:
                System.out.println("电梯已处于运行状态，请勿重复关闭");
                break;
            case STOPPING_STATE:
                System.out.println("电梯已处于停止状态，请勿重复关闭");
                break;
        }
    }

    @Override
    public void run() {
        switch (state){
            case OPENING_STATE:
                System.out.println("电梯已处于开启状态，请勿重复运行");
                break;
            case CLOSING_STATE:
                System.out.println("电梯已处于关闭状态，请勿重复运行");
                break;
            case RUNNING_STATE:
                System.out.println("电梯已处于运行状态，请勿重复运行");
                break;
            case STOPPING_STATE:
                System.out.println("电梯运行");
                setState(RUNNING_STATE);
                break;
        }
    }

    @Override
    public void stop() {
        switch (state){
            case OPENING_STATE:
                System.out.println("电梯已处于开启状态，请勿重复停止");
                break;
            case CLOSING_STATE:
                System.out.println("电梯已处于关闭状态，请勿重复停止");
                break;
            case RUNNING_STATE:
                System.out.println("电梯停止");
                setState(STOPPING_STATE);
                break;
            case STOPPING_STATE:
                System.out.println("电梯已处于停止状态，请勿重复停止");
        }
    }
}