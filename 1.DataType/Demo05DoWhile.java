/* do{
	循环体;
	步进语句;
}while(布尔表达式); */
//至少执行一次
public class Demo05DoWhile{
	public static void main(String args[]){
		int i = 102;
		do{
			i++;
		}while(i<=100);
		System.out.println(i); //103
	}
}