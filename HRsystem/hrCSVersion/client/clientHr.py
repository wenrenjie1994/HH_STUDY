# -*- coding: utf-8 -*-
# @Time    : 2020/7/5 11:34
# @Author  : 唐家鑫
# @Email   : 1280445703@qq.com
# @File    : clientStu.py
# @Software: PyCharm
from HRsystem.hrCSVersion.student.student import student
from HRsystem.hrCSVersion.datebase.conDatabase import tomSql


class clientHr():
    def __init__(self, host, port, user, passwd, dbName, url='studentInfo.txt'):
        self.url = url
        self.student = {}
        self.info = {"姓名": "name", "身份证号": "IDcard", "手机号": "phoneNumber", "性别": "gender",
                     "出生日期": "birthday", "年龄": "age", "学历": "degree",
                     "学校": "school", "应聘岗位": "job", "期望薪资": "salary",
                     "开始时间": "startTime", "结束时间": "endTime"}
        # self.readTxt()
        self.db = tomSql(host, port, user, passwd, dbName)
        self.readDatabase()

    def alterEvent(self):
        '''
        利用Python的反射方法更改类中的信息
        :return:
        '''
        try:
            string = input("请输入要更正的信息类别")
            if string == "手机号":
                print("手机号为不可修改信息！请重新输入")
                self.alterEvent()
            else:
                phoneNumber, info = input("请按手机号、更正信息输入要更正的信息").split()
                # setattr(obj, attr, val):
                # 调用这个方法将给obj的名为attr的值的属性赋值为val。例如如果attr为’bar’，则相当于obj.bar = val。
                # print(self.info[string])
                self.student[phoneNumber].event[string] = info
                # setattr(self.student[phoneNumber], self.info[string], info)
                print("更改成功")
        except Exception as e:
            print(e)
            print("输入结构出错，请重新输入")
            self.alterEvent()

    def selectBasic(self):
        '''
        查看学生基本信息,学生只能看到本人的信息
        :return:
        '''
        try:
            for k, v in self.student.items():
                print(v.select())

        except Exception as e:
            print("输入结构或信息出错，请重新输入")
            self.selectBasic()

    def selectEducation(self):
        '''
        查看学生教育经历信息
        :return:
        '''
        try:
            phoneNumber = input("请输入要查询学生的手机号")
            if self.student[phoneNumber].isDelete == True:
                print("输入结构或信息出错，请重新输入")
                self.selectEducation()
            else:
                self.student[phoneNumber].getEducation()
                print("查询完毕！！！")
        except Exception as e:
            print("输入结构或信息出错，请重新输入")
            self.selectEducation()

    def selectEvent(self):
        '''
        查看学生招聘进程信息
        :return:
        '''
        try:
            phoneNumber = input("请输入要查询学生的手机号")

            if self.student[phoneNumber].isDelete == True:
                print("输入结构或信息出错，请重新输入")
                self.selectEducation()
            else:
                self.student[phoneNumber].getEvent()
                print("查询完毕！！！")
        except Exception as e:
            print("输入结构或信息出错，请重新输入")
            self.selectEducation()

    def printWelcome(self):
        '''
        学生的欢迎界面
        :return:
        '''
        print("====欢迎进入Hr系统--HR界面！！！===")
        print("请输入对应的数字表示进行操作！")
        print("请按1进行查询学生信息操作")
        print("请按2进行查询学生教育经历信息操作")
        print("请按3进行查询学生招聘进程信息操作")
        print("请按4进行更改学生招聘进程信息操作")
        print("请按5退出程序")
        return 5

    def choose(self, num, isStudent="True"):
        '''

        :param num:
        :param isStudent:
        :return:
        '''
        if num == 1:
            # 查询学生基本信息
            self.selectBasic()
        elif num == 2:
            # 查询学生教育信息
            self.selectEducation()
        elif num == 3:
            # 查询学生招聘进程信息
            self.selectEvent()
        elif num == 4:
            # 更改学生招聘进程信息
            self.alterEvent()
        elif num == 5:
            # self.writeTxt()
            self.saveToDatabase()
            print("程序结束！！！感谢使用。")
            return True
        return False

    def inputNum(self, max):
        try:
            num = int(input())
        except Exception as e:
            print("输入非数字，请重新输入")
            num = self.inputNum(max)
        if num > max or num < 1:
            num = self.inputNum(max)

        return num

    def writeTxt(self):
        with open(self.url, "wb") as f1:
            for k, v in self.student.items():
                # print(v)
                f1.write(v.writeInfo().encode("utf-8"))

    def readTxt(self):
        try:
            with open(self.url, "rb") as f2:
                for i in f2.readlines():
                    # print(i.decode("utf-8"))
                    name, IDcard, phoneNumber, gender, birthday, age, degree, school, job, salary, isDelete \
                        = i.decode("utf-8").split("\t")
                    # print(bool(isDelete))
                    # print(isDelete)
                    self.student[phoneNumber] = \
                        student(name, IDcard, phoneNumber, gender, birthday, school, job, salary, "1" == isDelete)
                    # print(self.student)
        except Exception as e:
            print(e)

    def readDatabase(self):
        try:
            info = self.db.get_all("student")
            for i in range(len(info)):
                # print(info)
                name, IDcard, phoneNumber, gender, birthday, age, job, salary, isDelete = info[i]
                self.student[phoneNumber] = \
                    student(name, IDcard, phoneNumber, gender, birthday, age, job, salary, "1" == isDelete)
            # print(info)
            info = self.db.get_all("stuEducation")
            for i in range(len(info)):
                phoneNumber, degree, school, startTime, endTime = info[i]
                self.student[phoneNumber].setEducation(degree, school, startTime, endTime)
            info = self.db.get_all("event")
            for i in range(len(info)):
                phoneNumber, isCVPass, isWriExamination, isInterview, isPhyExamination, isSign = info[i]
                self.student[phoneNumber].setEvent(isCVPass, isWriExamination, isInterview, isPhyExamination, isSign)
            # print(info)
        except Exception as e:
            print(e)

    def saveToDatabase(self):
        try:
            self.db.delete("event")

            for k, v in self.student.items():
                # 先删除数据库的数据再把内存中的数据加入数据库
                strStudent, strEducation, strEvent = v.writeInfo()
                # 也可以采用封装每次操作的sql语句，最后整体进行执行，但这里太麻烦暂时放弃

                # 学生端只能对招聘进程信息做查询不能做任何的修改
                # self.db.delete("event")
                # print(1)
                # print(self.db.get_all("student"))

                self.db.insert("event", strEvent)
                # self.db.insert("event", strEvent)
        except Exception as e:
            print(e)


if __name__ == '__main__':
    client1 = clientHr('cdb-5buhylba.cd.tencentcdb.com', 10056, 'root', 'tangjiaxin19971218', 'hrSystem')
    while True:
        max = client1.printWelcome()
        num = client1.inputNum(max)
        if client1.choose(num):
            break
