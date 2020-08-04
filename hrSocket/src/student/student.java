package student;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class student {
    //    self.name = name
    //    self.IDcard = IDcard
    public String name;
    public String phoneNumber;
    public String age;
    //    public String degree;
//    public String school;
    public String job;
    public String salary;
    public Boolean isDelete = false;
    public String gender;
    public String birthday;
    public Map<String, String> event = new HashMap<String, String>();
    Map<String, String[]> degree = new HashMap<String, String[]>();
    Map<Boolean, String> dict = new HashMap<Boolean, String>();
    Map<String, String> situation = new HashMap<String, String>();
    private String IDcard;

    public student() {
        /*方法的重载*/
    }

    public student(String name, String IDcard, String phoneNumber,
                   String gender, String birthday, String age
            , String job, String salary) {
        /*idea不太会设置方法注释
         * 构造方法有些类似于Python的init函数*/
        this.name = name;
        this.IDcard = IDcard;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthday = birthday;
        this.age = age;
//        this.degree = degree;
//        this.school = school;
        this.job = job;
        this.salary = salary;


        this.dict.put(true, "1");
        this.dict.put(false, "0");


        this.situation.put("0", "未通过");
        this.situation.put("1", "通过");
        this.situation.put("2", "进程中");


        this.setEvent();
    }

    public student(String name, String IDcard, String phoneNumber,
                   String gender, String birthday, String age,
                   String job, String salary, Boolean isDelete) {
        this.name = name;
        this.IDcard = IDcard;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthday = birthday;
        this.age = age;
//        this.degree = degree;
//        this.school = school;
        this.job = job;
        this.salary = salary;
        this.dict.put(true, "1");
        this.dict.put(false, "0");

        this.isDelete = isDelete;

        this.situation.put("0", "未通过");
        this.situation.put("1", "通过");
        this.situation.put("2", "进程中");


        this.setEvent();
    }


    public void setEvent() {
        this.event.put("isCVPass", "2");
        this.event.put("isWriExamination", "2");
        this.event.put("isInterview", "2");
        this.event.put("isPhyExamination", "2");
        this.event.put("isSign", "2");
    }

    public void setEvent(String isCVPass, String isWriExamination
            , String isInterview, String isPhyExamination, String isSign) {

        this.event.put("isCVPass", isCVPass);
        this.event.put("isWriExamination", isWriExamination);
        this.event.put("isInterview", isInterview);
        this.event.put("isPhyExamination", isPhyExamination);
        this.event.put("isSign", isSign);
    }

    public void setEducation(String degree, String school, String startTime, String endTime) {
        this.degree.put(degree, new String[]{degree, school, startTime, endTime});
    }


    public String select() {

        String str = this.name + " " + this.IDcard + " " + this.phoneNumber + " " +
                this.gender + " " + this.birthday + " " + this.age+"\n";
        if(!this.getEducation().equals("0")){
            str=str+this.getEducation();
        }
        str=str+"应聘工作: " + this.job + " 期望薪资: " + this.salary+"\n";
        if(!this.getEvent().equals("0")){
            str=str+this.getEvent();
        }
        return str;
    }

    public String getEvent() {
        StringBuilder strEvent = new StringBuilder(this.name + " ");

//        lambda表达式获取招聘信息键值对
        for (Map.Entry<String, String> entry : this.event.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            strEvent.append(key).append(":").append(this.situation.get(value)).append(" ");
        }
        strEvent.append("\n");
        return strEvent.toString();

    }

    public String getEducation() {


        StringBuilder strEducation = new StringBuilder();
//        lambda表达式获取教育经历键值对
        for (Map.Entry<String, String[]> entry : this.degree.entrySet()) {
            String key = entry.getKey();
            String[] value = entry.getValue();
            strEducation.append(this.name).append(key).append(":").append(Arrays.toString(value)).append("\n");
        }
        return strEducation.toString();
    }

    public String getIDcard() {
        return IDcard;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }

    public String writeInfo() {
        return this.name + "\t" + this.IDcard + "\t" + this.phoneNumber + "\t" + this.gender + "\t" + this.birthday +
                "\t" + this.age + "\t" + "\t" + "\t" + this.job + "\t" + this.salary + "\t" + this.isDelete + "\n";
    }

    public String writeStudent() {
        return "('" + this.name + "','" + this.IDcard + "','" + this.phoneNumber + "','" + this.gender + "','"
                + this.birthday + "','" + this.age + "','" + this.job + "','" + this.salary + "',"
                + this.dict.get(this.isDelete) + ")";
    }

    public String writeEducation() {
        StringBuilder strEducation = new StringBuilder();
        int j = 0;
        if (this.degree.size() > 0) {

            for (String[] value : this.degree.values()) {
                strEducation.append("('").append(this.phoneNumber).append("','").append(value[0]).append("','").append(value[1]).append("','").append(value[2]).append("','").append(value[3]).append("')");
                j = j + 1;
                if (this.degree.size() > j) {
                    strEducation.append(",");
                }

            }
            return strEducation.toString();
        } else {
            return "";
        }
    }

    public String writeEvent() {
        return "(" + this.phoneNumber + ",'" + this.event.get("isCVPass") + "','" + this.event.get("isWriExamination")
                + "','" + this.event.get("isInterview") + "','" + this.event.get("isPhyExamination") + "','" +
                this.event.get("isSign") + "')";
    }
}
