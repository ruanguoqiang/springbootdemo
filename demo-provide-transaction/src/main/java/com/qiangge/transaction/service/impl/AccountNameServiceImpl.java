package com.qiangge.transaction.service.impl;

import com.qiangge.transaction.dao.AccountMapper;
import com.qiangge.transaction.service.AccountNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountNameServiceImpl implements AccountNameService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Boolean changeAccountName() {
        accountMapper.updateName("abc",1);
        int i = 1 / 0;
        return true;
    }
}
