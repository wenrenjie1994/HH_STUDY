package demo2;

import java.util.Arrays;

public class xiersort {
	public static void main(String[] args) {
		int[] arr = new int[] {1,5,4,3,12,10,23,15,17,7,2,3,22};
		shellsort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void shellsort(int[] arr) {
		int step = arr.length/2;
		for(int s=step;s>0;s/=2) {
			for(int i=s;i<arr.length;i++) {
				//遍历本组中所有的元素
				for(int j=i-s;j>=0;j-=s) {
					if(arr[j]>arr[j+s]) {
						int temp = arr[j];
						arr[j]=arr[j+s];
						arr[j+s] = temp;
					}
				}
				
			}
		}
	}
}
