package practice;
/*
练习题1：比较两个数据是否相等，数据类型分别为两个byte、两个short、两个int、两个long
 */
public class Demo23MethodOverloadPractice {

	public static void main(String[] args) {
		System.out.println(isEqual((byte)10, (byte)20));
		System.out.println(isEqual((short)10, (short)10));
		System.out.println(isEqual(20, 20));
		System.out.println(isEqual((long)10, (long)20));
	}
	
	public static boolean isEqual(byte a,byte b) {
		System.out.println("两个byte参数的方法执行！");
		boolean equal;
		if(a == b) {
			equal = true;
		}else {
			equal = false;
		}
		return equal;
	}
	
	public static boolean isEqual(short a,short b) {
		System.out.println("两个short参数的方法执行！");
		boolean equal = a == b ? true : false;
		return equal;
	}
	
	public static boolean isEqual(int a,int b) {
		System.out.println("两个int参数的方法执行！");
		return a == b;
	}
	public static boolean isEqual(long a,long b) {
		System.out.println("两个long参数的方法执行！");
		if(a == b) {
			return true;
		}else {
			return false;
		}
	}

}
