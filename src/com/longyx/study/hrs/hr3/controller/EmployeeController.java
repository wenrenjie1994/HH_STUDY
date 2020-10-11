package com.longyx.study.hrs.hr3.controller;

import com.longyx.study.hrs.hr3.dataobject.Department;
import com.longyx.study.hrs.hr3.dataobject.Employee;
import com.longyx.study.hrs.hr3.manager.EmployeeManager;
import com.longyx.study.hrs.hr3.manager.impl.EmployeeManagerImpl;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年07月23日 12:42
 */
public class EmployeeController {
    private static final String ADD = "1";
    private static final String DELETE = "2";
    private static final String MODIFY = "3";
    private static final String QUERY = "4";
    private static final String EXPORT = "5";
    private static final String QUIT = "q";

    /**
     * 状态记录
     * @author Mr.Longyx
     * @date 2020/7/23 19:23
     */
    private static String state = "";

    private static EmployeeManager employeeManager = null;

    /**
     * 静态代码块进行初始化
     * @author Mr.Longyx
     * @date 2020/7/24 21:10
     */
    static {
        try {
            Class<?> clazz = Class.forName("com.longyx.study.hrs.hr3.manager.impl.EmployeeManagerImpl");
            Object obj = clazz.newInstance();
            employeeManager = (EmployeeManager)obj;
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        System.out.print("--------1-添加员工--------\n" + "--------2-删除员工--------\n" + "--------3-修改员工--------\n" + "--------4-查询员工--------\n" + "--------5-导出员工信息到文件--------\n"+ "--------q-退   出--------\n");
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
                    System.out.println("请输入添加的员工(department_id=#,employee_name=#,gender=#,degree=#,birthday=#,telephone=#,address=#,position=#,division=#,date_joined=#)： ");
                    state = ADD;
                }else if (DELETE.equals(line)) {
                    System.out.println("请输入删除的员工id(employee_id=#)： ");
                    state = DELETE;
                }else if (MODIFY.equals(line)) {
                    System.out.println("请输入需要修改的员工(employee_id=#,employee_name=#)： ");
                    state = MODIFY;
                }else if (QUERY.equals(line)) {
                    System.out.println("分页查询员工信息，请输入(pageNum=#,pageSize=#)： ");
                    state = QUERY;
                }else if (EXPORT.equals(line)) {
                    System.out.println("输入回车，将员工信息导出到文件： ");
                    state = EXPORT;
                } else if (QUIT.equalsIgnoreCase(line)) {
                    System.out.println("欢迎您的下次光临！");
                    break;
                } else if (ADD.equals(state)) {
                    addEmployee(line);
                }else if (DELETE.equals(state)) {
                    deleteEmployee(line);
                }else if (MODIFY.equals(state)) {
                    updateEmployee(line);
                } else if (QUERY.equals(state)) {
                    findEmployeeByPage(line);
                }else if (EXPORT.equals(state)) {
                    saveEmployees2File();
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

    /**
     * 构造员工对象
     * @author Mr.Longyx
     * @date 2020/7/24 14:03
     */
    private static Employee getEmployee(String line) {
        String[] employeeArrays = line.split(",");
        Employee employee = new Employee();
        for (int i = 0; i < employeeArrays.length; i++) {
            String[] values = employeeArrays[i].split("=");
            if ("department_id".equals(values[0])) {
                /**
                 * 构造部门对象
                 * @author Mr.Longyx
                 * @date 2020/7/23 18:49
                 */
                Department department = new Department();
                department.setDepartmentId(Integer.valueOf(values[1]));
                /**
                 * 将部门和员工建立关联
                 * @author Mr.Longyx
                 * @date 2020/7/23 18:51
                 */
                employee.setDepartment(department);
            } else if ("employee_name".equals(values[0])) {
                employee.setEmployeeName(values[1]);
            } else if ("gender".equals(values[0])) {
                employee.setGender(values[1]);
            } else if ("degree".equals(values[0])) {
                employee.setDegree(values[1]);
            } else if ("birthday".equals(values[0])) {
                try {
                    employee.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(values[1]));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            } else if ("telephone".equals(values[0])) {
                employee.setTelephone(values[1]);
            } else if ("address".equals(values[0])) {
                employee.setAddress(values[1]);
            } else if ("position".equals(values[0])) {
                employee.setPosition(values[1]);
            } else if ("division".equals(values[0])) {
                employee.setDivision(values[1]);
            } else if ("date_joined".equals(values[0])) {
                try {
                    employee.setDateJoined(new SimpleDateFormat("yyyy-MM-dd").parse(values[1]));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return employee;
    }

    /**
     * 添加员工
     * @author Mr.Longyx
     * @date 2020/7/24 14:07
     */
    private static void addEmployee(String line){
        Employee employee = getEmployee(line);
        employeeManager.addEmployee(employee);
        System.out.println("添加学生成功");
    }

    /**
     * 删除员工
     * @author Mr.Longyx
     * @date 2020/7/24 14:10
     */
    private static void deleteEmployee(String line){
        int employeeId = Integer.parseInt(line.split("=")[1]);
        employeeManager = new EmployeeManagerImpl();
        employeeManager.deleteEmployee(employeeId);
        System.out.println("删除指定员工成功");
    }
    /**
     * 修改员工信息
     * @author Mr.Longyx
     * @date 2020/7/24 14:11
     */
    private static void updateEmployee(String line){
        Employee employee =getEmployee(line);
        employeeManager.updateEmployee(employee);
        System.out.println("修改员工信息成功！");
    }

    /**
     * 查询员工信息
     * @author Mr.Longyx
     * @date 2020/7/24 20:04
     */
    private static void findEmployeeByPage(String line){
        String[] employeeArray = line.split(",");
        int pageNum = Integer.valueOf(employeeArray[0].split("=")[1]);
        int pageSize = Integer.valueOf(employeeArray[1].split("=")[1]);
        employeeManager = new EmployeeManagerImpl();
        List<Employee> employeeList = employeeManager.findEmployeeList(pageNum, pageSize);
        for (Employee e : employeeList) {
            System.out.print("员工编号： "+e.getEmployeeId());
            System.out.print(", 员工姓名： "+e.getEmployeeName());
            System.out.print(", 性别： "+e.getGender());
            System.out.print(", 出生日期： "+e.getBirthday());
            System.out.print(", 联系电话： "+e.getTelephone());
            System.out.print(", 地址： "+e.getAddress());
            System.out.print(", 所属部门： "+e.getDepartment().getDepartmentName());
            System.out.print(", 年龄： "+(System.currentTimeMillis() - e.getBirthday().getTime())/(1000*60*60*24*365L));
            System.out.println("");
        }
    }

    /**
     * 将所有的员工信息保存至文件中
     * @author Mr.Longyx
     * @date 2020/7/24 12:54
     */
    private static void saveEmployees2File(){
        BufferedWriter writer = null;
        File file = null;
        try {
            file = new File("F:\\employee");
            if (!file.exists()) {
                file.mkdir();
            }

            StringBuffer sb = new StringBuffer();
            List<Employee> employeeList = employeeManager.findEmployeeList();

            for (Iterator<Employee> iter = employeeList.iterator(); iter.hasNext();) {
                Employee employee = iter.next();
                sb.append("员工编号： "+employee.getEmployeeId())
                        .append("员工姓名： "+employee.getEmployeeName())
                        .append("员工性别： "+employee.getGender())
                        .append("出生日期： "+ employee.getBirthday())
                        .append("联系电话： "+employee.getTelephone())
                        .append("地址： "+employee.getAddress())
                        .append("所属部门： "+employee.getDepartment().getDepartmentName())
                        .append("年龄： "+(System.currentTimeMillis() - employee.getBirthday().getTime())/(1000*60*60*24*365L))
                        .append("\n");
            }
            /**
             * 指定保存的文件格式
             * @author Mr.Longyx
             * @date 2020/7/24 20:44
             */
            String fileName = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒").format(new Date()) + ".dat";
            writer = new BufferedWriter(new FileWriter(new File(file, fileName)));
            writer.write(String.valueOf(sb));
            System.out.println("导出文件成功，文件位置：" + file.getPath() + "\\" + fileName);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
