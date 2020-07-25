package JavaDemo.OOP.Polymorphic.Example03;

import java.util.Objects;

public class Student extends Person {
    boolean isCollege;
    int idCard = 160301;

    public Student() {
    }

    public Student(boolean isCollege, int idCard) {
        this.isCollege = isCollege;
        this.idCard = idCard;
    }

    public void study() {
        System.out.println("learn 8h each day!!!");
    }

    @Override
    public void eat() {
        System.out.println("eat more meat!!!");
    }

    @Override
    public void traffic() {
        System.out.println("walk!!!");
    }

    /*
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Student) {
            Student student = (Student)obj;
            //compare every filed and method
            if (this.name.equals(student.name) && this.age == student.age &&
                    this.isCollege == student.isCollege && this.idCard == student.idCard) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return isCollege == student.isCollege &&
                idCard == student.idCard;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isCollege, idCard);
    }
}
