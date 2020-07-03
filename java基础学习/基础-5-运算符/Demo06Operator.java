package practice;
/*
自增运算符：++
自减运算符：--

使用方式：
	1.单独使用：不和其他任何操作混合，自己独立成为一个步骤
	2.混合使用：和其他操作混合，例如与赋值混合，或者打印操作混合等
使用区别：
	1.在单独使用时，++a和a++没有区别
	2.混合使用时：
		a.如果前++，那么变量先＋1再做接下来的操作
		b.如果后++，那么先做操作再+1
 */
public class Demo06Operator {
	public static void main(String[] args) {
		int num1 = 10;
		System.out.println(num1);//10
		++num1;//单独使用，前++
		System.out.println(num1);//11
		num1++;//单独使用，后++
		System.out.println(num1);//12
		System.out.println("============");
		
		//与打印操作混合使用时
		int num2 = 20;
		System.out.println(++num2);//21,先加1再打印
		System.out.println(num2++);//21,先打印再+1
		System.out.println(num2);//22
		
		//与赋值操作混合时
		int num3 = 40;
		int result1 = --num3;//前--
		System.out.println(result1);//39
		System.out.println(num3);//39
		System.out.println("========");
		
		int num4 = 50;
		int result2 = num4--;//后--
		System.out.println(result2);//50
		System.out.println(num4);//49
		System.out.println("=========");
		
		//自增自减混合的复杂运算
		int x = 10;
		int y = 20;
		int result3 = ++x + y++;
		System.out.println(result3);//31
		System.out.println(x);//11
		System.out.println(y);//21
	}

}