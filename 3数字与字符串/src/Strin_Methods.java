public class Strin_Methods {
    public static void main(String[] args) {

        String str="xiaolanJava";
        System.out.println("str长度为"+str.length());
        //截取字符
        System.out.println("str长度为"+str.charAt(2));

        //截取多个字符
        char[] str2=new char[20];
        str.getChars(0,5,str2,0);
        System.out.println(str2);

        //字符串转数组
        byte b[]=str.getBytes();
        System.out.println(new String(b));

        //字符串转换为字符数组
        char[] str3=str.toCharArray();
        System.out.println(str3);

        //判断字符串是否相等
        String str4="xiaolanJava2";
        System.out.println(str.equals(str4));
        System.out.println(str.equalsIgnoreCase(str4));

        //stratwith判断字符串是不是以特定的字符开头或结束

        System.out.println(str.startsWith("ja"));
        System.out.println(str.endsWith("rg"));

        //大小写
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());

        //concat字符串连接
        System.out.println(str.concat(str4));

        //去掉收尾空格
        String str5="    hello   n ";
        System.out.println(str5.trim());

        //截取字符串
        System.out.println(str.substring(0, 5));

       //indexOf 查找字符或字符串第一次出现的地方，后者是查找字符或字符串最后一次出现的地方
        System.out.println(str.indexOf("j"));



    }
}
