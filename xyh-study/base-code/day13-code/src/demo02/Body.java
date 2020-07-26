package demo02;

public class Body {//外部类


    public class Heart{//成员内部类
        public void beat(){
            System.out.println("心脏跳动，蹦蹦蹦！");
            System.out.println("我叫："+name);//正确写法
        }

    }

    private String name;
    public void methodBody(){
        System.out.println("外部内的方法");
        new Heart().beat();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
