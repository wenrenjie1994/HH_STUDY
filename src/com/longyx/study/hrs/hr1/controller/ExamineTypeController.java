package com.longyx.study.hrs.hr1.controller;

import com.longyx.study.hrs.hr1.dataobject.ExamineType;
import com.longyx.study.hrs.hr1.manager.ExamineTypeManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年07月21日 16:02
 */
public class ExamineTypeController {
    private static final String ADD = "1";
    private static final String DELETE = "2";
    private static final String MODIFY = "3";
    private static final String QUERY = "4";
    private static final String QUIT = "q";

    //记录状态
    private static String state = "";

    public static void main(String[] args) {
        System.out.print("--------1-添加考核类别--------\n" + "--------2-删除考核类别--------\n" + "--------3-修改考核类别--------\n" + "--------4-查询考核类别--------\n" + "--------q-退       出--------\n");
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
                    System.out.println("请输入添加的考核类别(examine_type_name=#)： ");
                    state = ADD;
                }else if (DELETE.equals(line)) {
                    System.out.println("请输入删除的考核类别id(examine_type_id=#)： ");
                    state = DELETE;
                }else if (MODIFY.equals(line)) {
                    System.out.println("请输入需要修改的考核类别(examine_type_id=#,examine_tpe_name=#)： ");
                    state = MODIFY;
                }else if (QUERY.equals(line)) {
                    System.out.println("输入回车查询所有的考核列表： ");
                    state = QUERY;
                }else if (QUIT.equalsIgnoreCase(line)) {
                    System.out.println("欢迎您的下次光临！");
                    break;
                } else if (ADD.equals(state)) {
                    String[] examineTypeArray = line.split("=");

                    String examineTypeName = examineTypeArray[1];

                    ExamineTypeManager.getInstance().addExamineType(examineTypeName);
                    System.out.println("添加考核类别成功");
                }else if (DELETE.equals(state)) {
                    String[] examineTypeArray = line.split("=");
                    int examineTypeId = Integer.parseInt(examineTypeArray[1]);
                    ExamineTypeManager.getInstance().delExamineType(examineTypeId);
                    System.out.println("删除该考核类别成功");
                }else if (MODIFY.equals(state)) {
                    String[] examineTypeArrays = line.split(",");
                    int examineTypeId = 0;
                    String examineTypeName = "";
                    for (int i=0; i<examineTypeArrays.length;i++) {
                        String[] values = examineTypeArrays[i].split("=");
                        if ("examine_type_id".equals(values[0])) {
                            examineTypeId = Integer.parseInt(values[0]);
                        }else if ("examine_type_name".equals(values[0])){
                            examineTypeName = values[1];
                        }
                    }
                    if (examineTypeArrays.length > 0) {
                        ExamineTypeManager.getInstance().updateExamineType(examineTypeId, examineTypeName);
                        System.out.println("更新考核类别成功");
                    }

                } else if (QUERY.equals(state)) {
                    List<ExamineType> examineTypes = ExamineTypeManager.getInstance().findExamineTypes();
                    System.out.println("==========考核类别列表==========");
                    for (Iterator<ExamineType> iter = examineTypes.iterator(); iter.hasNext();) {
                        ExamineType examineType = iter.next();
                        System.out.println(examineType.getExamineTypeId()+", "+examineType.getExamineTypeName());
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
