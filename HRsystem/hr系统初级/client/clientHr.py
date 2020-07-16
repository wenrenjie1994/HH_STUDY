# -*- coding: utf-8 -*-
# @Time    : 2020/7/16 16:12
# @Author  : 唐家鑫
# @Email   : 1280445703@qq.com
# @File    : clientHr.py
# @Software: PyCharm

# -*- coding: utf-8 -*-
# @Time    : 2020/7/5 11:34
# @Author  : 唐家鑫
# @Email   : 1280445703@qq.com
# @File    : client.py
# @Software: PyCharm
from HRsystem.hr系统初级.student.student import student
from HRsystem.hr系统初级.datebase.conDatabase import tomSql

class client():
    def __init__(self, host,port,user,passwd,dbName,url='studentInfo.txt'):
        self.url = url
        self.student = {}
        self.info = {"姓名": "name", "身份证号": "IDcard", "手机号": "phoneNumber", "性别": "gender",
                     "出生日期": "birthday", "年龄": "age", "学历": "degree",
                     "学校": "school", "应聘岗位": "job", "期望薪资": "salary"}
        # self.readTxt()
        self.readDatabase()
        self.db = tomSql(host, port, user, passwd, dbName)

    def add(self):
        try:
            name, IDcard, phoneNumber, gender, birthday, age, degree, school, job, salary \
                = input("请按照姓名、身份证号、手机号，性别、出生日期、年龄、学历、学校、应聘岗位、期望薪资顺序输入").split()
            if IDcard in self.student:
                print("此身份证号已经存在，请添加不同身份证号同学")
                self.add()
            else:
                self.student[IDcard] = \
                    student(name, IDcard, phoneNumber, gender, birthday, age, degree, school, job, salary)
                print("添加成功!!!")
        except Exception as e:
            print("输入结构出错，请重新输入")
            self.add()

    def delete(self):
        try:
            IDcard = input("请输入要删除学生的身份证号")
            if self.student[IDcard].isDelete == True:
                print("输入结构或信息出错，请重新输入")
                self.delete()
            else:
                self.student[IDcard].isDelete = True
                print("删除成功")
        except Exception as e:
            print("输入结构或信息出错，请重新输入")
            self.delete()

    def alter(self):
        '''
        利用Python的反射方法更改类中的信息
        :return:
        '''
        try:
            string = input("请输入要更正的信息类别")
            if string == "身份证号":
                print("身份证为不可修改信息！请重新输入")
                self.alter()
            else:
                IDcard, info = input("请按身份证号、更正信息输入要更正的信息").split()
                # setattr(obj, attr, val):
                # 调用这个方法将给obj的名为attr的值的属性赋值为val。例如如果attr为’bar’，则相当于obj.bar = val。
                # print(self.info[string])
                setattr(self.student[IDcard], self.info[string], info)
                print("更改成功")
        except Exception as e:
            print(e)
            print("输入结构出错，请重新输入")
            self.alter()

    def selectBasicHr(self):
        '''
        查看学生基本信息,hr可以看到所有学生的信息
        :return:
        '''
        for k, v in self.student.items():
            if v.isDelete == False:
                v.select()
        print("查询完毕！！！")

    def selectBasicStu(self):
        '''
        查看学生基本信息,学生只能看到本人的信息
        :return:
        '''
        try:
            IDcard = input("请输入要查询学生的身份证号")
            if self.student[IDcard].isDelete:
                print("输入结构或信息出错，请重新输入")
                self.selectBasicStu()
            else:
                self.student[IDcard].select()
                print("查询完毕！！！")
        except Exception as e:
            print("输入结构或信息出错，请重新输入")
            self.selectBasicStu()

    def selectEducation(self):
        '''
        查看学生教育经历信息
        :return:
        '''
        for k, v in self.student.items():
            if v.isDelete == False:
                v.select()
        print("查询完毕！！！")

    def selectEvent(self):
        '''
        查看学生招聘进程信息
        :return:
        '''
        for k, v in self.student.items():
            if v.isDelete == False:
                v.select()
        print("查询完毕！！！")


    def printWelcomeHr(self):
        print("====欢迎进入Hr系统--hr界面！！！===")
        print("请输入对应的数字表示进行操作！")
        print("请按1进行查询学生信息操作")
        print("请按2进行查询学生教育经历信息操作")
        print("请按4进行查询学生招聘进程信息操作")
        print("请按5进行更改学生招聘进程信息操作")
        print("请按6退出程序")
    def printWelcomeStu(self):
        '''
        学生的欢迎界面
        :return:
        '''
        print("====欢迎进入Hr系统--学生界面！！！===")
        print("请输入对应的数字表示进行操作！")
        print("请按1进行增加学生信息操作")
        print("请按2进行删除学生基本信息操作")
        print("请按3进行更改学生基本信息操作")
        print("请按4进行删除学生教育经历信息操作")
        print("请按5进行更改学生教育经历信息操作")
        print("请按6进行查询学生信息操作")
        print("请按7进行查询学生教育经历信息操作")
        print("请按8进行查询学生招聘进程信息操作")
        print("请按9退出程序")
        return 5

    def choose(self, num,isStudent="True"):
        '''

        :param num:
        :param isStudent:
        :return:
        '''
        if num == 1:
            self.add()
        elif num == 2:
            self.delete()
        elif num == 3:
            self.alter()
        elif num == 4:
            # 查询学生基本信息
            self.selectBasicStu()
        elif num == 5:
            # self.writeTxt()
            self.saveToDatabase()
            print("程序结束！！！感谢使用。")
            return True
        elif num == 6:
            # 查询学生基本信息
            self.selectBasicStu()
        elif num == 7:
            # 查询学生教育信息
            self.selectEducation()
        elif num == 8:
            # 查询学生基本信息
            self.selectEvent()
        elif num == 9:
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
                    self.student[IDcard] = \
                        student(name, IDcard, phoneNumber, gender, birthday, age,
                                degree, school, job, salary, "True" == isDelete)
                    # print(self.student)
        except Exception as e:
            print(e)

    def saveToDatabase(self):
        pass

    def readDatabase(self):
        pass



if __name__ == '__main__':
    client1 = client('cdb-5buhylba.cd.tencentcdb.com',10056,'root','tangjiaxin19971218','hrSystem')
    while True:
        max = client1.printWelcome()
        num = client1.inputNum(max)
        if client1.choose(num):
            break