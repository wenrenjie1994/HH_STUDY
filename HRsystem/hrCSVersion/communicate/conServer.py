# -*- coding: utf-8 -*-
# @Time    : 2019/6/7 17:51
# @Author  : 唐家鑫
# @Email   : 1280445703@qq.com
# @File    : conServer.py
# @Software: PyCharm
import socket
import sys
class connectServer():
    def __init__(self, HOST, PORT):
        self.HOST = HOST
        self.PORT = PORT
        self.connect()

    def connect(self):
        # 服务端主机IP地址
        HOST = self.HOST
        # HOST = "45.40.201.180"
        # 服务器主机端口号
        PORT = self.PORT
        # 创建一个socket
        #   参数1:指定协议 AF_INET 或AF_INET6
        #   参数2:SOCK_STREAM执行使用面向流的TCP协议
        self.s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        try:
            # 连接
            self.s.connect((HOST, PORT))
        except Exception as e:
            print("Server not found or nor open")
            sys.exit()

        return self.s