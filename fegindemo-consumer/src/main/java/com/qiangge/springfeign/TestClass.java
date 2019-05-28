package com.qiangge.springfeign;

import com.qiangge.exception.ApplicationException;
import com.qiangge.springfeign.service.Abc;
import com.qiangge.springfeign.service.HelloService;

public class TestClass {
    public static void main(String args[]) throws Exception{
       Abc abc=new Abc();
       try {
           abc.printInfo();
         //  abc.geta("a");
          // abc.getc("c");
       }/*catch (ApplicationException e){
           throw new Exception(e.getMessage());
       }*/
       catch (Exception e){
           //e.printStackTrace();
           throw new Exception(e.getMessage());
       }
    }
}
