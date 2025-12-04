package com.itheima.pattern.combination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        // 创建菜单树
        MenuComponent menu1 = new Menu("菜单管理",2);
        List<String> menu1_2 = new ArrayList<>();
        Collections.addAll(menu1_2,"页面访问","展开菜单","编辑菜单","删除菜单","新增菜单");
        for (String s : menu1_2) {
            menu1.add(new MenuItem(s,3));
        }

        MenuComponent menu2 = new Menu("权限配置",2);
        List<String> menu2_2 = new ArrayList<>();
        Collections.addAll(menu2_2,"页面访问","提交保存");
        for (String s : menu2_2) {
            menu2.add(new MenuItem(s,3));
        }

        MenuComponent menu3 = new Menu("角色管理",2);
        List<String> menu3_2 = new ArrayList<>();
        Collections.addAll(menu3_2,"页面访问","新增角色","修改角色");
        for (String s : menu3_2) {
            menu3.add(new MenuItem(s,3));
        }

        MenuComponent component = new Menu("系统管理",1);
        component.add(menu1);
        component.add(menu2);
        component.add(menu3);

        component.print();
    }
}
