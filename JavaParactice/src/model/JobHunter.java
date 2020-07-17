package model;

public class JobHunter
{
    private String name;
    private Gender gender;
    private Integer age;
    private Degree degree;
    private Stage stage;

    public JobHunter(String name, Gender gender,
                     Integer age, Degree degree,
                     Stage stage)
    {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.degree = degree;
        this.stage = stage;
    }

    public String getName() { return name;  }
    public Gender getGender(){ return gender; }
    public Integer getAge() { return age; }
    public Degree getDegree() { return degree; }
    public Stage getStage() { return stage; }

    public void setName(String name) { this.name = name; }
    public void setGender(Gender gender) { this.gender = gender; }
    public void setAge(Integer age) { this.age = age; }
    public void setDegree(Degree degree) { this.degree = degree; }
    public void setStage(Stage stage) { this.stage = stage; }
}
enum Gender
{
    MALE("男"),FEMALE("女");
    private final String chinese;
    private Gender(String chinese) { this.chinese = chinese; }

    public String getChainese() { return chinese; }
}
enum Degree
{
    BACHELOR("学士"),MASTER("硕士"),DOCTOR("博士");
    private final String chinese;
    private Degree(String chinese) {this.chinese = chinese;}

    public String getChinese(){return chinese;}
}
enum Stage
{
    RESUME("简历接收"),INTERVIEW("面试通过"),
    OFFER("OFFER已发送"),EXAMINATION("体检通过"),
    BACKGROUND("背调通过"),SIGN("签约完成");

    private final String chinese;
    private Stage(String chinese){ this.chinese = chinese; };

    public String getChinese() { return chinese; }
}