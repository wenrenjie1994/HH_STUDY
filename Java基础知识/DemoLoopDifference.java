/*
三种循环的区别

1.如果条件一次都不满足，那么 for循环和while循环将会执行0次，但do-while循环会执行至少一次
2.for循环的变量在小括号当中定义，只有在循环内部才可以使用，while循环和do-while循环初始化语句本来就在外面，所以出来循环之后还可以使用

*/

public class DemoLoopDifference{
	public static void main(String[] args){
		for(int i=1;i<0;i++){
			System.out.println("hello");
		}
		//System.out.println(i)  错误写法  i只能在for循环里使用
		System.out.println("=======")
		
		int i=1;
		do{
			System.out.println("hello");
			i++;
		}while(i<0);
		System.out.println(i);//可以使用
	}
}