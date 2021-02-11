package com.morphy.musicserver.dao;

import org.springframework.stereotype.Repository;

/**
 * 管理原dao类
 */
@Repository
public interface AdminMapper {
    /**
     * 查询数据库中是否存在一致的用户名和密码
     * @param username
     * @param password
     * @return
     */
    int verifyPassword(String username, String password);

}
