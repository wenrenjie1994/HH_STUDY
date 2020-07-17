import java.util.regex.*;
public class RegularExpression{
	public static void main(String[] argc){
		String content = "I am noob" + "from runoob.com";
		
		String pattern = ".*runoob.*";
		
		boolean isMatch = Pattern.matches(pattern, content);
		System.out.println("字符串中是否包含了‘runoob’串？" + isMatch);
	}
}