package com.itheima.principles.demo1;

public class SougouInput {
    private AbstractSkin skin;

    public SougouInput() {

    }

    public SougouInput(AbstractSkin skin) {
        this.skin = skin;
    }

    public void display(){
        skin.display();
    }

    public AbstractSkin getSkin() {
        return skin;
    }

    public void setSkin(AbstractSkin skin) {
        this.skin = skin;
    }
}
