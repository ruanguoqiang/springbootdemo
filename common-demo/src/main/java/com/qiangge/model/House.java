package com.qiangge.model;

import java.io.Serializable;

public class House implements Serializable{

    private String name;

    private String address;

    private String big;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBig() {
        return big;
    }

    public void setBig(String big) {
        this.big = big;
    }

    public House(String name, String address, String big) {
        this.name = name;
        this.address = address;
        this.big = big;
    }

    public House() {
    }
}
