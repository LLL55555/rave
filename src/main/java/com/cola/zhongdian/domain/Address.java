package com.cola.zhongdian.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Admin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("PERSON.ADDRESS")
public class Address implements Serializable {
    private static final long serialVersionUID = -5025795997918315227L;
    @TableId(type = IdType.ASSIGN_UUID)
    private Integer addressId;

    @TableField("ADDRESS1")
    private String address1;

    @TableField("ADDRESS2")
    private String address2;

    @TableField("CITY")
    private String city;

    @TableField("POSTALCODE")
    private String postalcode;






}
