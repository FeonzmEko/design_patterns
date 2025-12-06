package com.itheima.pattern.interpreter;

public class Client {
    public static void main(String[] args) {
        // 创建环境对象
        Context context = new Context();

        // 创建多个变量对象
        Variable a = new Variable("a");
        Variable b = new Variable("b");
        Variable c = new Variable("c");
        Variable d = new Variable("d");

        // 将变量存储到环境对象中
        context.assign(a,10);
        context.assign(b,20);
        context.assign(c,30);
        context.assign(d,40);

        // 获取抽象语法树
        AbstractExpression expression = new Minus(a,new Plus(new Minus(b,c),d));

        // 计算
        int result = expression.interpret(context);

        // 打印结果
        System.out.println(expression + " = " + result);
    }
}
