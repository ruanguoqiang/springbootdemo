package com.qiangge.provide3.testconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectConfiguration {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private MyServerConfigurationProperties properties;
    @Bean
    public ConnectionProvide getConnectrion(){
        ConnectionProvide connectionProvide=new ConnectionProvide();
        connectionProvide.setUrl(properties.getUrl());
        connectionProvide.setPort(properties.getPort());
        return connectionProvide;
     }
}
