package com.itheima.pattern.bridge;

public class Mp4File implements VideoFile{
    @Override
    public void decode(String fileName) {
        System.out.println("mp4视频文件" + fileName);
    }
}
