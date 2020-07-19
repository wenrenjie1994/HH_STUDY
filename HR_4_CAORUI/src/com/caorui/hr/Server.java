package com.caorui.hr;


import com.caorui.service.ApplicantService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static String choice(String[] strings) {
        int ch = Integer.parseInt(strings[0]);
        if (ch == 1) {
            return ApplicantService.insert(strings);
        } else if (ch == 2) {
            return ApplicantService.select(strings);
        } else if (ch == 3) {
            return ApplicantService.delete(strings);
        } else if (ch == 4) {
            return ApplicantService.update(strings);
        } else {
            return "输入有误，请重新输入";
        }
    }

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true){
            Socket socket1 = null;
            try {
                socket1 = serverSocket.accept();
                new HandleThread(socket1).start();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }
}
