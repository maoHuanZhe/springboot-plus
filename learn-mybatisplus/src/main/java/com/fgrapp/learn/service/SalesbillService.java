package com.fgrapp.learn.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fgrapp.learn.dao.SalesbillMapper;
import com.fgrapp.learn.entities.Salesbill;
import com.fgrapp.learn.util.PageUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * SalesbillService
 *
 * @author fan guang rui
 * @date 2020年12月07日 16:42
 */
@Service
public class SalesbillService extends ServiceImpl<SalesbillMapper, Salesbill> {
    public void insertBatch(List<Salesbill> list){
        baseMapper.insertBatch(list);
    }
    public IPage<Salesbill> getPage(Map<String, Object> map) {
        return baseMapper.getPage(PageUtil.getParamPage(map, Salesbill.class),map);
    }
}
