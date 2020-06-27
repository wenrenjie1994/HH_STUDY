/*
题目：求出1-100之间的偶数和。

思路：
1.计入范围已经确定了是1到100之间，那么就从1、2、3.。。一直到100这么多数值一个一个进行检查。
2.总共有100个数字，并非所有数字都能用。必须要是偶数才能用，判断（if）偶数：num%2==0
3.需要一个变量，用来进行累加操作。
*/
public class Demo12HundredSum{
	public static void main(String[] args){
		int sum = 0;
		
//		for(int i=1; i<=100;i++){
//			if(i%2 == 0){//如果是偶数
//				sum+=i;
//			}
//		}
//		System.out.println("结果是：" + sum);

	int i=1;
	while(i<=100){
			if(i%2 == 0){//如果是偶数
				sum+=i;
			}
			i++;
			//System.out.println("结果是：" + sum);
	}
	System.out.println("结果是：" + sum);
	}
}