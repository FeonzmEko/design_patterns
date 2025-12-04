package com.itheima.pattern.strategy;

public class SaleMan {
    private Strategy strategy;

    public SaleMan(Strategy strategy){
        this.strategy = strategy;
    }

    public void saleManShow(){
        strategy.show();
    }
}
