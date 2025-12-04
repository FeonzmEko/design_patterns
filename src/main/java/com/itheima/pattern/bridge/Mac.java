package com.itheima.pattern.bridge;

public class Mac extends OperatingSystem{
    public Mac(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        System.out.println("在Mac上");
        videoFile.decode(fileName);
    }
}
