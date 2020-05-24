package demo2;

public class hannuota {
	public static void main(String[] args) {
		hanoi(10,'a','b','c');
	}
	
	public static void hanoi(int n,char from, char in,char to) {
		if(n==1) {
			System.out.println("第1个盘子从"+from+"移到"+to);
		}else {
			//移动上面的盘子
			hanoi(1,from,to,in);
			//移动下面的
			System.out.println("第"+n+"个盘子从"+from+"移到"+to);
			//把上面的所有盘子从中间位置移动到目标位置
			hanoi(n-1,in,from,to);
		}
	}
}
