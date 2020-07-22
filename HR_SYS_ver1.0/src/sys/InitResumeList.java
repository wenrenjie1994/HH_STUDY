package sys;

import pojo.Resume;

import java.util.ArrayList;


/**
 * User: Alex FAN
 * Date: 2020/7/21
 * Time: 23:02
 * Description:
 */
public class InitResumeList  {

    public ArrayList<Resume> initResume(){
        ArrayList<Resume>init  = new ArrayList<>();

        Resume resume1 = new Resume("zhangsan","1","x",0);
        Resume resume2 = new Resume("lisi","2","x",1);
        Resume resume3 = new Resume("wanger","3","x",2);
        Resume resume4 = new Resume("mazi","4","x",3);
        Resume resume5 = new Resume("hh","5","x",4);
        Resume resume6 = new Resume("xx","6","x",5);

        init.add(resume1);
        init.add(resume2);
        init.add(resume3);
        init.add(resume4);
        init.add(resume5);
        init.add(resume6);


        return init;

    }

}
