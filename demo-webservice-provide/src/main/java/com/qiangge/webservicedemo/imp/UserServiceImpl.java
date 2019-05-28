package com.qiangge.webservicedemo.imp;

import com.qiangge.webservicedemo.service.UserService;
import com.qiangge.webservicedemo.model.User;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebService(targetNamespace="http://service.webservicedemo.qiangge.com/",
        endpointInterface = "com.qiangge.webservicedemo.service.UserService")
public class UserServiceImpl implements UserService {

    private Map<String, User> userMap = new HashMap<String, User>();

    @Override
    public String getName(String userId) {
        return "liyd-" + userId;
    }
    @Override
    public User getUser(String userId) {
        User user= userMap.get(userId);
        return user;
    }

    @Override
    public ArrayList<User> getAlLUser() {
        ArrayList<User> users=new ArrayList<>();
        userMap.forEach((key,value)->{users.add(value);});
        return users;
    }

    public UserServiceImpl() {
        System.out.println("向实体类插入数据");
        User user = new User();
        user.setUserId("411001");
        user.setUsername("zhansan");
        user.setAge("20");
        userMap.put(user.getUserId(), user);

        user = new User();
        user.setUserId("411002");
        user.setUsername("lisi");
        user.setAge("30");
        userMap.put(user.getUserId(), user);

        user = new User();
        user.setUserId("411003");
        user.setUsername("wangwu");
        user.setAge("40");
        userMap.put(user.getUserId(), user);
    }
}
