package oo.method;

//为英雄类Hero设计几个新的方法：
//        1. 超神 legendary(),无参数，无返回类型
//        2. 获取当前的血量 getHp(), 无参数，有float类型的返回值
//        3. 回血 recovery(float blood)， 有参数 float类型参数 blood表示本次恢复的血量，无返回类型

public class Hero {
    String name; //姓名
    float hp; //血量
    float armor; //护甲
    int moveSpeed; //移动速度

    void legendary(){
        System.out.println("已超神");
    }

    float getHp(){
        return hp;
    }

    void recovery(float blood){
        hp += blood;
    }

}
