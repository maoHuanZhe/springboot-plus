package com.fgrapp.learn.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Salesbill
 *
 * @author fan guang rui
 * @date 2020年12月07日 16:39
 */
@Data
@TableName("salesbill")
public class Salesbill {

    @TableId(value = "billId",type = IdType.AUTO)
    private long billId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @TableField("customerID")
    private long customerID;
    @TableField("categoryID")
    private long categoryID;
    private double price;
    private double grossWeight;
    private double tareWeight;
    private String remack;
    private long address;
    private String createName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
