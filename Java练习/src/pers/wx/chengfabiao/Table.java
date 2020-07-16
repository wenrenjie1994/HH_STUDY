/**
 * 
 */
package pers.wx.chengfabiao;

/**
 * @author Administrator
 *
 */
public class Table {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//计算并保存九九乘法表，要求重复的部分只保存一个。
	  	/*
	  	设计思想：用不规则的二维数组来保存，
	  	以便节约内存空间。
	  	*/
	  	final int N=9;
	    int a[][]=new int[N][];  //定义二维数组，并指定第一维有9个元素
	    int i,j;
	    
	  	for(i=0;i<N;i++)
	  	  a[i]=new int[i+1];  //定义二维数组维不规则的，其第二维的长度各不相同。
	  	
	  	for(i=0;i<N;i++)  
	  	{
	  		for(j=0;j<=i;j++) a[i][j]=(i+1)*(j+1); //计算并保存乘法表
	  	}

	  	for(i=0;i<N;i++)
	  	{
	  		for(j=0;j<=i;j++)
	  		  System.out.print(" "+a[i][j]);
	  		System.out.println();  //乘法表的每行输出完毕后输出换行
	  	}

	}

}
