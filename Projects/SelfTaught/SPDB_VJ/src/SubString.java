public class SubString {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "defdef";
        String str3 = str1+str2.substring(str2.indexOf("e"));
        System.out.println(str3);
    }
}
