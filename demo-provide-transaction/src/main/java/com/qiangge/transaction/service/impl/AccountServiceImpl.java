
package com.qiangge.transaction.service.impl;


import com.qiangge.transaction.dao.AccountMapper;
import com.qiangge.transaction.entity.Account;
import com.qiangge.transaction.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountNameServiceImpl accountNameService;

    /**
     * 事物测试
     * @throws RuntimeException
     * @return void
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void transfer() throws RuntimeException{
        // 用户1减10块 用户2加10块
        accountMapper.update(90,1);
        // 模拟异常测试事务回滚
        int i = 1 / 0;
        accountMapper.update(110,2);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void transfer2() throws RuntimeException{
        accountMapper.update(313.12,1);
       // accountNameService.changeAccountName();

    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void insertAccount() throws RuntimeException{
        Account account=new Account();
        account.setId(2);
        account.setMoney(2121.21);
        account.setName("dwasda");
        accountMapper.insert(account);
        int i = 1 / 0;
    }
}
