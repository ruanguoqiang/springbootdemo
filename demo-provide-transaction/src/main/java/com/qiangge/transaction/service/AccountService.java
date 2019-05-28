
package com.qiangge.transaction.service;


public interface AccountService {

    /**
     * 事物测试
     * @throws RuntimeException
     * @return void
     */
    void transfer() throws RuntimeException;

    void transfer2() throws RuntimeException;

    public void insertAccount() throws RuntimeException;

}
