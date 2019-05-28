package com.qiangge.model;

import java.io.Serializable;

public class Student implements Serializable {

    private Integer Sno;

    private String Sname;

    public Integer getSno() {
        return Sno;
    }

    public void setSno(Integer sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public Student(Integer sno, String sname) {
        Sno = sno;
        Sname = sname;
    }

    public Student() {
    }

}
