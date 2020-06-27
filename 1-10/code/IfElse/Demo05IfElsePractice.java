public class Demo05IfElsePractice{
	public static void main(String[] args){
		int score = 120;
		if(score<0 || score>100){
			System.out.println("你的成绩是错误的");
		}else if(score>=90 && score<=100){
			System.out.println("你的成绩属于优秀");
		}else if(score>=80 && score<90){
			System.out.println("你的成绩属于好");
		}else if(score>=70 && score<80){
			System.out.println("你的成绩属于良");
		}else if(score>=60 && score<70){
			System.out.println("你的成绩属于及格");
		}else if(score>=0 && score<60){
			System.out.println("你的成绩属于不及格");
		}else{//单独处理边界之外的不合理情况
			System.out.println("数据错误");
		}
	}
}