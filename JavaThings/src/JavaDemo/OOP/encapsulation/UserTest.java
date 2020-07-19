package JavaDemo.OOP.encapsulation;

public class UserTest {
    public static void main(String[] args) {
        User user = new User();
        user.code();
    }

}

class User {
    //filed
    String name;
    int age;

    //method
    public void code() {
        String programLanguage = "Java";        //局部变量
        System.out.println("use " + programLanguage);
    }
    public void speak(String language) {        //language 形参
        System.out.println("The mother language is " + language);
    }
}
