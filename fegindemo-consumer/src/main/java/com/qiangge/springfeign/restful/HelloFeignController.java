package com.qiangge.springfeign.restful;

import com.qiangge.springfeign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloFeignController {

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/feignname")
    public String getName(@RequestParam String name){
        return helloService.getUser(name);
    }

    @GetMapping(value = "/feignuser")
    public Map getUser(){
        String name=helloService.getName();
        Map<String,String> map=new HashMap<>();
        map.put("a",name);
        map.put("b","abc");
        return map;
    }

}
