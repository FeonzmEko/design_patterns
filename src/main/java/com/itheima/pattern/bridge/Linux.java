package com.itheima.pattern.bridge;

public class Linux extends OperatingSystem{
    public Linux(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        System.out.println("在Linux上");
        videoFile.decode(fileName);
    }
}
