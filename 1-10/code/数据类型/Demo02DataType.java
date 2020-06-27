public class Demo02DataType{
	public static void main(String[] args){
		//左边是int类型，右边是long类型，不一样
		//long-->int,不是从小到大
		//不能发生自动类型转换
		//格式：范围小的类型 范围小的变量名 = （范围小的类型） 原本范围大的数据；
		int num = (int) 100L;
		System.out.println(num);
		
		//long强制转换成int类型
		int num2 = (int) 6000000000L;
		System.out.println(num2);//1705032704
		
		//double-->int,强制类型转换
		int num3 = (int) 3.99;
		System.out.println(num3);//3，这并不是四舍五入，所有的小数位都会被舍弃掉
		
		char zifu1 = 'A';//这是一个字符型变量，里面是大写字母A
		System.out.println(zifu1 + 1);//66,也就是大写祖母A被当作65进行处理
		//计算机的底层会用一个数字（二进制）类代表字符A，就是65
		//一旦char类型进行了数学运算，那么字符就会按照一定的规则翻译成为一个数字
		
		byte num4 = 40;//注意：右侧的数值大小不能超过左侧的类型范围
		byte num5 = 50;
		//byte + byte -->int + int -->int
		int result1 = num4 + num5;
		System.out.println(result1);//90
		
		short num6 = 60;
		//byte + short -->int + int-->int
		//int强制类型转换为short：注意必须保证逻辑上真实大小本来就没有超过short范围，否则会发生数据溢出
		short resul2 = (short)(num4 + num6);
		System.out.println(resul2);//
		}
}