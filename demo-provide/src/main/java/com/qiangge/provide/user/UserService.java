package com.qiangge.provide.user;

import com.github.pagehelper.PageInfo;
import com.qiangge.mybatis.model.UserDomain;


/**
 * Created by Administrator on 2018/4/19.
 */
public interface UserService {

    int addUser(UserDomain user);

    PageInfo<UserDomain> findAllUser(int pageNum, int pageSize);
}
