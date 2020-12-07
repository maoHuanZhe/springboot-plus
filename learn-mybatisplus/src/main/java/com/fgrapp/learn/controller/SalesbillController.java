package com.fgrapp.learn.controller;

import com.fgrapp.learn.entities.Salesbill;
import com.fgrapp.learn.service.SalesbillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * SalesbillController
 *
 * @author fan guang rui
 * @date 2020年12月07日 16:43
 */
@RestController
@RequestMapping("Salesbill")
public class SalesbillController {
    @Autowired
    private SalesbillService service;

    @GetMapping("{id}")
    public Salesbill getSalesbillById(@PathVariable("id") long id){
        return service.getById(id);
    }
    @PostMapping
    public Salesbill insert(@RequestBody Salesbill salesbill){
        service.save(salesbill);
        return salesbill;
    }
    @PutMapping
    public Salesbill update(@RequestBody Salesbill salesbill){
        service.updateById(salesbill);
        return salesbill;
    }
    @DeleteMapping("{ids}")
    public boolean deleteById(@PathVariable("ids") Long[] ids){
        return service.removeByIds(Arrays.asList(ids));
    }
}
