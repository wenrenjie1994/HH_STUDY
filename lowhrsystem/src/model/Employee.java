package model;

public class Employee {
    public String employeeJobNumber;

    public String employeeName;

    public int employeeAge;

    public String employeeGender;

    public String employeePhone;

    public Employee(String employeeeJobNumber, String employeeName, int employeeAge, String employeeGender, String employeePhone)
        {
            this.employeeJobNumber = employeeeJobNumber;
            this.employeeName = employeeName;
            this.employeeAge = employeeAge;
            this.employeeGender = employeeGender;
            this.employeePhone = employeePhone;
        }

}

