package com.itheima.pattern.bridge;

public abstract class OperatingSystem {
    public VideoFile videoFile;

    public OperatingSystem(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    public void play(String fileName){
        videoFile.decode(fileName);
    }
}
