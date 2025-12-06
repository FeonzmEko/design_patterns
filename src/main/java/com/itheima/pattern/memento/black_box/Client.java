package com.itheima.pattern.memento.black_box;


public class Client {
    public static void main(String[] args) {
        // 创建游戏角色对象
        GameRole gameRole = new GameRole();
        gameRole.initState();
        gameRole.stateDisplay();

        // 保存游戏角色状态
        RoleStateCaretaker roleStateCaretaker = new RoleStateCaretaker();
        roleStateCaretaker.setMemento(gameRole.saveState());

        // 损耗严重
        gameRole.fight();
        gameRole.stateDisplay();

        // 恢复状态
        gameRole.recoverState(roleStateCaretaker.getMemento());
        gameRole.stateDisplay();

    }
}
