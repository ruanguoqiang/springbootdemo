package com.qiangge.springfeign.service;

import com.qiangge.exception.ApplicationException;
import org.springframework.stereotype.Service;

@Service
public class Dfg {

    public String geta(String a){
        System.out.println(a);
        try{
            int b=1/0;
        }catch (Exception e){
            throw  new ApplicationException("参数错误geta");
        }
        return null;
    }
}
