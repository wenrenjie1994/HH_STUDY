package practice;
/*
for循环格式：
	for (初始化表达式;布尔表达式;步进表达式) {
		循环语句;
	}
while循环格式：
	while (条件判断) {
		循环体;
	}
do...while循环格式：
	do {
	    循环体;
	} while(判断条件);
三种循环的区别所在：
	1）如果条件判断从来没有满足过，那么for循环和while循环将会执行0次，而dowhile循环至少执行一次;
	2）for循环的变量在小括号当中定义，只有循环内部才可以使用；
 */
public class Demo15For {

	public static void main(String[] args) {
		//for语句
		for(int i = 1;i <= 100;i++) {
			System.out.println("java"+i);
		}
		System.out.println("stop");
		
		//while语句
		int j=1;
		while (j<=10) {
			System.out.println("java"+j);
			j++;
		}
		
		//do...while语句
		int k = 1;
		do {
			System.out.println("java"+k);
			k++;
		}while(k<=10);
		
		System.out.println("================");
		
/*
题目：求出1-100之间的偶数和、奇数和
 */
		//for循环版
		int OddSum1 = 0;
		int EvenSum1 = 0;
		for(int i = 1;i <= 100; i++) {
			if(i % 2 == 0) {
				EvenSum1 += i;
			}else {
				OddSum1 +=i;
			}
		}
		System.out.println("for偶数和："+EvenSum1);
		System.out.println("for奇数和："+OddSum1);
		
		//while循环版
		int OddSum2 = 0;
		int EvenSum2 = 0;
		int i = 1;
		while(i <=100) {
			if(i % 2 == 0) {
				EvenSum2 += i;
			}else {
				OddSum2 +=i;
			}
			i++;
		}
		System.out.println("while偶数和："+EvenSum2);
		System.out.println("while奇数和："+OddSum2);
		
		//do-while循环版
		int OddSum3 = 0;
		int EvenSum3 = 0;
		int i1 = 1;
		do {
			if(i1 % 2 == 0) {
				EvenSum3 += i1;
			}else {
				OddSum3 +=i1;
			}
			i1++;
		}while(i1 <= 100);
		System.out.println("do-while偶数和："+EvenSum3);
		System.out.println("do-while奇数和："+OddSum3);
	}

}
