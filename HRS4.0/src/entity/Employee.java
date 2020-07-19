/**
 * projectName: HRS4.0
 * fileName: Employee.java
 * packageName: entity
 * date: 2020-07-13 16:25
 * copyright(c) tianyifan
 */
package entity;

/**
 * @version: V4.0
 * @author: tianyifan
 * @className: Employee
 * @packageName: entity
 * @description: 员工实体类
 * @date: 2020-07-13 16:25
 **/
public class Employee {
    private String Id;//员工编号
    private String name;//员工姓名
    private String dept;//所属部门
    private Integer salary;//薪资

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Employee(String id, String name, String dept, Integer salary) {
        this.Id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
}
