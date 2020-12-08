package com.fgrapp.learn.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Salesbill
 *
 * @author fan guang rui
 * @date 2020年12月08日 15:08
 */
@Data
public class Salesbill {
    private long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private long customerID;
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

