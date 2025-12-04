package com.itheima.pattern.bridge;

public class Windows extends OperatingSystem{
    public Windows(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        System.out.println("在Windows上");
        videoFile.decode(fileName);
    }
}
