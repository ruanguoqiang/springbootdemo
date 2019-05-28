package com.qiangge.provide3.testconfigure;

public class ConnectionProvide {

    private String url;

    private Integer port;

    private String name;

    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String helloworld(){
        System.out.println("配置文件使用的方法");
        return null;
    }
}
