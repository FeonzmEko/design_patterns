package com.itheima.pattern.observer.dev;

public class Client {
    public static void main(String[] args) {
        // 创建频道
        YellowMovie movie = new YellowMovie();

        // 增加用户
        movie.attach(new JmUser("昨天的张春韬"));
        movie.attach(new JmUser("今天的张春韬"));
        movie.attach(new JmUser("明天的张春韬"));

        // 更新消息
        movie.notify("初恋时间");
    }
}
