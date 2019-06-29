package com.qq.j1902.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/6/25.
 */
@RestController
public class HelloController {
    @RequestMapping("/dept")
    public String dept(@RequestParam("name")String dname,@RequestParam("loc")String loc){
        return "hello: "+dname+", loc :"+loc;
    }
    @RequestMapping(value = "/dept2",method = RequestMethod.POST)
    public String dept2(@RequestParam("name")String dname,@RequestParam("loc")String loc){
        return "hello post: "+dname+", loc :"+loc;
    }
}
