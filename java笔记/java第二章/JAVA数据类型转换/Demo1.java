public class Demo1{
	public static void main (String[] args){
		int num = (int)100l;
		System.out.println(num);
		//long强制转换为int型
		int num2 = (int)3.9;
		System.out.println(num2);
		//double-->int 强制转换
		char ziful = 'A';
		System.out.println(ziful+1);
		//计算机底层会用一个数字（二进制）来表示字符A
		byte num3 = 40;
		byte num4 = 50;
		int result = num4+num3;
		System.out.println(result);
		//byte+byte-->int +ｉｎｔ－－＞ｉｎｔ
	}
}