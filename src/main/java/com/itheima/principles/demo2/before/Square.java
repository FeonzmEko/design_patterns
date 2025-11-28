package com.itheima.principles.demo2.before;

public class Square extends Rectangle{
    @Override
    public void setLength(int length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setLength(width);
    }
}
