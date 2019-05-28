package com.qiangge.webservice.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class WebserviceClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebserviceClientApplication.class, args);
    }
}
