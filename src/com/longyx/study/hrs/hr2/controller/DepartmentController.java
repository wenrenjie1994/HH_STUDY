package com.longyx.study.hrs.hr2.controller;

import com.longyx.study.hrs.hr2.manager.DepartmentManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Mr.Longyx
 * @date 2020年07月21日 21:47
 */
public class DepartmentController {
    private static final String ADD = "1";
    private static final String DELETE = "2";
    private static final String MODIFY = "3";
    private static final String QUERY = "4";
    private static final String QUIT = "q";

    /**
     * 记录状态
     * @author Mr.Longyx
     * @date 2020/7/22 12:19
     */
    private static String state = "";

    public static void main(String[] args) {
        System.out.print("--------1-添加部门--------\n" + "--------2-删除部门--------\n" + "--------3-修改部门名称--------\n" + "--------4-查询所有部门--------\n" + "--------q-退       出--------\n");
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
                    System.out.println("请输入需要添加的部门(pid=#,department_name=#)： ");
                    state = ADD;
                }else if (DELETE.equals(line)) {
                    System.out.println("请输入需要删除的部门Id(department_id=#)： ");
                    state = DELETE;
                }else if (MODIFY.equals(line)) {
                    System.out.println("请输入新的的部门名称(department_id=#,department_name=#)： ");
                    state = MODIFY;
                }else if (QUERY.equals(line)) {
                    System.out.println("请输入回车查询部门信息： ");
                    state = QUERY;
                }else if (QUIT.equalsIgnoreCase(line)) {
                    System.out.println("欢迎您的下次光临！");
                    break;
                } else {
                    if (ADD.equals(state)) {
                        int pid = Integer.valueOf(line.substring(line.indexOf("=")+1, line.indexOf(",")));
                        String departmentName = line.substring(line.lastIndexOf("=") + 1, line.length());;
                        DepartmentManager.getInstance().addDepartment(pid, departmentName);
                        System.out.println("添加部门成功！");
                    }else if (DELETE.equals(state)) {
                        int departmentId = Integer.valueOf(line.split("=")[1]);
                        DepartmentManager.getInstance().deleteDepartments(departmentId);
                        System.out.println("删除部门成功！");
                    }else if (MODIFY.equals(state)) {
                        String[] departmentArrays = line.split(",");
                        int departmentId = 0;
                        String departmentName = "";
                        for (int i=0;i<departmentArrays.length; i++) {
                            String[] values = departmentArrays[i].split("=");
                            if ("department_id".equals(values[0])) {
                                departmentId = Integer.valueOf(values[1]);
                            }else if ("department_name".equals(values[0])) {
                                departmentName = values[1];
                            }
                        }
                        if (departmentArrays.length > 0) {
                            DepartmentManager.getInstance().updateDepartment(departmentId, departmentName);
                            System.out.println("修改部门名称成功！");
                        }
                    } else if (QUERY.equals(state)) {
                        DepartmentManager.getInstance().getDepartments();
                    }
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
}
