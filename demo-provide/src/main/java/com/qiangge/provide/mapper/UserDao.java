package com.qiangge.provide.mapper;


import com.qiangge.mybatis.model.UserDomain;

import java.util.List;

public interface UserDao {


    int insert(UserDomain record);



    List<UserDomain> selectUsers();
}