package com.itheima.pattern.interpreter;

public class Variable extends AbstractExpression{

    private String name;

    public Variable(String name){
        this.name = name;
    }

    @Override
    public int interpret(Context context) {
        // 直接返回变量的值
        return context.getValue(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
