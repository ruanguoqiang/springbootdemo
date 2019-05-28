package com.qiangge.aop.exception;

import com.qiangge.Vo.Result;
import com.qiangge.exception.MyException;
import com.qiangge.exception.ValidateException;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.logging.Logger;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());


    @ExceptionHandler(value = {RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handle(RuntimeException ex) {
        logger.error("runtime exception:{}", ex.getMessage());
        return Result.fail();
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handle(Exception ex) {
        logger.error("exception:{}", ex.getMessage());
        return Result.fail();
    }

    @ExceptionHandler(value = {ValidateException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handle(ValidateException ex) {
        logger.error("exception:{}", ex.getMessage());
        return new Result( String.valueOf(ex.getCode()),ex.getMessage(),null);
    }

    @ExceptionHandler(value = {MyException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handle(MyException ex) {
        logger.error("exception:{}", ex.getMessage());
        return new Result( String.valueOf(ex.getCode()),ex.getMessage(),null);
    }

   /* @ExceptionHandler(value = {Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handle(Throwable throwable) {
        Result result = Result.fail();
        if (throwable instanceof ResponseStatusException) {
            result = handle((ResponseStatusException) throwable);
        }
        else if (throwable instanceof ValidateException) {
            result = handle((RuntimeException) throwable);
        }
         else if (throwable instanceof RuntimeException) {
            result = handle((RuntimeException) throwable);
        } else if (throwable instanceof Exception) {
            result = handle((Exception) throwable);
        }
        return result;
    }*/
}
