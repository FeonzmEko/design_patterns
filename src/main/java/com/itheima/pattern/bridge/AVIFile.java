package com.itheima.pattern.bridge;

public class AVIFile implements VideoFile{
    @Override
    public void decode(String fileName) {
        System.out.println("avi视频文件" + fileName);
    }
}
