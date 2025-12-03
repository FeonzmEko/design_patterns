package com.itheima.pattern.adapter.object_adapter;

import com.itheima.pattern.adapter.class_adapter.TFCard;
import com.itheima.pattern.adapter.class_adapter.TFCardImpl;

public class SDAdapterTF extends SDCardImpl {
    private TFCard tfCard = new TFCardImpl();

    @Override
    public String readSD() {
        System.out.println("adapter read tf card");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card");
        tfCard.writeTF(msg);
    }
}
