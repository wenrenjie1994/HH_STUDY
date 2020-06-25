package com.lihang.firstmp.entity;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: LI
 * Date: 2020/5/25
 */
@Data
/*@TableName("mp_user")*/
public class User {
    //主键
   /* @TableId("user_id")*/
    private Long id;
    //姓名
   /* @TableField("name")
    private String realName;*/
    private String name;
    //年龄
    private Integer age;
    //邮箱
    private String email;
    //直属上级
    private Long managerId;
    //创建时间
    private LocalDateTime createTime;
    //评论
 /*   @TableField(exist = false)
    private String remark;*/
}
