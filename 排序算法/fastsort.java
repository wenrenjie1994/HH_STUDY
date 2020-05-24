package demo2;

import java.util.Arrays;

public class fastsort {

	public static void main(String[] args) {
		int[] arr = new int[] {1,5,4,3,12,10,23,15,17,7,2,3,22};
		fast(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void fast(int[] arr, int start, int end) {
		if(start<end) {
			int index = arr[start];
			int low = start;
			int hight = end;
			while(low<hight) {
				while(low<hight && index<=arr[hight]) {
					hight--;
				}
				arr[low] = arr[hight];
				
				while(low<hight && index>=arr[low]) {
					low++;
				}
				arr[hight] = arr[low];
			}
			arr[low] = index;
			fast(arr,start,low);
			fast(arr,low+1,end);
		}	
	}

}
