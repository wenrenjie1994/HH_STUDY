package work;

import entity.Resume;

import java.util.List;

public class Protocol {

    public String add(Resume resume){
        return "add/n"+resume.getId()+","+resume.getName()+","+resume.getSchool()+","+resume.getPosition();
    }

    public String deleteById(int id){
        return "deleteById/n"+id;
    }
    public String deleteByName(String name){
        return "deleteByName/n"+name;
    }

    public String updateById(int id,Resume newResume){
        return "updateById/n"+id+","+newResume.getName()+","+newResume.getSchool()+","+newResume.getPosition();
    }
    public String updateByName(String name,Resume newResume){
        return "updateByName/n"+name+","+newResume.getName()+","+newResume.getSchool()+","+newResume.getPosition();
    }

    public String findById(int id){
        return "findById/n"+id;
    }
    public String findByName(String name){
        return "findByName/n"+name;
    }
    public String findByPosition(String position){
        return "findByPosition/n"+position;
    }

    public String searchAll(){
        return "searchAll/n+search";
    }
}
