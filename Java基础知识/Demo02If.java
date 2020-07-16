/*
流程：顺序、判断、选择

switch 语句使用的注意事项：
1.多个case后面的数值不可以重复
2.switch后面的小括号里只能放  
基本数据类型 byte/short/char/int类型的数据
引用数据类型 ：String 字符串、enum枚举
3.switch语句格式可以很灵活，前后顺序可以颠倒，而且break语句还可以省略。
“匹配哪个case就从哪个位置开始向下执行，直到遇到break或者整体结束为止。”
*/

public class Demo02If{
	public static void main(String[] arge){
		System.out.println("今天天气不错");
		int age=16;
		
		///单if语句
		if(age>=18){
			System.out.println("进入网吧");
		}
		System.out.println("回家吃饭");
		
		//if ...else... 语句
		//判断奇偶
		int num=13;
		if(num%2==0){
			System.out.println("偶数");
		}else{
			System.out.println("奇数");
		}
		
		//if...else if...else...语句
		/*
		if(判断语句){
			
			语句体
			
		}else if(判断语句){
			
			语句体	
		}
		。。。
		else  if (判断语句){
			
			语句体
		}else{
			  
			语句体
		}
		
		*/
		
		//使用三元运算符和标准的if。。else..语句分别实现：去两个数字当中的最大值
		
		int a=10;
		int b=20;
		
		//三元运算符
		int max=a>b?a:b;
		System.out.println("最大值："+max);//最大值：20
		
		//使用if  else
		int max1;
		if(a>b){
			max1=a;
		}else{
			max1=b;
		}
		System.out.println("最大值："+max1);
	
		
	}
}