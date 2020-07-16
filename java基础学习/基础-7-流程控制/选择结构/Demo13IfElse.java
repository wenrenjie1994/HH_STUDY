package practice;

public class Demo13IfElse {
	public static void main(String[] args) {
		int num = 14;
		//判断num是奇数还是偶数
		if(num % 2 != 0) {
			System.out.println(num+"是奇数");
			
		}else {
			System.out.println(num+"是偶数");
		}
		
/*
多重if..else嵌套的情形：
x和y关系满足如下：
如果x>=3，那么y=2x+1；
如果-1<x<3，那么y=2x；
如果x<=-1，那么y=2x-1；
 */
		int x=2;
		int y;
		if (x >= 3) {
			y = 2 * x + 1;
			System.out.println(y + "=2*x+1");
		} else if( x > -1 ) {
			y=2*x;
			System.out.println(y+"=2*x");
		}else {
			y=2*x-1;
			System.out.println(y+"=2*x-1");
		}

	}

}
