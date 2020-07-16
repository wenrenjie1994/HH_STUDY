/*
方法：将一个功能抽取出来
定义一个方法的格式：
public static void 方法名称（）{
	方法体
}

方法名称的命名规则和变量一样，使用小驼峰
方法体：也就是大括号当中可以包含任意语句

1.定义位置：类的里面，main的外面
2.方法的定义的先后顺序无所谓
3.方法的定义不能产生嵌套包含关系

方法的调用
格式：方法名称();

*/
public class Demo11Method{
	public static void main(String[] args){
		cook();//调用厨子的方法
	}
}

public static void farmer(){
	System.out.println("农民");
}

public static void seller(){
	System.out.println("商贩");
}

public static void cook(){
	System.out.println("厨师");
}

public static void me(){
	System.out.println("吃");
}