package com.itheima.pattern.iterator;

public class Client {
    public static void main(String[] args) {
        // 创建聚合对象
        StudentAggregateImpl aggregate = new StudentAggregateImpl();

        // 添加聚合元素
        aggregate.addStudent(new Student("张春韬","东大 cs 在读"));
        aggregate.addStudent(new Student("张春韬老婆1","大熊"));
        aggregate.addStudent(new Student("张春韬老婆2","前凸后翘"));
        aggregate.addStudent(new Student("张春韬老婆3","清纯"));

        // 迭代器对象
        StudentIterator iterator = aggregate.getStudentIterator();

        // 迭代器遍历
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
