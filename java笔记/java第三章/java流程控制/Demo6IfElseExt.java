public class Demo6IfElseExt{
	public static void main(String[] args){
		int score = 10;
		if(score>=90){
		System.out.println("优秀");
		}
		else if(score<90&&score>=80){
		System.out.println("良好");
		}
		else if(score<80&&score>=70){
			System.out.println("合格");
		}else{
			System.out.println("不合格");
		}
	}
}