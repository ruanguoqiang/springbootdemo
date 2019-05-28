package com.qiangge.provide.restful;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/hello")
@Controller
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, value = "/index")
    @ResponseBody
    public String world(@RequestParam String name) {
        return name + "9001success";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ceshi")
    @ResponseBody
    public String say() {
        return  "hello";
    }
    @GetMapping(value = "/abc")
    @ResponseBody
    public String say2(HttpServletRequest httpServletRequest) {
        HttpSession session=httpServletRequest.getSession();
        SecurityProperties.User user= (SecurityProperties.User) session.getAttribute("user");
        Map<String,SecurityProperties.User> abc=new HashMap();
        abc.remove("abc");
        return  "hello";
    }


}
