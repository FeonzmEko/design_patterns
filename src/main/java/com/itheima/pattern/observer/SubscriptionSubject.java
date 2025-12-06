package com.itheima.pattern.observer;


import java.util.ArrayList;
import java.util.List;

public class SubscriptionSubject implements Subject{

    private List<Observer> weiXinUserList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        weiXinUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weiXinUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        // 遍历集合
        for (Observer observer : weiXinUserList) {
            // 调用观察者对象中的update方法
            observer.update(message);
        }
    }
}
