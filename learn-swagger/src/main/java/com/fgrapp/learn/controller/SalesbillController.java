package com.fgrapp.learn.controller;

import com.fgrapp.learn.entities.Salesbill;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * SalesbillController
 *
 * @author fan guang rui
 * @date 2020年12月07日 19:19
 */
@Api(tags="账单类控制器2")
@RestController
@RequestMapping("Salesbill")
public class SalesbillController {

    @GetMapping("{id}")
    @ApiOperation(value = "根据编号获取账单信息",notes = "根据编号获取账单信息")
    public Salesbill getSalesbillById(@ApiParam(name="id",value="账单编号",required=true)@PathVariable("id") long id){
        return new Salesbill();
    }
    @PostMapping
    @ApiOperation(value = "新增账单信息",notes = "新增账单信息")
    @ApiImplicitParam(name = "salesbill", value = "账单实体salesbill", required = true, dataType = "Salesbill")
    public Salesbill insert(@RequestBody Salesbill salesbill){
        return salesbill;
    }
    @PutMapping
    @ApiOperation(value = "修改账单信息",notes = "修改账单信息")
    @ApiImplicitParam(name = "salesbill", value = "账单实体salesbill", required = true, dataType = "Salesbill")
    public Salesbill update(@RequestBody Salesbill salesbill){
        return salesbill;
    }
    @DeleteMapping("{ids}")
    @ApiOperation(value = "根据编号列表删除账单信息",notes = "根据编号列表删除账单信息")
    public boolean deleteById(@PathVariable("ids") Long[] ids){
        return true;
    }
}
