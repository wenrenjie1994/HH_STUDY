package com.pan.team.service;

import com.pan.team.domain.Architect;
import com.pan.team.domain.Designer;
import com.pan.team.domain.Employee;
import com.pan.team.domain.Equipment;
import com.pan.team.domain.NoteBook;
import com.pan.team.domain.PC;
import com.pan.team.domain.Printer;
import com.pan.team.domain.Programmer;

/**
 * 
 * Description 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作 Employee[]的方法。
 * 
 * @author Pan Email:zhaopan1848@163.com
 * @version
 * @date 2020年4月10日上午10:41:56
 */
public class NameListService {
	private Employee[] employees;

	public NameListService() {
		super();
	}

	public Employee[] getAllEmployees() {

		// 创建一个对象数组的时候，往往会忘记为每个引用new一个内存空间
		employees = new Employee[Data.EMPLOYEES.length];

		for (int i = 0; i < employees.length; i++) {

			int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
			int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
			String name = Data.EMPLOYEES[i][2];
			int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
			double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
			Equipment equipment;
			double bonus;
			int stock;

			if (type == Data.ARCHITECT) {
				equipment = getEquipment(i);
				bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
				stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
			} else if (type == Data.DESIGNER) {
				equipment = getEquipment(i);
				bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equipment, bonus);
			} else if (type == Data.PROGRAMMER) {
				equipment = getEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
			} else {
				employees[i] = new Employee(id, name, age, salary);
			}

		}

		return employees;
	}

	private Equipment getEquipment(int i) {
		Equipment equipment = null;

		int key = Integer.parseInt(Data.EQUIPMENTS[i][0]);
		if (key == Data.PC) {
			String model = Data.EQUIPMENTS[i][1];
			String display = Data.EQUIPMENTS[i][2];
			equipment = new PC(model, display);
		} else if (key == Data.NOTEBOOK) {
			String model = Data.EQUIPMENTS[i][1];
			double price = Double.parseDouble(Data.EQUIPMENTS[i][2]);
			equipment = new NoteBook(model, price);
		} else if (key == Data.PRINTER) {
			String name = Data.EQUIPMENTS[i][1];
			String type = Data.EQUIPMENTS[i][2];
			equipment = new Printer(name, type);
		}

		return equipment;
	}

	/**
	 * 
	 * Description 获取指定ID的员工对象。 
	 * @author Pan  Email:zhaopan1848@163.com
	 * @date 2020年4月10日下午4:13:00
	 * @param id 指定员工的ID
	 * @return 指定员工对象 
	 *  
	 * @throws TeamException 异常：找不到指定的员工
	 */
	public Employee getEmployee(int id) throws TeamException {
		Employee emp;
			if(id>=0 && id <employees.length) {
				emp = employees[id];
			}else {
				throw new TeamException("找不到指定的员工 ");
			}
		return emp;

	}

	public static void main(String[] args) {
		NameListService nameListSvc = new NameListService();
		Employee[] allEmployees = nameListSvc.getAllEmployees();
		for (int i = 0; i < allEmployees.length; i++) {
			System.out.println(allEmployees[i]);
		}
		try {
			System.out.println(nameListSvc.getEmployee(1));
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
