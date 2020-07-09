package controller;

import handledate.Handle;
import model.Person;
import service.PersonService;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        LinkedList<Person> peopleList = new LinkedList<>();
        Handle.readData(peopleList);
        while (true){
            System.out.println("添加学生信息请按----------1");
            System.out.println("删除学生信息请按----------2");
            System.out.println("修改学生信息请按----------3");
            System.out.println("查询学生信息请按----------4");
            System.out.println("退出教务系统请按----------5");
            Integer input = sc.nextInt();
           /* switch (input){
                case 1:
                    PersonService.addPerson(peopleList);
                    break;
                case 2:
                    PersonService.deletePerson(peopleList);
                    break;
                case 3:
                    PersonService.updatePerson(peopleList);
                    break;
                case 4:
                    PersonService.showPerson(peopleList);
                    break;
                case 5:
                    Handle.saveData(peopleList);
                    break;
                default:
                    System.out.println("请重新输入");
                    break;
            }*/
            if(input==1)
            {
                PersonService.addPerson(peopleList);
            }
            else if(input==2)
            {
                PersonService.deletePerson(peopleList);
            }
            else if(input==3)
            {
                PersonService.updatePerson(peopleList);
            }
            else if(input==4)
            {
                PersonService.showPerson(peopleList);
            }
            else if(input==5)
            {
                Handle.saveData(peopleList);
                break;
            }
            else {
                System.out.println("输入错误，请确认后从新输入");
            }
        }
    }
}
