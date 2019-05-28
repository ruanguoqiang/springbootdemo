package com.qiangge.aop.service.imp;

import com.qiangge.aop.service.PermissionService;
import org.springframework.stereotype.Component;

@Component
public class PermissionServiceImp implements PermissionService {
    @Override
    public Boolean checkIsLogin(Integer id) {

        return id==null ? false:true;
    }

    @Override
    public Boolean checkLogin(String username, String password) {
        if (username!=null&&password.equals("abc")){
            return  true;
        }
        return false;
    }
}
