
//求1——100中偶数的和
public class DemoPractise{
	public static void main(String[] args){
		
		int a = 1;
		int sum2 = 0;
		while(a<=100){
			if(a%2==0){
			sum2+=a;}
			a++;
		}
			System.out.println("while结果为："+sum2);
		
	}
}