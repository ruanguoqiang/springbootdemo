package com.qiangge.provide3.controller;

import com.qiangge.provide3.testconfigure.ConnectionProvide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/configure")
public class TestConnectionController {
    @Autowired
    ConnectionProvide connectionProvide;
    @GetMapping(value = "/testConfigure")
    public Map getProperties(){
        Map<String,String> stringMap=new HashMap<>();
        stringMap.put("url",connectionProvide.getUrl());
        stringMap.put("port",connectionProvide.getPort().toString());
        connectionProvide.helloworld();
        return stringMap;
    }
}
