package com.qiangge.anonation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
@ComponentScan("com.qiangge")
public class ProvideAnnonationApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProvideAnnonationApplication.class, args);
    }

}

