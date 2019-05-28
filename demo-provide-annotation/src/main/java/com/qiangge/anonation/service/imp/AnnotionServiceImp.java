package com.qiangge.anonation.service.imp;

import com.qiangge.Vo.Result;
import com.qiangge.anonation.service.AnnotionService;
import com.qiangge.anonation.validator.Validator;
import com.qiangge.anonation.validator.annotation.ValidateParam;
import com.qiangge.exception.MyException;
import org.springframework.stereotype.Component;

@Component
public class AnnotionServiceImp implements AnnotionService {

    @Override
    public Result getName(@ValidateParam({ Validator.NOT_BLANK })  String name,
                          @ValidateParam({ Validator.INT }) Integer age) {
        String aaa=name+age;
        if (age>100){
            throw new MyException("年龄太大了");
        }
        return Result.success(null) ;
    }
}
