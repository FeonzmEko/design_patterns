package com.itheima.pattern.bridge;

public class RMVBFile implements VideoFile{
    @Override
    public void decode(String fileName) {
        System.out.println("RMVB视频文件" + fileName);
    }
}
