package com.itheima.pattern.prototype.demo1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Citation implements Cloneable{
    private String name;
    private Award award;


    @Override
    protected Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Citation{" +
                "name='" + name + '\'' +
                '}';
    }
}

@Data
class Award {
    public String medal = "初级奖章";

}

