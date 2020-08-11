
// 创建一个长度是100的字符串数组，使用长度是2的随机字符填充该字符串数组，
// 统计这个字符串数组里重复的字符串有多少种

public class TestStr {
	public static void main(String[] args) {
		String [] arr1 = new String[100];
		Arrays.fill(arr1, "0");
		String[] arr2 = new String[2];
		for (int i = 0; i < arr1.length; ++i) {
			for (int j = 0; j < 2; ) {
				char c = (char)(new Random().nextInt(75) + 48);
				if (Character.isLetterOrDigit(c)) {
					arr2[j++] = c + "";
				}
			}
			String s = arr2[0] + arr2[1];
			arr1[i] = s;
			if (i % 10 == 0 && i != 0) {
				System.out.println();
			}
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		Arrays.sort(arr1);
		int num = 0;
		for (int i = 0; i < arr1.length - 1; ++i) {
			if (Objects.equals(arr1[i], arr1[i + 1])) {
				num++;
				System.out.print(arr1[i] + " ");
			}
		}
		System.out.println("重复的共有： " + num + "种");
	}
}