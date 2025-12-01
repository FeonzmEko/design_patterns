package com.itheima.pattern.factory.config_factory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CoffeeFactory {
    // 定义容器来存储对象
    private static Map<String,Coffee> map = new HashMap<>();

    // 加载配置文件，加载一次
    static {
        // 创建properties对象
        Properties p = new Properties();
        // 调用load方法进行配置文件的加载
        InputStream is = CoffeeFactory.class.getClassLoader().getResourceAsStream("bean.properties");

        try {
            p.load(is);
            // 从p集合获取全类名并获取对象
            Set<Object> keys = p.keySet();
            for (Object key : keys) {
                String className = p.getProperty((String) key);
                // 通过反射技术创建对象
                Class clazz = Class.forName(className);
                Coffee coffee = (Coffee) clazz.newInstance();
                // 将名称和对象存储到容器中
                map.put((String) key,coffee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Coffee createCoffee(String name){
        return map.get(name);
    }
}
