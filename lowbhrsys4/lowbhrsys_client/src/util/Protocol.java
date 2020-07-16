package util;

import model.Interviewee;

public class Protocol {
    public Protocol(){

    }

    public String addMessage(Interviewee interviewee){
        String str="add/n"+interviewee.getName()+","+interviewee.getAge()+","+interviewee.getSchool()+","+interviewee.getID()+","+interviewee.getPosition();
        return str;
    }

    public String deleteByNameMessage(Interviewee interviewee){
        String str="deleteByName/n"+interviewee.getName();
        return str;
    }

    public String deleteByIDMessage(Interviewee interviewee){
        String str="deleteByID/n"+interviewee.getID();
        return str;
    }

    public String modifyMessage(Interviewee interviewee){
        String str="modify/n"+interviewee.getName()+","+interviewee.getAge()+","+interviewee.getSchool()+","+interviewee.getID()+","+interviewee.getPosition();
        return str;
    }

    public String searchByNameMessage(Interviewee interviewee){
        String str="searchByName/n"+interviewee.getName();
        return str;
    }

    public String searchBySchoolMessage(Interviewee interviewee){
        String str="searchBySchool/n"+interviewee.getSchool();
        return str;
    }

    public String searchByPositionMessage(Interviewee interviewee){
        String str="searchByPosition/n"+interviewee.getPosition();
        return str;
    }
}
