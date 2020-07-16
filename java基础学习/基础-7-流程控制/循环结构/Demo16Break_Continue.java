package practice;
/*
break关键字的用法：
	1）可以用在switch语句中，，一旦执行，整个switch语句立刻结束；
	2）循环语句中，一旦执行，整个循环立刻结束；
continue关键字的用法：一旦执行，立刻跳过当前循环剩余内容，马上开始下一次循环
 */
public class Demo16Break_Continue {

	public static void main(String[] args) {
		//只需要循环结果的前三个，则要在第四次循环时进行打断
		for (int i = 1; i<=100; i++) {
			if ( i == 4) {
				break;
			}
			System.out.println("java"+i);
		}
		
		System.out.println("========");
		
		//
		for (int i =1 ; i <= 10; i++) {
			if( i ==4) {
				continue; //跳过第四次的循环结果
			}
			System.out.println("java"+i);
		}

	}

}
