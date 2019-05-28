package com.qiangge.provide.restful;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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


}
