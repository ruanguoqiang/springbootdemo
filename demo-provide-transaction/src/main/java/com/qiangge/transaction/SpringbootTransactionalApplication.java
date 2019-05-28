package com.qiangge.transaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.qiangge.transaction.dao")
@EnableDiscoveryClient
@EnableCircuitBreaker
public class SpringbootTransactionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTransactionalApplication.class, args);
	}

}

