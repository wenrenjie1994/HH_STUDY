# -*- coding: utf-8 -*-
# @Time    : 2020/7/5 11:22
# @Author  : 唐家鑫
# @Email   : 1280445703@qq.com
# @File    : mainStu.py
# @Software: PyCharm
from student.student import student
from client.clientStu import client
from communicate.conServer import connectServer


if __name__ == '__main__':
    # client1 = client('cdb-5buhylba.cd.tencentcdb.com',10056,'root','tangjiaxin19971218','hrSystem')
    HOST="192.168.0.103"
    PORT=50007
    s = connectServer(HOST, PORT).s
    while True:
        data = s.recv(10 * 1024).decode('utf-8')
        print(data)
        if  data!="程序结束！！！感谢使用。":
            # 表示程序结束或出现问题
            c = input()
            # 发送数据
            s.sendall(c.encode('utf-8'))
        else:
            # -1表示结束本次程序
            s.close()
            break
        # if client1.choose(num):
        #     break
