package com.fgrapp.learn.controller;

import com.fgrapp.learn.entities.Salesbill;
import org.springframework.web.bind.annotation.*;

/**
 * SalesbillController
 *
 * @author fan guang rui
 * @date 2020年12月08日 15:07
 */
@RestController
@RequestMapping("Salesbill")
public class SalesbillController {

    @GetMapping("{id}")
    public Salesbill getSalesbillById(@PathVariable("id") long id){
        return new Salesbill();
    }
    @PostMapping
    public Salesbill insert(@RequestBody Salesbill salesbill){
        return salesbill;
    }
    @PutMapping
    public Salesbill update(@RequestBody Salesbill salesbill){
        return salesbill;
    }
    @DeleteMapping("{ids}")
    public boolean deleteById(@PathVariable("ids") Long[] ids){
        return true;
    }
}
