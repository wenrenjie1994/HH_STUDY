package model;

public class Person {
    private String personName;
    private String personID;
    private String personClass;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getPersonClass() {
        return personClass;
    }

    public void setPersonClass(String personClass) {
        this.personClass = personClass;
    }
    public Person(String personName,String personID,String personClass){
        this.personName = personName;
        this.personID = personID;
        this.personClass = personClass;
    }
}
