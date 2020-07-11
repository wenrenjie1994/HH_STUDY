import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class ArrayListExercise {

    public static void main(String[] args) throws Exception{

        //创建EmpManage对象1
        EmpManage em = new EmpManage();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //做出一个简易菜单
        while (true){
            System.out.println("请选择你要进行的操作：");
            System.out.println("1:添加一个职员 ");
            System.out.println("2:查找一个职员 ");
            System.out.println("3:修改职员薪水 ");
            System.out.println("4:删除一个职员 ");
            System.out.println("5:退出系统 ");

            String option = br.readLine();
            if(option.equals("1")){
                System.out.println("请输入员工编号：");
                String empNu = br.readLine();
                System.out.println("请输入员工名字：");
                String empName = br.readLine();
                System.out.println("请输入员工薪水：");
                float empSal = Float.parseFloat(br.readLine());

                Emp emp = new Emp(empNu,empName,empSal);
                em.addEmp(emp);
            }
            else if(option.equals("2")){
                System.out.println("请输入要查询员工编号：");
                String empNu = br.readLine();

                em.showInfo(empNu);
            }
            else if(option.equals("3")){
                System.out.println("请输入要修改薪水的员工姓名：");
                String empName = br.readLine();
                System.out.println("请输入该员工修改后的薪水：");
                float empSal = Float.parseFloat(br.readLine());

                em.updateSal(empName,empSal);
            }
            else if(option.equals("4")){
                System.out.println("请输入要删除员工姓名：");
                String empName = br.readLine();

                em.delEmp(empName);
            }
            else if(option.equals("5")){
                //退出java虚拟机
                System.exit(0);
            }
        }
    }
}

//雇员管理类
class EmpManage{
    private ArrayList al = null;    //尝试去掉null

    //构造函数
    public EmpManage(){
        al = new ArrayList();
    }

    //加入雇员
    public void addEmp(Emp emp){
        al.add(emp);
    }

    //显示员工相关的信息
    public void showInfo(String empNu){

        int count=0;
        //便利整个ArrayList
        for(int i=0;i<al.size();i++){
            //取出Emp对象
            Emp emp = (Emp)al.get(i);

            //比较编号
            if(emp.getEmpNu().equals(empNu)){
                count++;
                System.out.println("找到了他的信息！");
                System.out.println("编号: " + empNu);
                System.out.println("姓名: " + emp.getName());
                System.out.println("薪资：" + emp.getSal());
            }
        }
        if(count==0){
            System.out.println("没有找到这个家伙！");
        }
    }

    //修改薪水
    public void updateSal(String name,float sal){

        int count=0;
        for(int i=0;i<al.size();i++){
            Emp emp =(Emp)al.get(i);

            if(emp.getName().equals(name)){
                count++;
                emp.setSal(sal);
            }
        }
        if(count==0){
            System.out.println("没有找到这个家伙啊，请先添加员工信息才能修改薪水！");
        }
    }

    //删除员工
    public void delEmp(String name){

        int count=0;
        for(int i=0;i<al.size();i++){
            Emp emp = (Emp)al.get(i);

            if(emp.getName().equals(name)){
                count++;
                al.remove(i);
            }
        }
        if(count==0){
            System.out.println("没有找到这个家伙，无法删除，请先加入员工信息！");
        }
    }
}

//雇员类
class Emp{
    public String getEmpNu() {
        return empNu;
    }

    public void setEmpNu(String empNu) {
        this.empNu = empNu;
    }

    public float getSal() {
        return sal;
    }

    public void setSal(float sal) {
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Emp(String empNu,String name,float sal){
        this.empNu = empNu;
        this.name = name;
        this.sal = sal;
    }

    private String empNu;
    private float sal;
    private String name;

}
