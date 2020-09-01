package com.spdb.study.hrs.hr4.controller;

import com.spdb.study.hrs.hr4.dataobject.Performance;
import com.spdb.study.hrs.hr4.manager.PerformanceManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @author Mr.Longyx
 * @date 2020年07月25日 13:29
 */
public class PerformanceController {
    private static final String ADD = "1";
    private static final String DELETE = "2";
    private static final String MODIFY = "3";
    private static final String QUERY_EMPLOYEE_ID = "4";
    private static final String QUERY_HIGHER_GRADE = "5";
    private static final String QUERY_TOP3 = "6";
    private static final String PAGE_QUERY = "7";
    private static final String QUIT = "q";

    /**
     * 状态记录
     * @author Mr.Longyx
     * @date 2020/7/23 19:23
     */
    private static String state = "";

    private static PerformanceManager performanceManager = null;

    private static Performance performance;
    /**
     * 静态代码块进行初始化
     * @author Mr.Longyx
     * @date 2020/7/24 21:10
     */
    static {
        try {
            Class<?> clazz = Class.forName("com.spdb.study.hrs.hr4.manager.impl.PerformanceManagerImpl");
            Object obj = clazz.newInstance();
            performanceManager = (PerformanceManager) obj;
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        System.out.print("--------1-添加员工绩效--------\n" + "--------2-删除员工绩效--------\n" + "--------3-修改员工绩效--------\n" + "--------4-根据员工Id查询员工绩效--------\n" + "--------5-查询每个考核类别最高绩效成绩--------\n"+ "--------6-查询绩效总分前三名--------\n"+ "--------7-分页查询员工绩效--------\n"+ "--------q-退   出--------\n");
        BufferedReader bufferedReader = null;
        String line = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while ((line = bufferedReader.readLine()) !=null) {
                /**
                 * 待优化
                 * @author Mr.Longyx
                 * @date 2020/7/21 16:20
                 */
                if (ADD.equals(line)) {
                    System.out.println("请输入添加的员工绩效(employee_id=#,examine_type_id=#,evaluation_items=#,grade=#,ratings=#)： ");
                    state = ADD;
                }else if (DELETE.equals(line)) {
                    System.out.println("请输入删除的员工Id和考核类别Id(employee_id=#,examine_type_id=#)： ");
                    state = DELETE;
                }else if (MODIFY.equals(line)) {
                    System.out.println("请输入需要修改的员工绩效(grade=#,employee_id=#,examine_type_id=#)： ");
                    state = MODIFY;
                }else if (QUERY_EMPLOYEE_ID.equals(line)) {
                    System.out.println("根据员工Id查询员工绩效(employee_id=#)： ");
                    state = QUERY_EMPLOYEE_ID;
                }else if (QUERY_HIGHER_GRADE.equals(line)) {
                    System.out.println("回车查询每个考核类别下最高绩效成绩");
                    state = QUERY_HIGHER_GRADE;
                } else if (QUERY_TOP3.equals(line)) {
                    System.out.println("回车查询员工绩效总分前三名");
                    state = QUERY_TOP3;
                }else if(PAGE_QUERY.equals(line)) {
                    System.out.println("分页查询员工绩效成绩(pageNum=#,pageSize=#)");
                    state = PAGE_QUERY;
                } else if (QUIT.equalsIgnoreCase(line)) {
                    System.out.println("欢迎您的下次光临！");
                    break;
                } else if (ADD.equals(state)) {
                    addPerformance(line);
                }else if (DELETE.equals(state)) {
                    deletePerformance(line);
                }else if (MODIFY.equals(state)) {
                    updatePerformance(line);
                } else if (QUERY_EMPLOYEE_ID.equals(state)) {
                    findPerformanceByEmployeeId(line);
                }else if (QUERY_HIGHER_GRADE.equals(state)) {
                    findHigherPerformanceGradeOfEachExamineType(line);
                } else if(QUERY_TOP3.equals(state)) {
                    findTop3PerformanceList(line);
                } else if(PAGE_QUERY.equals(state)){
                    findPerformanceList(line);
                }
            }
            System.err.println("正常退出");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void findHigherPerformanceGradeOfEachExamineType(String line) {
        List<Performance> higherPerformanceList = performanceManager.findHigherPerformanceList();
        printPerformanceList(higherPerformanceList);
    }

    private static void findTop3PerformanceList(String line) {
        List<Performance> performanceList = performanceManager.findPerformanceListTop3();
        for (Iterator<Performance> iter = performanceList.iterator();iter.hasNext();){
            Performance performance = iter.next();
            System.out.print("员工Id："+performance.getEmployee().getEmployeeId());
            System.out.print(" 员工姓名："+performance.getEmployee().getEmployeeName());
            System.out.print(" 所属部门："+performance.getEmployee().getDepartment().getDepartmentName());
            System.out.print(" 考核成绩："+new DecimalFormat("####.00").format(performance.getGrade()));
            System.out.print("\n");
        }
    }

    private static void addPerformance(String line){
        performance = new Performance();
        Map<String, Object> map = parseParam(line);

        int employeeId = (Integer)map.get("employee_id");
        int examineTypeId = (Integer)map.get("examine_type_id");
        String evaluationItems = (String)map.get("evaluation_items");
        float grade = (Float)map.get("grade");
        String ratings = (String)map.get("ratings");

        performance.setEmployeeId(employeeId);
        performance.setExamineTypeId(examineTypeId);
        performance.setEvaluationItems(evaluationItems);
        performance.setGrade(grade);
        performance.setRatings(ratings);

        performanceManager.addPerformance(performance);
        System.out.println("新增员工绩效信息成功");
    }

    private static Map<String, Object> parseParam(String line){
        Map<String, Object> map = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(line,",");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            StringTokenizer tk = new StringTokenizer(token,"=");
            if (tk.hasMoreTokens()) {
                String leftStr = tk.nextToken();
                if ("employee_id".equals(leftStr)) {
                    if (tk.hasMoreTokens()) {
                        map.put("employee_id", Integer.parseInt(tk.nextToken()));
                    }
                } else if("examine_type_id".equals(leftStr)) {
                    if (tk.hasMoreTokens()) {
                        map.put("examine_type_id", Integer.parseInt(tk.nextToken()));
                    }

                } else if ("evaluation_items".equals(leftStr)) {
                   if (tk.hasMoreTokens()) {
                       map.put("evaluation_items", tk.nextToken());
                   }
                }else if ("grade".equals(leftStr)) {
                    if (tk.hasMoreTokens()) {
                        map.put("grade",Float.valueOf(tk.nextToken()));
                    }
                }else if ("ratings".equals(leftStr)) {
                    if (tk.hasMoreTokens()) {
                        map.put("ratings", tk.nextToken());
                    }
                }else if ("pageNum".equals(leftStr)) {
                    if (tk.hasMoreTokens()) {
                        map.put("pageNum", Integer.parseInt(tk.nextToken()));
                    }
                }else if ("pageSize".equals(leftStr)) {
                    if (tk.hasMoreTokens()) {
                        map.put("pageSize", Integer.parseInt(tk.nextToken()));
                    }
                }
            }
        }
        return map;
    }

    private static void updatePerformance(String line){
        performance = new Performance();
        Map<String, Object> map = parseParam(line);

        int employeeId = (Integer)map.get("employee_id");
        int examineTypeId = (Integer)map.get("examine_type_id");
        float grade = (Float)map.get("grade");

        performance.setEmployeeId(employeeId);
        performance.setExamineTypeId(examineTypeId);
        performance.setGrade(grade);

        performanceManager.updatePerformance(performance);
        System.out.println("修改员工绩效成绩成功");
    }

    private static void deletePerformance(String line) {
        Map<String, Object> map = parseParam(line);

        int employeeId = (Integer)map.get("employee_id");
        int examineTypeId = (Integer)map.get("examine_type_id");

        performanceManager.deletePerformance(employeeId, examineTypeId);
        System.out.println("删除员工绩效成功");
    }

    private static void findPerformanceByEmployeeId(String line){
        Map<String, Object> map = parseParam(line);
        int employeeId = (Integer)map.get("employee_id");
        List<Performance> performanceList = performanceManager.findPerformanceListByEmployeeId(employeeId);
        printPerformanceList(performanceList);
    }

    private static void printPerformanceList(List<Performance> performanceList) {
        for (Iterator<Performance> iter = performanceList.iterator();iter.hasNext();){
            performance = iter.next();
            System.out.print("员工Id："+performance.getEmployee().getEmployeeId());
            System.out.print(" 员工姓名："+performance.getEmployee().getEmployeeName());
            System.out.print(" 所属部门："+performance.getEmployee().getDepartment().getDepartmentName());
            System.out.print(" 考核类别："+performance.getExamineType().getExamineTypeName());
            System.out.print(" 考核成绩："+new DecimalFormat("####.00").format(performance.getGrade()));
            System.out.print("\n");
        }
    }

    private static void findPerformanceList(String line){
        Map<String, Object> map = parseParam(line);
        int pageNum = (Integer)map.get("pageNum");
        int pageSize = (Integer)map.get("pageSize");

        List<Performance> performanceList = performanceManager.findPerformanceList(pageNum, pageSize);
        printPerformanceList(performanceList);
        System.out.println("分页查询学生绩效成绩成功！");
    }
}
