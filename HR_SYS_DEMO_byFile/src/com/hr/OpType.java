package com.hr;

public enum OpType {
    ADD('1'), DELETE('2'), QUERY('3'), MODIFY('4'), EXIT('5'), HELP('?');
    private char value;
    OpType(char ch) {
        this.value = ch;
    }
    public char getValue(){
        return value;
    }
}
