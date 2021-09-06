package com.fgrapp.learn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fgrapp.learn.entities.Salesbill;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * SalesbillMapper
 *
 * @author fan guang rui
 * @date 2020年12月07日 16:40
 */
public interface SalesbillMapper extends BaseMapper<Salesbill> {
    /**
     * 批量插入
     * @param batchList 插入列表
     * @return 插入数量
     */
    int insertBatch(@Param("list") List<Salesbill> batchList);
    IPage<Salesbill> getPage(Page<Salesbill> paramPage, @Param(Constants.WRAPPER) Map<String, Object> map);
}
