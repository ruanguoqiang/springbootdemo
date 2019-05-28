package com.qiangge.aop.login;

import com.qiangge.Vo.Result;
import com.qiangge.aop.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    PermissionService permissionService;

    @PostMapping(value = "/aop/login")
    public Result login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpServletRequest httpServletRequest) {
        HttpSession session=httpServletRequest.getSession();
        if (permissionService.checkLogin(username,password)){
            session.setAttribute("id",123456);
            map.put("islogin",1);
            return  Result.success(map);
        }
        else {
            map.put("islogin",999);
            return  Result.fail(map);
        }
    }
}
