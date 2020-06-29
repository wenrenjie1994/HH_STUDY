package com.spdb.study.design.principle.liskosubstitution.methodreturn;

/**
 * @author Mr.Longyx
 * @date 2020年06月17日 22:11
 */
public class MethodReturnTest {
    public static void main(String[] args) {
        Base child = new Child();
        System.out.println(child.method());
    }
}
