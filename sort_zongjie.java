import java.util.Arrays;

public class sort_zongjie {

	public static void main(String[] args) {
		int[] arr = new int[] {1,5,4,3,12,10,23,15,17,7,2,3,22};
		//maopao(arr);
		fast(arr,0,arr.length-1);
		//selectsort(arr);
		//insert(arr);
		//xiersort(arr);
		//guibing(arr,0,arr.length-1);
		//heapsort(arr);
		System.out.println(Arrays.toString(arr));
	}
	//冒泡
	public static void maopao(int[] arr) {
		int temp;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	//快速
	public static void fast(int[] arr,int start,int end) {
		if(start>=end) {
			return;
		}
		int index = arr[start];
		int left = start;
		int right = end;
		while(left<right) {
			while(arr[right]>index && right>left) {
				right--;
			}
			if(left<right){
				arr[left++] = arr[right];
			}
			while(arr[left]<index && right>left){ //找到左边比基数大的数字
				left++;
			}
			if(left<right){
				arr[right--] = arr[left];
			}	
			
			arr[left] = index;
			fast(arr,start,left-1);
			fast(arr,left+1,end);
		}
		
	}
	
	//选择排序
	public static void selectsort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int min = i;
			for(int j=i;j<arr.length;j++) {
				if(arr[j]<arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}	
	}
	
	//插入排序,将小的元素插入到之前排好序的数组中，比如打扑克牌的排序
	public static void insert(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j>0;j--) {
				if(arr[j]<arr[j-1]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}else {
					break;
				}
			}
		}
	}
	
	//希尔排序...基于插入排序的高效版本
	public static void xiersort(int[] arr) {
		int step = arr.length/2;
		for(int s=step;s>0;s/=2) {
			for(int j=s;j<arr.length;j++) {
				for(int i=j-s;i>=0;i-=s) {
					if(arr[i]>arr[i+s]) {
						int temp = arr[i+s];
						arr[i+s] = arr[i];
						arr[i] = temp;
					}
				}
			}
		}
	}
	
	//归并排序..
	public static void guibing(int[] arr, int first, int last) {
		if(first<last) {
			int mid = (first+last)/2;
			guibing(arr,0,mid);
			guibing(arr,mid+1,last);
			merge(arr,0,mid,last);
		}
	}
	public static void merge(int[] arr,int first,int mid, int last) {
		int i,j,k;
		int Llength = mid-first+1;
		int Rlength = last-mid;
		int[] L = new int[Llength];
		int[] R = new int[Rlength];
		//存放左边数组
		for(i=0,k=first;i<Llength;i++,k++) {
			L[i] = arr[k];
		}
		for(j=0,k=mid+1;j<Rlength;j++,k++) {
			R[j] = arr[k];
		}
		//二路归并
		for(i=0,j=0,k=first;i<Llength && j<Rlength;i++,j++) {
			if(L[i]<R[j]) {
				arr[k] = L[i];
				k++;
			}else {
				arr[k] = R[j];
				k++;
			}
		}
		//剩余的放入arr
		if(i<Llength) {
			for(i=j;i<Llength;i++) {
				arr[k] = L[i];
				k++;
			}
		}
		if(j<Rlength) {
			for(j=i;j<Rlength;j++) {
				arr[k] = R[j];
				k++;
			}
		}
	}
	
	//堆排序
	public static void heapsort(int[] arr) {
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
	//构建大顶堆
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
