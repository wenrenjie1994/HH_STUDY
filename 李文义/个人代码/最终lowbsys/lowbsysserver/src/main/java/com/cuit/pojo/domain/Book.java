package com.cuit.pojo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @author liwenyi
 * @date 2020/7/13
 * desc:
 */
@Data
@TableName("book")
public class Book implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @NotBlank(message = "书名不能为空")
    private String bookName;

    @NotBlank(message = "作者不能为空")
    private String author;

    //@NumberFormat(pattern = "#.##")   //浮点数类型格式化无效
    //使用String代替BigDecimal，解决序列化时小数末尾0丢失问题
    private String price;

    private String bookDesc;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date modifiedTime;

    @TableLogic
    private Integer isDelete;
}
