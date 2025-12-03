package com.itheima.pattern.adapter.class_adapter;

public class Computer {
    public String readSD(SDCard sdcard){
        if(sdcard == null){
            throw new NullPointerException("sd cari is not null.");
        }

        return sdcard.readSD();
    }
}
