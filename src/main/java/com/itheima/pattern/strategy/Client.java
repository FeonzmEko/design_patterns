package com.itheima.pattern.strategy;

public class Client {
    public static void main(String[] args) {
        SaleMan saleMan = new SaleMan(new StrategyA());
        saleMan.saleManShow();
    }
}
