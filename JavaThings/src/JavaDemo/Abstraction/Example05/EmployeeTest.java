package JavaDemo.Abstraction.Example05;

import JavaDemo.OOP.Polymorphic.Example03.Person;

public class EmployeeTest {
    public static void main(String[] args) {
        //polymorphic
        Employee manager = new Manager("KuKe", 0001, 20000, 50000);
        manager.work();

        Employee commonEmployee = new CommonEmployee();
        commonEmployee.work();

        //非匿名类的非匿名对象
        CommonEmployee commonEmployee1 = new CommonEmployee();
        method1(commonEmployee1);

        //非匿名类的匿名对象
        method1(new Manager(20000));

        //匿名子类的对象
        Employee employee = new Employee() {
            @Override
            public void work() {
                System.out.println("8 hours");
            }
        };
        method1(employee);

        //匿名子类的匿名对象
        method1(new Employee() {
            @Override
            public void work() {
                System.out.println("5 days each week");
            }
        });
    }

    public static void method1(Employee employee) {
        employee.work();
        System.out.println("Employee: " + employee.name + "\n");
    }
}
