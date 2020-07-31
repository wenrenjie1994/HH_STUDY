package Dispatch.Service;

import Dispatch.Domain.*;

import static Dispatch.Service.Data.*;

/**
 * @Description 将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法
 * @author
 * @version 1.0
 * @date 2020.7.19 16:10
 */
public class NameListService {
    private Employee[] employees;

    //ctor
    public NameListService() {
        /**
         * @Description 根据提供的Data类构建相应大小的Employee数组，再根据Data类中的数据构建不同的对象
         */
        employees = new Employee[EMPLOYEES.length];         //Data.EMPLOYEES.length

        for (int i=0; i<employees.length; i++) {
            //get employee position
            int type = Integer.parseInt(EMPLOYEES[i][0]);

            //get employee 4 fundamental information
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);

            Equipment equipment;

            double bonus;
            int stock;

            switch (type) {
                case EMPLOYEE:      //10
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:    //11
                    equipment = getEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case DESIGNER:      //12
                    equipment = getEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case ARCHITECT:     //13
                    equipment = getEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment,
                            bonus, stock);
                    break;
            }
        }
    }

    //acquire the employee's equipment
    private Equipment getEquipment(int index) {
        int key = Integer.parseInt(EQUIPMENTS[index][0]);

        String modelOrName = EQUIPMENTS[index][1];

        switch (key) {
            case PC:        //21
                String display = EQUIPMENTS[index][2];
                return new PC(modelOrName, display);
            case NOTEBOOK:  //22
                double price = Double.parseDouble(EQUIPMENTS[index][2]);
                return new NoteBook(modelOrName, price);
            case PRINTER:   //23
                String type = EQUIPMENTS[index][2];
                return new Printer(modelOrName, type);
        }
        return null;
    }

    //返回一个数组
    public Employee[] getAllEmployees() {
        return employees;
    }

    /**
     * @Description get the appoint id employee, maybe is not exist(Exception)
     * @param id
     * @return
     */
    public Employee getEmployee(int id) throws TeamException {
        for (int i=0; i<employees.length; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }

        throw new TeamException("cannot find the employee");
    }
}
