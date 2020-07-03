package com.example.demo.dao;

import com.example.demo.model.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class WmsUserDao {
    private final static String NAMESPACE = "com.example.demo.dao.WmsUserDao.";

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public ArrayList<User> findAll(){
        List<User> userList = sqlSessionTemplate.selectList(NAMESPACE+"findAll");
        return (ArrayList<User>)userList;
    }

    public User selectByUserID(Integer userID){
        User wmsUser = sqlSessionTemplate.selectOne(NAMESPACE+"selectByUserID",userID);
        return wmsUser;
    }

    public User selectByName(String userName){
        User wmsUser = sqlSessionTemplate.selectOne(NAMESPACE+"selectByName",userName);
        return wmsUser;
    }

    public void update(User user){
        sqlSessionTemplate.update(NAMESPACE+"update",user);
    }

    public void deleteById(Integer id){
        sqlSessionTemplate.delete(NAMESPACE+"deleteById",id);
    }

    public void insert(User user){
        sqlSessionTemplate.insert(NAMESPACE+"insert",user);
    }

    public User selectByNameAndPassword(String userName, String password){
        Map<String,String> map = new HashMap<>();
        map.put("userName",userName);
        map.put("password",password);
        User wmsUser = sqlSessionTemplate.selectOne(NAMESPACE+"selectByNameAndPassword",map);
        return wmsUser;
    }

}
