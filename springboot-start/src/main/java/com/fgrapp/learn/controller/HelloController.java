package com.fgrapp.learn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author fan guang rui
 * @date 2020年12月07日 15:44
 */
@RestController
public class HelloController {
    @RequestMapping("hello")
    public String hello(){
        return "springboot-plus-start";
    }
}
