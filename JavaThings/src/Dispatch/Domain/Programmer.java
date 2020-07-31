package Dispatch.Domain;

import Dispatch.Service.Status;

public class Programmer extends Employee {
    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer() {
        super();
    }
    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public Status getStatus() {
        return status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return super.toString() + "\tSDE\t\t\t" + status + "\t\t\t\t\t" +
                equipment.getDescription();
    }

    //团队成员需要展示的信息
    public String getTeamDetails() {
        return memberId + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" +
                getSalary() + "SDE";
    }
}
