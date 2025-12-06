package com.itheima.pattern.memento.black_box;

public class RoleStateCaretaker {
    // 声明RoleStateMemento类型的变量
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
