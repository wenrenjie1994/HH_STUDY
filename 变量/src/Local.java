public class Local {
    /*局部变量
    ⽅法中的变量
    声明在⽅法、构造⽅法、语句块、形式参数等
    ⽣命周期当它们执⾏完成后，变量将会被销毁
    访问修饰符不能⽤于局部变量
    局部变量没有初始值，必须初始化后才可以被使⽤*/



    //年龄
    private int age;

    //姓名
    private String name;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //⾃我介绍⽅法
    public String introduce(){
        //介绍前缀
        String PREFIX = "我是叫";
        String content = PREFIX + name + "，年龄是" + age;
        return content;
    } }

