
package com.qiangge.transaction.dao;

import com.qiangge.transaction.entity.Account;
import org.apache.ibatis.annotations.Param;


public interface AccountMapper {

    /**
     * 更新
     * @param id
     * @param money
     * @return int
     */
    int update(@Param("money") double money, @Param("id") int id);

    int insert(Account account);

    int updateName(@Param("name") String name, @Param("id") int id);
}
