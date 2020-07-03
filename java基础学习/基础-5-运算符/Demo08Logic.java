package practice;
/*
逻辑运算符：%%(与)、||(或)、!(非)
注意：
	1.逻辑运算符只能用于boolean值
	2.与、或需要左右各自有一个boolean值，但是取反只要有唯一的一个boolean值即可
	3.与、或两种运算符，如果有多个条件，可以连续写，如：条件A && 条件B && 条件C
	对于 1<x<3的情况，应这样表示：
		int x = 2;
		1 < x && x <3
 */
public class Demo08Logic {

	public static void main(String[] args) {
		System.out.println(3<4 && 10>5);//true

		//&&、||具有短路效果，即如果根据左边已经可以判断得到最终结果，那么右边的代码将不再执行
		int a = 10;
		System.out.println(3>4 && ++a <100);//false
		System.out.println(a);//10
	}

}