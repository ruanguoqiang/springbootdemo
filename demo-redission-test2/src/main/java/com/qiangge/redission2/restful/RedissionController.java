package com.qiangge.redission2.restful;

import com.qiangge.Vo.Result;
import com.qiangge.mybatis.model.UserDomain;
import com.qiangge.redission2.feigin.UserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redlock.locker.DistributedLocker;

@RestController
public class RedissionController {

    @Autowired
    private  DistributedLocker redissLock;
    @Autowired
    UserService2 userService;

    @PostMapping(value = "testRedission1")
    public Result testRedission1(@RequestBody  UserDomain userDomain){
        redissLock.lock("abc");
        for (int i=0;i<10;i++){
            userDomain.setUserName(userDomain.getUserName()+"testRedission3"+"---"+i);
            userService.insertUser(userDomain);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("testRedission3插入一条数据是第"+i+"条");
        }
        redissLock.unlock("abc");
        return Result.success();
    }

    @RequestMapping(value = "abc",method = RequestMethod.GET)
    public String testabc(){

        return null;
    }
}

