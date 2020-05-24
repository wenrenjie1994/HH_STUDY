package demo2;

import java.util.Arrays;

public class insertsort {
	public static void main(String[] args) {
		int[] arr = new int[] {1,5,4,3,12,10,23,15,17,7,2,3,22};
		insort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void insort(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			//遍历所有数字
			if(arr[i]<arr[i-1]) {
				int temp = arr[i];
				int j;
				for(j=i-1;j>=0&&arr[j]>temp;j--) {
					arr[j+1] = arr[j];
				}
				arr[j+1] = temp;
			}
		}
	}
}
