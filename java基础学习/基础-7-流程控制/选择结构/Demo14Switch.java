package practice;
/*
1.switch语句格式：
	switch(表达式) {
		case 常量值1:
		         语句体1;
		   break;
		case 常量值2:
		         语句体2;
		   break;
		...
		default:
			语句体n+1;
			break;
	}
2.执行流程：
	1）首先计算出表达式的值；
	2）其次，和case依次比较，一旦有对应的值，就会执行相应的语句，在执行过程中，遇到break就会结束；
	3）最后，如果所有的case都和表达式的值不匹配，就会执行default语句体部分，之后整体结束。
3.注意事项：
	1）多个case后面的数值不可以重复；
	2）switch后面小括号当中只能是下列数据类型：
		a.基本数据类型：byte、short、char、int
		b.引用数据类型：String字符串、enum枚举
	3）switch语句格式可以很灵活：前后顺序可以颠倒，而且break语句还可以省略
		“匹配哪一个case就从哪一个位置向下执行，直到遇到了break或者整体结束为止”
 */
public class Demo14Switch {

	public static void main(String[] args) {
		int num = 6;
		switch (num) {
			case 1:
				System.out.println("星期一");
				break;
			case 2:
				System.out.println("星期二");
				break;
			case 3:
				System.out.println("星期三");
				break;
			case 4:
				System.out.println("星期四");
				break;
			case 5:
				System.out.println("星期五");
				break;
			case 6:
				System.out.println("星期六");
				break;
			case 7:
				System.out.println("星期七");
				break;
			default:
				System.out.println("数据不合理");
				break; //最后一个break最好不要省略
		}

	}

}
