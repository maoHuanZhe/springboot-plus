package com.fgrapp.learn.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Salesbill
 *
 * @author fan guang rui
 * @date 2020年12月07日 19:18
 */
@Data
@ApiModel(value="账单对象",description="账单对象Salesbill")
public class Salesbill {

    @ApiModelProperty(value = "账单编号")
    private long id;
    @ApiModelProperty(value = "日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @ApiModelProperty(value = "销售客户")
    private long customerID;
    @ApiModelProperty(value = "销售种类")
    private long categoryID;
    @ApiModelProperty(value = "单价")
    private double price;
    @ApiModelProperty(value = "毛重")
    private double grossWeight;
    @ApiModelProperty(value = "皮重")
    private double tareWeight;
    @ApiModelProperty(value = "备注")
    private String remack;
    @ApiModelProperty(value = "销售地;0:店里;1:车上")
    private long address;
    @ApiModelProperty(value = "创建人")
    private String createName;
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
