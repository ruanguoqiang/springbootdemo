package com.qiangge.springfeign.service;

import com.qiangge.exception.ApplicationException;
import com.qiangge.exception.ValidateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;

@Service
public class Abc {

    @Autowired
    Dfg dfg;


    public String geta(String a) throws Exception{
        System.out.println(a);
        try{
            dfg.geta(a);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
        return null;
    }

    public String getc(String c){
        System.out.println(c);
        try{
            int b=1/0;
        }catch (Exception e){
            throw  new ApplicationException("参数错误getc");
        }
        return null;
    }

    public void printInfo() throws Exception {
        InputStream is = null;
        File file=new File("E:"+File.separator+"V4200-V4201.sql");
        is = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(is,
                "utf-8"));
        String s = "";
        ArrayList a =new ArrayList();
        while ((s = br.readLine()) != null) {
            s = s.indexOf(";") == -1 ? s : s.split("\\;")[0];
            a.add(s);
        }
        if (is != null) {
                is.close();

        }
        for (int i=0;i<a.size();i++){
            System.out.println(a.get(i));
        }
    }
}
