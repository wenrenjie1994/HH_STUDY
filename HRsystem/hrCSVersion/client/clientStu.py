# -*- coding: utf-8 -*-
# @Time    : 2020/7/5 11:34
# @Author  : 唐家鑫
# @Email   : 1280445703@qq.com
# @File    : clientStu.py
# @Software: PyCharm
import socket
import threading

from HRsystem.hrCSVersion.student.student import student
from HRsystem.hrCSVersion.datebase.conDatabase import tomSql


class client():
    def __init__(self, host, port, user, passwd, dbName, HOSTSer,PORTSer,numberSer,flow,url='studentInfo.txt'):
        self.url = url
        self.student = {}
        self.info = {"姓名": "name", "身份证号": "IDcard", "手机号": "phoneNumber", "性别": "gender",
                     "出生日期": "birthday", "年龄": "age", "学历": "degree",
                     "学校": "school", "应聘岗位": "job", "期望薪资": "salary",
                     "开始时间": "startTime", "结束时间": "endTime"}
        # self.readTxt()
        self.db = tomSql(host, port, user, passwd, dbName)
        self.EducationId = 0
        self.readDatabase()

        # 数据库ip地址
        self.HOST = HOSTSer
        # 数据库的端口
        self.PORT = PORTSer
        # 设定最大连接数量
        self.number = numberSer
        # 设定每次接收的最大字节数
        self.flow = flow
        # ip与会话对应的字典
        self.sessionChat = {}
        # ip地址列表
        self.addrList = []
        # id会话字典
        self.idSocket = {}
    def add(self,conn):
        try:
            conn.sendall("请按照姓名、身份证号、手机号，性别、出生日期、年龄、应聘岗位、期望薪资顺序输入".encode('utf-8'))
            # strData =  conn.recv(self.flow).decode('utf-8').split()
            name, IDcard, phoneNumber, gender, birthday, age, job, salary \
                = conn.recv(self.flow).decode('utf-8').split()
            if phoneNumber in self.student:
                conn.sendall("此手机号已经存在，请添加不同手机号同学\n".encode('utf-8'))
                # print("此手机号已经存在，请添加不同手机号同学")
                self.add(conn)
            else:
                self.student[phoneNumber] = \
                    student(name, IDcard, phoneNumber, gender, birthday, age, job, salary)
                conn.sendall("添加成功!!!\n".encode('utf-8'))
                # print("添加成功!!!")
        except Exception as e:
            # print(e)
            conn.sendall("输入结构出错，请重新输入\n".encode('utf-8'))
            # print("输入结构出错，请重新输入")
            self.add(conn)

    def delete(self,conn):
        try:
            conn.sendall("请输入要删除学生的身份证号\n".encode('utf-8'))
            phoneNumber =conn.recv(self.flow).decode('utf-8')
            if self.student[phoneNumber].isDelete == True:
                conn.sendall("输入结构或信息出错，请重新输入\n".encode('utf-8'))
                # print("输入结构或信息出错，请重新输入")
                self.delete(conn)
            else:
                self.student[phoneNumber].isDelete = True
                print("删除成功\n")
        except Exception as e:
            conn.sendall("输入结构或信息出错，请重新输入\n".encode('utf-8'))
            self.delete(conn)

    def alter(self,conn):
        '''
        利用Python的反射方法更改类中的信息
        :return:
        '''
        try:
            conn.sendall("1\t请输入要更正的信息类别".encode('utf-8'))
            string =conn.recv(self.flow).decode('utf-8')
            if string == "手机号":
                conn.sendall("手机号为不可修改信息！请重新输入\n".encode('utf-8'))
                # print("手机号为不可修改信息！请重新输入")
                self.alter(conn)
            else:
                conn.sendall("请按手机号、更正信息输入要更正的信息\n".encode('utf-8'))

                phoneNumber, info =conn.recv(self.flow).decode('utf-8').split()
                # setattr(obj, attr, val):
                # 调用这个方法将给obj的名为attr的值的属性赋值为val。例如如果attr为’bar’，则相当于obj.bar = val。
                # print(self.info[string])
                setattr(self.student[phoneNumber], self.info[string], info)
                conn.sendall("更改成功\n".encode('utf-8'))
                # print("更改成功")
        except Exception as e:
            # print(e)
            conn.sendall("输入结构或信息出错，请重新输入\n".encode('utf-8'))
            self.alter(conn)

    def addEducation(self,conn):
        '''
        增加学生的教育信息
        :return:
        '''
        try:
            conn.sendall("请按照手机号、学历、毕业学校、开始时间，结束时间顺序输入".encode('utf-8'))
            phoneNumber, degree, school, startTime, endTime \
                = conn.recv(self.flow).decode('utf-8').split()
            if degree in self.student[phoneNumber].degree:
                conn.sendall("此学历已经存在，请添加不同学历层次\n".encode('utf-8'))
                # print("此学历已经存在，请添加不同学历层次")
                self.addEducation(conn)
            else:
                self.student[phoneNumber].setEducation(degree, school, startTime, endTime)
                conn.sendall("添加成功!!!\n".encode('utf-8'))
                # print("添加成功!!!")
        except Exception as e:
            conn.sendall("输入结构或信息出错，请重新输入\n".encode('utf-8'))
            self.addEducation(conn)

    def deleteEducation(self,conn):
        # 简化流程
        pass

    def alterEducation(self,conn):
        '''
        简化流程
        :return:
        '''
        pass

    def selectBasic(self,conn):
        '''
        查看学生基本信息,学生只能看到本人的信息
        :return:
        '''
        try:
            # for k,v in self.student.items():
            #     print(v.select())
            conn.sendall("请输入要查询学生的手机号".encode('utf-8'))
            phoneNumber = conn.recv(self.flow).decode('utf-8')
            # print(self.student[phoneNumber].select())
            if self.student[phoneNumber].isDelete == True:
                conn.sendall("输入结构或信息出错，请重新输入\n".encode('utf-8'))
                self.selectBasic(conn)
            else:
                # print(self.student[phoneNumber].select() + "\n")
                conn.sendall((self.student[phoneNumber].select()+"\n").encode('utf-8'))
                conn.sendall("查询完毕！！！\n".encode('utf-8'))
                # print("查询完毕！！！")
        except Exception as e:
            print(e)
            conn.sendall("输入结构或信息出错，请重新输入\n".encode('utf-8'))
            self.selectBasic(conn)

    def selectEducation(self,conn):
        '''
        查看学生教育经历信息
        :return:
        '''
        try:
            conn.sendall("请输入要查询学生的手机号".encode('utf-8'))
            phoneNumber = conn.recv(self.flow).decode('utf-8')

            if self.student[phoneNumber].isDelete == True:
                conn.sendall("输入结构或信息出错，请重新输入\n".encode('utf-8'))
                self.selectEducation(conn)
            else:

                conn.sendall((self.student[phoneNumber].getEducation()+"\n").encode('utf-8'))

                conn.sendall("查询完毕！！！\n".encode('utf-8'))
        except Exception as e:
            # print(e)
            conn.sendall("输入结构或信息出错，请重新输入\n".encode('utf-8'))
            self.selectEducation(conn)

    def selectEvent(self,conn):
        '''
        查看学生招聘进程信息
        :return:
        '''
        try:
            conn.sendall("请输入要查询学生的手机号".encode('utf-8'))
            phoneNumber = conn.recv(self.flow).decode('utf-8')
            if self.student[phoneNumber].isDelete == True:
                conn.sendall("输入结构或信息出错，请重新输入\n".encode('utf-8'))
                self.selectEducation(conn)
            else:
                conn.sendall(( self.student[phoneNumber].getEvent()+"\n").encode('utf-8'))

                conn.sendall("查询完毕！！！\n".encode('utf-8'))
        except Exception as e:
            conn.sendall("输入结构或信息出错，请重新输入\n".encode('utf-8'))
            self.selectEducation(conn)

    def printWelcome(self):
        '''
        学生的欢迎界面
        :return:
        '''
        # print("====欢迎进入Hr系统--学生界面！！！===")
        # print("请输入对应的数字表示进行操作！")
        # print("请按1进行增加学生信息操作")
        # print("请按2进行删除学生基本信息操作")
        # print("请按3进行更改学生基本信息操作")
        # print("请按4进行增加学生教育经历信息操作")
        # print("请按5进行删除学生教育经历信息操作")
        # print("请按6进行更改学生教育经历信息操作")
        # print("请按7进行查询学生信息操作")
        # print("请按8进行查询学生教育经历信息操作")
        # print("请按9进行查询学生招聘进程信息操作")
        # print("请按10退出程序")
        self.max=10
        str="1\t"+"====欢迎进入Hr系统--学生界面！！！===\n"+"请输入对应的数字表示进行操作！\n"+\
            "请按1进行增加学生信息操作\n"+"请按2进行删除学生基本信息操作\n"+\
            "请按3进行更改学生基本信息操作\n"+"请按4进行增加学生教育经历信息操作\n"+\
            "请按5进行删除学生教育经历信息操作\n"+"请按6进行更改学生教育经历信息操作\n"+\
            "请按7进行查询学生信息操作\n"+"请按8进行查询学生教育经历信息操作\n"+\
            "请按9进行查询学生招聘进程信息操作\n"+"请按10退出程序"

        return str
    def choose(self, num,conn):
        '''

        :param num:
        :param isStudent:
        :return:
        '''
        if num == 1:
            self.add(conn)
        elif num == 2:
            self.delete(conn)
        elif num == 3:
            self.alter(conn)
        elif num == 4:
            # 增加学生教育信息
            self.addEducation(conn)
        elif num == 5:
            # 删除学生教育信息
            self.deleteEducation(conn)
        elif num == 6:
            # 更改学生教育信息
            self.alterEducation(conn)
        elif num == 7:
            # 查询学生基本信息
            self.selectBasic(conn)
        elif num == 8:
            # 查询学生教育信息
            self.selectEducation(conn)
        elif num == 9:
            # 查询学生招聘进程信息
            self.selectEvent(conn)
        elif num == 10:
            # self.writeTxt()
            self.saveToDatabase()
            conn.sendall("程序结束！！！感谢使用。".encode('utf-8'))
            # print("程序结束！！！感谢使用。")
            return True
        return False

    def inputNum(self,conn):
        try:
            num = conn.recv(self.flow).decode('utf-8')
            num = int(num)
        except Exception as e:
            conn.sendall("输入非数字，请重新输入\n".encode('utf-8'))
            # print("输入非数字，请重新输入")
            num = self.inputNum(conn)
            return num
        if num > self.max or num < 1:
            num = self.inputNum(conn)

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
            self.db.delete("stuEducation")
            # 外键约束
            # print(1)
            self.db.delete("student")
            for k, v in self.student.items():
                # 先删除数据库的数据再把内存中的数据加入数据库
                strStudent, strEducation, strEvent = v.writeInfo()
                # 也可以采用封装每次操作的sql语句，最后整体进行执行，但这里太麻烦暂时放弃

                # 学生端只能对招聘进程信息做查询不能做任何的修改
                # self.db.delete("event")
                # print(1)
                # print(self.db.get_all("student"))

                self.db.insert("student", strStudent)
                if strEducation:
                    self.db.insert("stuEducation", strEducation)
                # self.db.insert("event", strEvent)
        except Exception as e:
            print(e)
    def tcplink(self ,conn):
        while True:
            try:

                conn.sendall(self.printWelcome().encode('utf-8'))
                result = self.inputNum(conn)
                self.choose(result,conn)

            except Exception as e:
                print(e)
                break
        conn.close()

    def run(self):
        s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        # 绑定socket
        s.bind((self.HOST, self.PORT))
        # 开始监听
        s.listen(self.number)
        while True:
            try:
                conn , addr = s.accept()
                # print(conn)
                print("Connected by",addr)

                t = threading.Thread(target=self.tcplink, args=(conn,))
                t.start()

            except Exception as e:
                print(e)
                s.close()

if __name__ == '__main__':
    client1 = client('cdb-5buhylba.cd.tencentcdb.com', 10056, 'root', 'tangjiaxin19971218', 'hrSystem','',50007,10,10*1024)
    client1.run()
    # while True:
    #     max = client1.printWelcome()
    #     num = client1.inputNum(max)
    #     if client1.choose(num):
    #         break
