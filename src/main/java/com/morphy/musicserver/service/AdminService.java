package com.morphy.musicserver.service;

/**
 * 管理员服务接口
 */
public interface AdminService {
    /**
     * 验证密码是否正确
     * @param username 用户名
     * @param password 密码
     * @return
     */
    boolean verifyPassword(String username, String password);

}
