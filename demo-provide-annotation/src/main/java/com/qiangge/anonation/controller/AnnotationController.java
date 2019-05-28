package com.qiangge.anonation.controller;

import com.qiangge.Vo.Result;
import com.qiangge.anonation.service.AnnotionService;
import com.qiangge.anonation.validator.Validator;
import com.qiangge.anonation.validator.annotation.ValidateParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnnotationController {

    @Autowired
    AnnotionService annotionService;

    @GetMapping(value = "/annotion")
    public Result annotionTest(@ValidateParam({ Validator.NOT_BLANK }) String name, @RequestParam Integer age){
        annotionService.getName(name,age);
        return Result.success("abc");
    }
}
