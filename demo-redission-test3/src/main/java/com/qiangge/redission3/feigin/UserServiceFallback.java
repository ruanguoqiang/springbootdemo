package com.qiangge.redission3.feigin;

import com.qiangge.mybatis.model.UserDomain;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFallback implements UserService2 {

    @Override
    public int insertUser(UserDomain userDomain) {
        return 000;
    }
}
