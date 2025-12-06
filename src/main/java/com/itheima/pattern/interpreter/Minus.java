package com.itheima.pattern.interpreter;

public class Minus extends AbstractExpression{

    // +左边的表达式
    private AbstractExpression left;
    // +右边的表达式
    private AbstractExpression right;

    public Minus(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        // 将左边的结果和右边的结果进行相加
        return left.interpret(context) - right.interpret(context);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " - " + right.toString() + ")";
    }
}
