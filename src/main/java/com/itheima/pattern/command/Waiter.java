package com.itheima.pattern.command;

import java.util.ArrayList;
import java.util.List;

public class Waiter {
    // 持有多个命令对象
    private List<Command> commands = new ArrayList<>();

    public void setCommand(Command cmd){
        // 将cmd对象存储到List集合中
        commands.add(cmd);
    }

    // 发起命令功能
    public void orderUp(){
        System.out.println("美女服务员：大厨，新订单来了。。。。");
        for (Command command : commands) {
            if (command != null) {
                command.execute();
            }
        }
    }
}
