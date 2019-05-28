package com.qiangge.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "people",propOrder = {"name","identNo","tall"},namespace = "com.qiangge")
@XmlRootElement
public class People {

    @XmlElement(required = true)
    private String name;

    @XmlElement(required = true)
    private String identNo;

    @XmlElement(required = true)
    private Integer tall;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentNo() {
        return identNo;
    }

    public void setIdentNo(String identNo) {
        this.identNo = identNo;
    }

    public Integer getTall() {
        return tall;
    }

    public void setTall(Integer tall) {
        this.tall = tall;
    }
}
