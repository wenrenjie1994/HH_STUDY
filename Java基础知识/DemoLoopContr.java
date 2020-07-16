/*
break关键字的用法有常见的两种

1.可以用于switch语句当中，一旦执行，整个switch语句立刻结束
2.可以用于循环语句当中，一旦执行，整个循环立刻结束，打断循环

注意：
凡是次数确定的场景多用for循环，否则多用while循环。

另一种循环控制语句是continue关键字
一旦执行，立刻跳过当前剩余内容，马上开始下一次循环
*/

public class DemoLoopContr{
	public static void main(String[] args){
		for(int i=1;i<10;i++){
			//如果希望从第4次开始，后续全都要了，就要打断循环
			if(i==4){
				break;
			}
			System.out.println("hello");
		}
		
		
		//continue关键字
		for(int i=1;i<10;i++){
			if(i==4){
				continue;
			}
			System.out.println(i+"层到了");//跳过了4层
		}
	}
}