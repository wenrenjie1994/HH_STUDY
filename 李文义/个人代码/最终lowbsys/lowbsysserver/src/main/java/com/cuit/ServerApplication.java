package com.cuit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by liwenyi
 * Date: 2020/7/11
 * Desc:
 */
@SpringBootApplication
@MapperScan("com.cuit.dao")
public class ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
        System.out.println("                                _ooOoo_\n" +
                "                               o8888888o\n" +
                "                               88\" . \"88\n" +
                "                               (| ^_^ |)\n" +
                "                               O\\  =  /O\n" +
                "                            ____/`---'\\____\n" +
                "                          .'  \\\\|     |//  `.\n" +
                "                         /  \\\\|||  :  |||//  \\\n" +
                "                        /  _||||| -:- |||||-  \\\n" +
                "                        |   | \\\\\\  -  /// |   |\n" +
                "                        | \\_|  ''\\---/''  |   |\n" +
                "                        \\  .-\\__  `-`  ___/-. /\n" +
                "                      ___`. .'  /--.--\\  `. . ___\n" +
                "                    .\"\" '<  `.___\\_<|>_/___.'  >'\"\".\n" +
                "                  | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |\n" +
                "                  \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /\n" +
                "            ========`-.____`-.___\\_____/___.-`____.-'========\n" +
                "                                `=---='\n" +
                "            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" +
                "                    佛祖保佑       永不宕机      永无BUG");
    }
}