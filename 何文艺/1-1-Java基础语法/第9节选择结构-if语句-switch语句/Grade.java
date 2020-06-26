public class Grade {
    public static void main(String[] args) {
        int score = 100;
        if(score < 0 || score > 100) {
            System.out.println("你的成绩是错误的!");
        } else if(score < 60) {
            System.out.println("不及格!");
        } else if(score < 70) {
            System.out.println("及格！");
        } else if(score < 80) {
            System.out.println("良！");
        } else if(score < 90) {
            System.out.println("好！");
        } else {
            System.out.println("优秀！");
		}
    }
}