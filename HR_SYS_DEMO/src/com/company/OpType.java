package com.company;

public enum OpType {
    ADD(1), REMOVE(2), QUERY(3), DELETE(4), EXIT(5);
    private int value;
    OpType(int i) {
        this.value = i;
    }
    public int getValue(){
        return value;
    }
}
