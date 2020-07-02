package practice;
/*
 标识符：用户自定义的内容。在Java语言中，采用标识符对变量、类和方法进行命名。
命名规则：
°	标识符可以包含英文字母、数字、$、_
°	标识符不能以数字开头
°	标识符不能是关键字
	命名规范：
°	类名规范：首字母大写，后面每个单词首字母大写（大驼峰式）
°	变量名和方法名规范：首字母小写，后面每个单词首字母大写（小驼峰式）

 */
public class HelloWorld {//类名：HelloWorld-大驼峰式
	int myHello; //变量名：myHello-小驼峰式
    void myWorld() { //方法名：myWorld-小驼峰式
       System.out.println("Hello World");
  }
}
