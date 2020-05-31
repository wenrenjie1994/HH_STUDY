public class CharacterDemo {
    public static void main(String[] args) {

        System.out.println(Character.isLetter('a'));//判断是否为字母
        System.out.println(Character.isDigit('a')); //判断是否为数字
        System.out.println(Character.isWhitespace(' ')); //是否是空白
        System.out.println(Character.isUpperCase('a')); //是否是大写
        System.out.println(Character.isLowerCase('a')); //是否是小写

        System.out.println(Character.toUpperCase('a')); //转换为大写
        System.out.println(Character.toLowerCase('A')); //转换为小写

      //  String a = 'a'; //不能够直接把一个字符转换成字符串
     //   String a2 = Character.toString('a'); //转换为字符串

    }
}
