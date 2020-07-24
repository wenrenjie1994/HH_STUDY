package practice;
/*
获取数组长度的格式：
	数组名称.length，会得到一个int数组，代表数组长度
注意事项：
	数组一旦创建，程序运行期间，长度不可改变
 */
public class Demo28ArrayLength {

	public static void main(String[] args) {
		
		int[] array = {1,23,45,34,22,1,1,12,34,55,33,24,5,6,7,7,8};
		int len;
		len = array.length;
		System.out.println("数组长度："+len);//求出数组长度
		
		int[] arrayC = new int[3];
		System.out.println(arrayC.length);
		arrayC = new int[5];
		System.out.println(arrayC.length);
		System.out.println("===========");
		
		//遍历一个数组
		int[] arrayD = {1,34,53,2};
		for(int i = 0; i < arrayD.length; i++) {
			System.out.println(arrayD[i]);
		}
		System.out.println("============");
		
		//求数组arrayD中的最值
		int max = arrayD[0];
		for(int i = 1; i < arrayD.length; i++) {
			if(arrayD[i] > max) {
				max = arrayD[i];
			}
		}
		System.out.println("数组arrayD的最大值：" + max);
		System.out.println("===========");
		
		//求数组ArrayD的反转，不能使用新数组，只能用原数组进行反转
		for(int low = 0, high = arrayD.length - 1; low < high; low++, high--) {
			int temp = arrayD[low];
			arrayD[low] = arrayD[high];
			arrayD[high] = temp;
		}
		for(int i = 0; i < arrayD.length; i++) {
			System.out.println(arrayD[i]);
		}
		
	}

}
