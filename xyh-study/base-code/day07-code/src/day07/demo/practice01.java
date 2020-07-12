package day07.demo;
/*
题目:
定义一个方法，把数组{1，2，3}按照指定格式拼接成一个字符串。格式参照如下
[word1#word2#word3]
*/
public class practice01 {
    public static void main(String[] args) {
        int [] array={1,2,3};

        System.out.println(fromArrayToString(array));

    }

    public static String fromArrayToString(int[] array) {

        String str="[";
        for (int i = 0; i < array.length; i++) {
            if(i==array.length-1){
                //类型转换，string+int->string
                str+="world"+array[i]+"]";
            }else {
                str += "world" + array[i] + "#";
            }

        }

            return str;
    }
}