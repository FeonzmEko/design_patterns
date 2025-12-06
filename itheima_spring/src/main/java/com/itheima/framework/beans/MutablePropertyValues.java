package com.itheima.framework.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MutablePropertyValues implements Iterable<PropertyValue>{

    // 定义List集合对象，用来存储PropertyValue对象
    private final List<PropertyValue> propertyValueList;

    public MutablePropertyValues() {
        this.propertyValueList = new ArrayList<>();
    }

    public MutablePropertyValues(List<PropertyValue> list) {
        if(list == null){
            this.propertyValueList = new ArrayList<>();
        } else {
            this.propertyValueList = list;
        }
    }

    // 获取所有的PropertyValue对象，返回以数组的形式
    public PropertyValue[] getPropertyValues(){
        return (PropertyValue[]) propertyValueList.toArray();
    }

    // 根据name属性值来获取PropertyValue对象
    public PropertyValue getPropertyValue(String name){
        PropertyValue target = null;
        for (PropertyValue propertyValue : propertyValueList) {
            if (propertyValue.getName().equals(name)){
                target = propertyValue;
            }
        }
        return target;
    }

    // 判断集合是否为空
    public boolean isEmpty(){
        return propertyValueList.isEmpty();
    }

    // 添加元素
    public void addPropertyValue(PropertyValue pv){
        // 判断是否重复，重复则进行覆盖
        for (PropertyValue propertyValue : propertyValueList) {
            if (propertyValue.getName().equals(pv.getName())){
                propertyValue.setValue(pv.getValue());
                propertyValue.setRef(pv.getRef());
                return;
            }
        }
        propertyValueList.add(pv);
    }

    // 判断是否有指定name属性的对象
    public boolean contains(String name){
        return this.getPropertyValue(name) != null;
    }

    @Override
    public Iterator<PropertyValue> iterator() {
        return propertyValueList.iterator();
    }
}
