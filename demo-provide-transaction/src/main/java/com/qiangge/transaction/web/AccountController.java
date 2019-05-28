
package com.qiangge.transaction.web;

import com.qiangge.Vo.Result;
import com.qiangge.transaction.service.AccountService;
import com.qiangge.transaction.service.impl.AccountNameServiceImpl;
import com.qiangge.transaction.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountNameServiceImpl accountNameService;

    @RequestMapping(value = "transfer", method = RequestMethod.GET)
    public Result transfer(){
        accountService.transfer2();
        accountService.insertAccount();
       // accountNameService.changeAccountName();
        return Result.success("成功");
    }

    @RequestMapping(value = "Aoptest", method = RequestMethod.GET)
    public Result aoptest(){
        accountService.transfer();
        //accountService.insertAccount();
        return Result.success("aop成功");
    }
}
