package com.qiangge.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@ComponentScan(basePackages = {"com.qiangge.aop","com.qiangge"})
public class ProvideAopApplication {

    public static void main(String args[]){
        SpringApplication.run(ProvideAopApplication.class,args);
    }
}
