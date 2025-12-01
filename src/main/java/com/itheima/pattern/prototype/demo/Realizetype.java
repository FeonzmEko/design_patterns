package com.itheima.pattern.prototype.demo;

public class Realizetype implements Cloneable{

    public Realizetype() {
        System.out.println("原型对象创建成功！");
    }

    @Override
    public Realizetype clone() throws CloneNotSupportedException {
        System.out.println("原型复制成功!");
        return (Realizetype) super.clone();
    }
}
