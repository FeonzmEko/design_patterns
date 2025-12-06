package com.itheima.pattern.observer.dev;

import com.sun.javafx.scene.control.skin.ListViewSkin;

import java.util.ArrayList;
import java.util.List;

public class YellowMovie implements Movie{

    private List<Observer> list = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        list.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notify(String msg) {
        for (Observer observer : list) {
            observer.update(msg);
        }
    }
}
