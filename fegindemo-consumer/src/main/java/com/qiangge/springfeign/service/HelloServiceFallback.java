package com.qiangge.springfeign.service;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String getUser(String name) {
        return "000_user";
    }

    @Override
    public String getName() {
        return "000_name";
    }
}
