/**
 * @program: HH_STUDY
 * @description:编写一个方法验证一个IP地址的格式是否正确，正确返回true，不正确返回false
 * 常用的String方法：
 * 1.charAt(int index):获取指定索引处的字符
 * 2.indexOf(String str):获取str在字符串对象中第一次出现的索引
 * 3.substring(int start):从start开始截取字符串
 * .......
 * @author: qiu haoran
 * @create: 2020-07-18 23:03
 */
public class Ip地址校验 {
    //IP地址由4部分构成，即a.b.c.d，每个部分是0~255的整数
    public boolean ipjy(String ip){
        String [] ipstr=ip.split("\\.");
        int len=ipstr.length;
        if(len!=4)
            return  false;
        while(len>0){
//            String转化为Int
            len--;
            try {
               int temp=Integer.parseInt(ipstr[len]);
               if(!(0<=temp&&temp<=255))
                   return false;
            }catch (NumberFormatException e){
                //在web中避免使用该方法，会导致内存溢出
                e.printStackTrace();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Ip地址校验 ip= new  Ip地址校验();
        if(ip.ipjy("a.b.12.2"))
            System.out.println("true");
        else{
            System.out.println("false");
        }
    }

    public void StrDemo(){
        String str="中华有为123abc";
//       1.charAt(int index):获取指定索引处的字符
        char s=str.charAt(2);
//       2.int indexOf(String str, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
        int  i=str.indexOf('中');
//       3.String substring(int start,int end):从start开始，到end结束截取字符串。包括start，不包括end
        String s3=str.substring(0,4);
//       4.toCharArray():把字符串转换为字符数组
        char [] s4=str.toCharArray();
//       5.大小写字符串转换
        String s5=str.toLowerCase();
        s5.toUpperCase();
//       6.split():去除字符串中指定的的字符，然后返回一个新的字符串
        String [] s6=str.split("//.");
        s6=str.split("//.|,",3);//分类份数3,.和，都做分隔符
//       7.replace(char oldChar, char newChar)：将指定字符替换成另一个指定的字符
        String s7=str.replace('a','b');
//       8.contains(CharSequence s)：查看字符串中是都含有指定字符
        String s8="中华";
        boolean flag8=str.contains(s8);
//       9.concat(String str)：在原有的字符串的基础上加上指定字符串
        String s9=str.concat("111");
        s9=s9+"222";
    }

}
