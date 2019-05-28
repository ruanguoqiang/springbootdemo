package com.qiangge.aop.service;

public interface PermissionService {

    public Boolean checkIsLogin(Integer id);

    Boolean checkLogin(String username, String password);
}
