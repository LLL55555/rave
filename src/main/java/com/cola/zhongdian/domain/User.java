package com.cola.zhongdian.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("TEST.AUTHOR")
public class User {

    @TableId(type = IdType.ASSIGN_UUID)
    private Integer id;

    @TableField("NAME")
    private String name;

    @TableField("AGE")
    private String age;
}
