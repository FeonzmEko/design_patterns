package com.itheima.pattern.observer;

public class Client {
    public static void main(String[] args) {
        // 公众号实例化
        SubscriptionSubject subject = new SubscriptionSubject();

        // 订阅公众号
        subject.attach(new WeiXinUser("孙悟空"));
        subject.attach(new WeiXinUser("猪悟能"));
        subject.attach(new WeiXinUser("沙悟净"));

        // 公众号更新，发消息给订阅者
        subject.notify("张春韬是佬_阴沟老鼠");
    }
}
