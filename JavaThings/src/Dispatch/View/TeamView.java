package Dispatch.View;

import Dispatch.Domain.Employee;
import Dispatch.Domain.Programmer;
import Dispatch.Service.NameListService;
import Dispatch.Service.TeamException;
import Dispatch.Service.TeamService;

public class TeamView {
    private NameListService listService = new NameListService();
    private TeamService teamService = new TeamService();

    public void enterMainMenu() {

        boolean loopFlag = true;
        char menu = '0';
        while (loopFlag) {
            if (menu != '1') {
                listAllEmployee();
            }

            System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4): ");
            menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.print("确认是否退出(Y/N): ");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        loopFlag = false;
                    }
                    break;
            }
        }
    }

    /**
     * @Desrciption 显示所有的员工信息
     * @date 2020.7.30 11:10
     */
    private void listAllEmployee() {
        System.out.println("------------------------开发团队调度软件-----------------------\n");

        Employee[] employees = listService.getAllEmployees();
        if (employees.length == 0) {
            System.out.println("have no any employee!!");
        } else {
            System.out.println("ID\t姓名\t\t\t年龄\t工资\t\t职位\t\t\t状态\t\t奖金\t\t股票\t\t设备");

            for (int i=0; i<employees.length; i++) {
                System.out.println(employees[i]);
            }

            System.out.println("------------------------------------------------------------");
        }

    }

    private void getTeam() {
        System.out.println("-----------------------团队成员列表-----------------------");

        Programmer[] team = teamService.getTeam();
        if (team == null || team.length == 0) {
            System.out.println("没有任何成员");
        } else {
            System.out.println("TID/ID\b姓名\b年龄\b工资\b职位\b奖金\b股票\n");
            for (int i=0; i<team.length; i++) {
                System.out.println(team[i].getTeamDetails());
            }
        }

        System.out.println("-------------------------------------------------------");
    }

    private void addMember() {
        System.out.println("-----------------------添加成员-----------------------");
        System.out.print("输入需要添加的员工ID: ");
        int id = TSUtility.readInt();
        try {
            Employee e = listService.getEmployee(id);
            teamService.addMember(e);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println("添加失败，" + e.getMessage());
        }
        //按回车继续...
        TSUtility.readReturn();
    }

    private void deleteMember() {
        System.out.println("-----------------------删除成员-----------------------");
        System.out.print("输入要删除员工的TID: ");
        int memberID = TSUtility.readInt();

        System.out.print("确认是否删除(Y/N): ");
        char isDelete = TSUtility.readConfirmSelection();
        if (isDelete == 'N') {
            return;
        }
        try {
            teamService.removeMember(memberID);
            System.out.println("删除成功！");
        } catch (TeamException e) {
            System.out.println("删除失败，" + e.getMessage());
        }
        //按回车继续...
        TSUtility.readReturn();
    }

    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }
}
