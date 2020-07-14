package com.lihang.util;

import com.lihang.pojo.Response;
import com.lihang.pojo.Resume;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: LI
 * Date: 2020/7/14
 */
public class Parse {
   public static Resume buildResume(String message){
       String[] deatil = message.split(",");
       return new Resume(deatil[0],deatil[1],deatil[2],0,0);
   }
   public static String responseToString(Response response){
       StringBuffer buffer = new StringBuffer();
       buffer.append(response.getCode());
       buffer.append("/");
       buffer.append(response.getDetail());
       return buffer.toString();
   }
}
