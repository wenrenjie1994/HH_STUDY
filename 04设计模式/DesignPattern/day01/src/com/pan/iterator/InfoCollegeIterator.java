package com.pan.iterator;

import java.util.Iterator;
import java.util.List;

public class InfoCollegeIterator implements Iterator {
    List<Department> departmentList;//信息工程学院是以List的方式存放
    int index = -1;//索引

    public InfoCollegeIterator(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    //判断集合中还有没有下一个元素
    @Override
    public boolean hasNext() {
        if (index >= departmentList.size() -1){
            return false;

        }else{
            index += 1;
            return true;
        }
    }

    @Override
    public Object next() {
        return departmentList.get(index);
    }

    //空实现remove

    @Override
    public void remove() {

    }
}
