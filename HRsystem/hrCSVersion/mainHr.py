# -*- coding: utf-8 -*-
# @Time    : 2020/7/22 17:09
# @Author  : 唐家鑫
# @Email   : 1280445703@qq.com
# @File    : mainHr.py
# @Software: PyCharm

from student.student import student
from client.clientHr import clientHr

if __name__ == '__main__':
    client1 = clientHr('cdb-5buhylba.cd.tencentcdb.com',10056,'root','tangjiaxin19971218','hrSystem')
    while True:
        max = client1.printWelcome()
        num = client1.inputNum(max)
        if client1.choose(num):
            break