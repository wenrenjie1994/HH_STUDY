package practice;
//单if语句：先做判断，满足条件执行，不满足条件跳过if结构执行后面的语句
public class Demo12If {
	public static void main(String[] args) {
		System.out.println("想去网吧");
		int age = 16;
		if(age>=18) {
			System.out.println("可以去网吧啦~");
			System.out.println("不好玩，还是回去了");
		}
		System.out.println("回家！");
		
	}

}
