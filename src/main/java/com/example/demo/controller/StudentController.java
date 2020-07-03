package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.User;
import com.example.demo.model.student;
import com.example.demo.model.studentDTO;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class StudentController {
    @Resource
    private StudentService studentService;

    @ResponseBody
    @RequestMapping("selectStudent")
    public JSONArray selectStudent(@RequestParam("page") int page, @RequestParam("limit") int limit){
        page = (page-1)*limit;
        List<studentDTO> studentDTOList = studentService.selectLimt(page,limit);
        String json = JSONArray.toJSONString(studentDTOList);
        return JSONArray.parseArray(json);
    }

    @ResponseBody
    @RequestMapping("selectStudentAll")
    public JSONArray selectStudentAll(){
        List<studentDTO> studentDTOList = studentService.selectAll();
        String json = JSONArray.toJSONString(studentDTOList);
        return JSONArray.parseArray(json);
    }

    @ResponseBody
    @RequestMapping("selectByStudentName")
    public JSONArray selectByStudentName(@RequestParam("studentName") String studentName){
        List<studentDTO> studentDTOList = studentService.selectByName(studentName);
        String json = JSONArray.toJSONString(studentDTOList);
        return JSONArray.parseArray(json);
    }

    @ResponseBody
    @RequestMapping("deleteStudent")
    public JSONObject deleteStudent(@RequestParam("studentId")int studentId){
        int code = studentService.deleteByID(studentId);
        return JSON.parseObject("{ code : " + code + "}");
    }


    @ResponseBody
    @RequestMapping("studentUpdate")
    public JSONObject studentUpdate(@RequestParam Map<String, String> map){
        student student = getStudent(map);
        student.setStudentId(Integer.parseInt(map.get("studentId")));
        System.out.println(map);
        int code = studentService.update(student);
        return JSON.parseObject("{ code : " + code + "}");
    }


    @ResponseBody
    @RequestMapping("addStudent")
    public JSONObject addStudent(@RequestParam Map<String, String> student){
        student student1 = getStudent(student);
        int code = studentService.insert(student1);
        return JSON.parseObject("{ code : " + code + "}");
    }
    public student getStudent(Map<String, String> map){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        student student = new student();
        student.setStudentAddress(map.get("studentAddress"));
        student.setStudentName(map.get("studentName"));
        try {
            student.setStudentBirth(format1.parse((map.get("studentBirth"))));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        student.setStudentEmail(map.get("studentEmail"));
        student.setStudentTel(map.get("studentTel"));
        student.setStudentNumber(map.get("studentNumber"));
        student.setStudentSchool(map.get("studentSchool"));
        return student;
    }
}
