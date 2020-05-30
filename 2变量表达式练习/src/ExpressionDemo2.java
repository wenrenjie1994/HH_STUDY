/**
 * 关系运算符
 */
public class ExpressionDemo2 {
    public static void main(String[] args){
        System.out.println("9.2<5 :"+(9.2<8));
        System.out.println("7.5<=7.5:"+(7<=7.5));
        System.out.println("a~z："+((int)'a')+"~"+((int)'z'));//a~z：97~122
        System.out.println("A~Z："+((int)'A')+"~"+((int)'Z'));//A~Z：65~90
        System.out.println("'A' < 'a':"+('A' < 'a'));//字符'A'的Unicode编码值小于字符'a'
    }
}
