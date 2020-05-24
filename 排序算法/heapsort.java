package demo2;

import java.util.Arrays;

public class heapsort {
	public static void main(String[] args) {
		int[] arr = new int[] {1,5,4,3,12,10,23,15,17,7,2,3,22};
		
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr) {
		//开始位置是最后一个节点的父节点
		int start = (arr.length-1)/2;
		//结束位置
		for(int i=start;i>=0;i--) {
			maxheap(arr, arr.length, i);
		}
		
		for(int i =arr.length-1;i>0;i--) {
			int temp = arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			maxheap(arr,i,0);
		}
		
	}
	
	
	public static void maxheap(int[] arr, int size, int index) {
		//左子节点
		int leftnode = 2*index+1;
		//右
		int rightnode = 2*index+2;
		int max = index;
		if(leftnode<size && arr[leftnode]>arr[max]) {
			max = leftnode;
		}
		if(rightnode<size && arr[rightnode]>arr[max]) {
			max = rightnode;
		}
		//交换位置
		if(max != index) {
			int temp = arr[index];
			arr[index] = arr[max];
			arr[max] = temp;
			
			maxheap(arr,size,max);
		}
		
	}
}
