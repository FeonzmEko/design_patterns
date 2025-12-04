package com.itheima.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class BoxFactory {
    private Map<String,AbstractBox> map;
    private static BoxFactory factory = new BoxFactory();

    private BoxFactory(){
        map = new HashMap<>();
        map.put("I",new IBox());
        map.put("L",new LBox());
        map.put("O",new OBox());
    }

    public static BoxFactory getInstance(){
        return factory;
    }
    // 根据名称获取图形对象
    public AbstractBox getShape(String name){
        return map.get(name);
    }
}
