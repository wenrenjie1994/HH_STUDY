package bean;

import lombok.Data;

@Data
public class Resume {

    private String name;
    private String id;
    private String school;
    /**
     *
     * * 0：已申请
     * 1：简历通过
     * 2：笔试通过
     * 3：体检通过
     * 4：背调通过
     * 5：已签约
     * 6：已入职
     */
    private int process;

    /**
     *逻辑删除
     * 0 :不展示
     * 1 : 展示
     */
    private int deleteStatus;

    public Resume(){
        this.process=0;
        this.deleteStatus=0;
    }

    public Resume(String id, String name, String school) {
        this.name = name;
        this.id = id;
        this.school=school;
        this.process=0;
        this.deleteStatus=0;
    }
    public Resume(String id, String name, String school, int process, int deleteStatus) {

        this.id = id;
        this.name = name;
        this.school=school;
        this.process=process;
        this.deleteStatus=deleteStatus;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", school='" + school + '\'' +
                ", process=" + process +
                ", deleteStatus=" + deleteStatus +
                '}';
    }

    public  void PrintString(){
        System.out.println("No:"+this.id+",Name:"+this.name+",School:"+this.school+
                ",Process:"+this.process+",DeleteStatus:"+this.deleteStatus);

    }

}
