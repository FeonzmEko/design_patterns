package com.itheima.pattern.observer.dev;

public interface Movie {
    void attach(Observer observer);
    void detach(Observer observer);
    void notify(String msg);
}
