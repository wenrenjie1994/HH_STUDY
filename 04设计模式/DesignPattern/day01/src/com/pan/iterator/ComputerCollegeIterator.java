package com.pan.iterator;

import java.util.Iterator;

public class ComputerCollegeIterator implements Iterator {

    //需要知道department是以什么样的方式存放的
    Department[] departments;
    int position = 0; //遍历的位置

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    //判断是否还有下一个元素
    @Override
    public boolean hasNext() {
        if(position >= departments.length || departments[position] == null){
        //如果遍历的位置大于等于数组的长度或者为空，就没有下一个
            return false;
        }else{
            return true;
        }
    }


    @Override
    public Object next() {
        Department department = departments[position];
        position += 1;
        return position;
    }

    //删除的方法默认空实现
    @Override
    public void remove() {

    }
}
