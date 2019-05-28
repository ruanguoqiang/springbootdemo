package com.qiangge.springfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "demo-provide",fallback = HelloServiceFallback.class )
public interface HelloService {

    @RequestMapping(value = "/hello/index",method = RequestMethod.GET)
    public String getUser(@RequestParam("name") String name);

    @RequestMapping(value = "/hello/ceshi",method = RequestMethod.GET)
    public String getName();
}
