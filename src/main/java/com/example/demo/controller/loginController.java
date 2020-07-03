package com.example.demo.controller;
import com.alibaba.fastjson.JSON;
import com.example.demo.model.User;
import com.example.demo.service.WmsUserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class loginController {


    @Autowired
    private WmsUserService wmsUserService;

    @RequestMapping("login")
    public String index(){
        return "login";
    }

    @RequestMapping("main")
    public String index2(){
        return "main";
    }

    @RequestMapping(value = "loginCheck")
    @ResponseBody
    public Map<Object,Object> userLogin(@RequestBody String message){
        Map<Object,Object> map = new HashMap<>();
        JSONObject jsonObject = JSONObject.fromObject(message);
        String userName =(String)jsonObject.get("userName");
        String password = (String) jsonObject.get("userPassword");
        User wmsUser = wmsUserService.selectByNameAndPassword(userName,password);
        int code = 0;
        if(wmsUser !=  null){
            code = 1;
        }
        map.put("code",code);
        map.put("userName",userName);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "updatePassword")
    public com.alibaba.fastjson.JSONObject updatePassword(@RequestParam Map<String, String> map){
        User user = getUser(map);
        user.setId(wmsUserService.selectByNameAndPassword(user.getName(),user.getPassword()).getId());
        System.out.println(user.toString());
        int code = 0;
        if(wmsUserService.selectByNameAndPassword(user.getName(),user.getPassword()) == null){
            code = 2;
        }else if(map.get("oldPassword").equals(map.get("newPassword"))){
            code = 3;
        }else {
            code = 1;
            user.setPassword(map.get("newPassword"));
            wmsUserService.update(user);
        }
        return JSON.parseObject("{ code : " + code + "}");
    }

    public User getUser(Map<String, String> map){
        User user = new User();
        user.setName(map.get("name"));
        user.setPassword(map.get("oldPassword"));
        return  user;
    }

}
