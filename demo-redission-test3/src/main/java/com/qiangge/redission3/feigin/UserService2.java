package com.qiangge.redission3.feigin;

import com.qiangge.mybatis.model.UserDomain;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "demo-provide",fallback = UserServiceFallback.class )
public interface UserService2 {

    @RequestMapping(value = "/user/add",method = RequestMethod.POST)
    public int insertUser(@RequestBody UserDomain userDomain);

}
