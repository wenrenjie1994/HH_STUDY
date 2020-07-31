package Dispatch.Service;

import Dispatch.Domain.Architect;
import Dispatch.Domain.Designer;
import Dispatch.Domain.Employee;
import Dispatch.Domain.Programmer;

/**
 * @Description 开发团队成员的管理
 * @author
 * @dete 2020.7.19 22:50
 */

public class TeamService {
    private static int counter = 1;             //memberID
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total;              //actual number of people

    public TeamService() {
        super();
    }

    /**
     * @Description 获取开发团队的成员
     * @author
     * @date 2020.7.29 22:55
     * @return
     */
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i=0; i<team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * @Description 将指定的员工添加到开发团队中
     * 无法添加的情况：
     * 1.成员已满
     * 2.该员工不是开发人员
     * 3.该员工已经在开发团队中
     * 4.该员工已是另一团队成员
     * 5.团队中最多只能有一名架构师
     * 6.团队中最多只能有两名设计师
     * 7.团队中最多只能有三名程序员
     * @author
     * @date 2020.7.29 23:00
     * @param e
     */
    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满！！");
        }
        if (!(e instanceof Programmer)) {
            throw new TeamException("该员工不是开发人员！！");
        }
        if (isExist(e)) {
            throw new TeamException("该员工已经在团队中!!");
        }
        Programmer p = (Programmer)e;
        if ("BUSY".equals(p.getStatus().getNAME())) {
            throw new TeamException("该员工已经在某团队中!!");
        } else if ("VOCATION".equals(p.getStatus().getNAME())) {
            throw new TeamException("该员工正在休假!!");
        }

        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for (int i=0; i<total; i++) {
            if (team[i] instanceof Architect) {
                numOfArch++;
            } else if (team[i] instanceof Designer) {
                numOfDes++;
            } else {
                numOfPro++;
            }
        }

        if (p instanceof Architect) {
            if (numOfArch >= 1) {
                throw new TeamException("最多只有一名架构师!!");
            }
        } else if (p instanceof Designer) {
            if (numOfDes >= 2) {
                throw new TeamException("最多只有两名设计师!!");
            }
        } else {
            if (numOfPro >= 3) {
                throw new TeamException("最多只有三名程序员!!");
            }
        }

        //将e添加到现有的team中,并更改属性
        team[total++] = p;
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
    }

    //判断员工是否存在现有的开发团队中
    public boolean isExist(Employee e) {
        for (int i=0; i<total; i++) {
            if (team[i].getId() == e.getId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * @Desvription 删除成员
     * @author
     * @date 2020.7.30 10:55
     * @param memberID
     */
    public void removeMember(int memberID) throws TeamException {
        int i;
        for (i=0; i<total; i++) {
            if (team[i].getMemberId() == memberID) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }

        //找不到指定员工
        if (i == total) {
            throw new TeamException("cannot find the appoint employee!!");
        }

        for (int j=i+1; j<total; j++) {
            team[j-1] = team[j];
        }
        team[--total] = null;
    }
}
