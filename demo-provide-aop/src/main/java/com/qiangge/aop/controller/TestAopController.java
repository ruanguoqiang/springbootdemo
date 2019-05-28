package com.qiangge.aop.controller;


import com.qiangge.Vo.Result;
import com.qiangge.anonation.service.AnnotionService;
import com.qiangge.anonation.validator.Validator;
import com.qiangge.anonation.validator.annotation.ValidateParam;
import com.qiangge.aop.annotation.HttpCall;
import com.qiangge.exception.ValidateException;
import com.qiangge.mybatis.model.UserDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestAopController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AnnotionService annotionService;

    @PostMapping(value = "/tesaop")
    public Result getUserDomian(@RequestBody UserDomain userDomain){
        logger.info("哪个早一点");
        userDomain.setUserName("登陆之后才能改变值");
        return Result.success(userDomain);
    }


    @HttpCall
    @PutMapping("put/")
    public Object updateStuByMan(UserDomain userDomain) {
        userDomain.setUserName("开启admin注解会走aop");
        return Result.success(userDomain);

    }
    @GetMapping(value = "/annotionTest")
    public Result annotionTest(@ValidateParam({ Validator.NOT_BLANK }) String name,@ValidateParam({ Validator.INT }) Integer age){
      /*  if(name==null){
            throw new ValidateException(ValidateException.MESSAGE);
        }*/
        return annotionService.getName(name,age);
    }
}
