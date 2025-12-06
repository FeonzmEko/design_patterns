package com.itheima.pattern.iterator;

import java.util.List;

public class StudentIteratorImpl implements StudentIterator{

    private List<Student> list;
    private int position = 0;

    public StudentIteratorImpl(List<Student> list){
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public Student next() {
        if (!hasNext()) {
            return null;
        }
        Student student = list.get(position);
        position++; // 移动到下一个位置
        return student;
    }

}
