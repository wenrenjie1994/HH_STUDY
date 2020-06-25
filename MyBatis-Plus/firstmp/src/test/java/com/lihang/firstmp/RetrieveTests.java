package com.lihang.firstmp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.lihang.firstmp.dao.UserMapper;
import com.lihang.firstmp.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: LI
 * Date: 2020/5/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RetrieveTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void select() {
        List<User> users = userMapper.selectList(null);
        // Assert.assertEquals(4,users.size());
        users.forEach(System.out::println);
    }
    @Test
    public void selectById(){
        User user = userMapper.selectById(1087982257332887553L);
        System.out.println(user);
    }

    @Test
    public void selectByIds(){
        List<Long> list = Arrays.asList(1087982257332887553L,1088248166370832179L,1088248166370832385L);
        List<User> users = userMapper.selectBatchIds(list);
        users.forEach(System.out::println);
    }

    @Test
    public void selectByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("age",40);//此处的key为表字段名，非实体类属性名
        map.put("name","戴笠");
        List<User> users  = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    /*条件查询*/
    /*
    * name中包含明，且年龄小于40
    * */
    @Test
    public void selectByWrapper(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name","明").lt("age",40);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /*
    * 名字中有明，40>=age>=20,email不为空，
    * */
    @Test
    public void selectByWrapper2(){
        QueryWrapper<User> wrapper = Wrappers.<User>query();
        wrapper.like("name","明").between("age",20,40).isNotNull("create_time");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /*
    * 姓明的或者年龄小于50的，，按照年龄降序，年龄相同按照id升序
    * */
    @Test
    public void selectByWrapper3(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.likeRight("name","明").or().gt("age",25).orderByDesc("age").orderByAsc("id");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /*
    * 条件构造，日期为2020-05-01，managerId .....
    * */
    @Test
    public void selectByWrapper4(){
        QueryWrapper<User> wrapper = Wrappers.query();
        //wrapper.apply("DATE_FORMAT(create_time,%Y-%m-%d)={0}","2020-05-01");
       /* .inSql("manager_id","select id from user where name='戴笠'");*/
        wrapper.apply("DATE_FORMAT(create_time,'%Y-%m-%d')={0}","2020-05-01");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /*
    *名字为明姓，并且年龄小于40并且邮箱不为空
    * */
    @Test
    public void selectByWrapper5(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name","明").and(wq->wq.lt("age",40).or().isNotNull("email"));
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /*
    * 名字为明姓，或者（年龄小于40并且大于20并且邮箱不为空）
    * */
    @Test
    public void selectByWrapper6(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.likeRight("name","明").or(wq->wq.between("age",20,40).isNotNull("email"));
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /*
    * (年龄小于40或者邮箱不为空)并且为明姓
    * */
    @Test
    public void selectByWrapper7(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Consumer<QueryWrapper<User>> consumer = new Consumer<QueryWrapper<User>>() {
            @Override
            public void accept(QueryWrapper<User> wrapper) {
                wrapper.lt("age",40).or().isNotNull("email");
            }
        };
        wrapper.nested(consumer).like("name","明");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
    /*
    * age为 21，24，26，35
    * */
    @Test
    public void selectByWrapper8(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.in("age",Arrays.asList(21,24,26,35));
        List<User>  users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /*
    只返回满足条件的一条数据
    limit 1
     */
    @Test
    public void selectByWrapper9(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.in("age",Arrays.asList(21,24,26,40)).last("limit 1");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /*
    不显示查询的所有列
    select id ,name ,,,,
     */
    @Test
    public void selectByWrapperSupper(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("name","age").like("name","王").lt("age",40);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
    @Test
    public void selectByWrapperSupper2(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name","王").lt("age",40)
        .select(User.class,info ->!info.getColumn().equals("managerId")&&!info.getColumn().equals("createTime"));
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /*
    * condition条件
    * */
    @Test
    public void selectByWrapper10(){
        String name = "明";
        String email = "@";
        testCondition(name,email);
    }
    public void testCondition(String name,String email){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(name),"name",name).or(wq->wq.like(StringUtils.isNotBlank(email),"email",email));
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /*
    带参数的QueryWrapper
     */
    @Test
    public void selectWrapperEntity(){
        User user = new User();
        user.setName("明台");///等值查询，若其他查询（大于）z哎字段上加 @TableField(condition = SqlCondition.LIKE)
    /*    private String name;
        //年龄
        @TableField(condition = "%s&lt;&gt;#{%s}")
        private Integer age;*/
        QueryWrapper<User> wrapper = new QueryWrapper<User>(user);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /**
     * allEqual
     */
    @Test
    public void selectByWrapperAllEuqal(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Map<String,Object> map = new HashMap<>();
        map.put("name","明楼");
        map.put("age",null);
        //wrapper.allEq(map,false);
        wrapper.allEq((K,V)->!K.equals("name"),map,false);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /**
     * 返回map，只显示需要的字段
     */
    @Test
    public void selectByWrapperMaps(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("name","age").like("name","明").lt("age",40);
        List<Map<String,Object>> map = userMapper.selectMaps(wrapper);
        map.forEach(System.out::println);
    }
    /*按 置属上级分组，查询每组的平均年龄，最大年龄，最小年龄
     *并且只取年龄总和小于500的组
     * select avg(age) avg_age,min(age)min_age,max(age)max_age
     * from user
     * group by manager_id
     * having sum(age)<500
 */
    @Test
    public void selectByWrapperMapsFunctions(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("avg(age)avg_age","min(age)min_age","max(age)max_age")
                .groupBy("manager_id")
                .having("sum(age)<{0}",500);
        List<Map<String,Object>> users = userMapper.selectMaps(wrapper);
        users.forEach(System.out::println);
    }
    /*
    * 只返回一列
    * */
    @Test
    public void selectWrapperObjs(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("id","name").like("name","明").lt("age",50);
        List<Object> users = userMapper.selectObjs(wrapper);
        users.forEach(System.out::println);
    }
    /*
    * 查询总记录数
    * */
    @Test
    public void selectWrapperCount(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name","明").lt("age",50);
        Integer count = userMapper.selectCount(wrapper);
        System.out.println(count);
    }
    /*
    * 只能返回一条记录
    * */
    @Test
    public void selectWrapperOne(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name","明台").lt("age",50);
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }
    /*
    * Lambda条件构造器
    * LambdaQueryWrapper<User> lambda = new QueryWrapper<User>().lambda();
        LambdaQueryWrapper<User> lambda = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<User> lambda = Wrappers.<User>lambdaQuery();
    * */
    @Test
    public void selectByLambda(){
        LambdaQueryWrapper<User> lambda = Wrappers.<User>lambdaQuery();
        lambda.like(User::getName,"明").lt(User::getAge,40);
        List<User> users = userMapper.selectList(lambda);
        users.forEach(System.out::println);

    }

    @Test
    public void selectByLambda2(){
        LambdaQueryWrapper<User> lambda = Wrappers.<User>lambdaQuery();
        lambda.likeRight(User::getName,"明").and(qw->qw.lt(User::getAge,40).or().isNotNull(User::getEmail));
        List<User> users = userMapper.selectList(lambda);
        users.forEach(System.out::println);
    }

    @Test
    public void selectByLambda3(){
        List<User> users = new LambdaQueryChainWrapper<User>(userMapper).like(User::getName,"明").list();
        users.forEach(System.out::println);
    }

    /*
    * Sql语句
    * */
    @Test
    public void selectMy(){
        LambdaQueryWrapper<User> lambda = Wrappers.<User>lambdaQuery();
        lambda.likeRight(User::getName,"明");
        List<User> users = userMapper.selectAll(lambda);
        users.forEach(System.out::println);

    }



















}
