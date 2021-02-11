package com.morphy.musicserver.service.Impl;

import com.morphy.musicserver.dao.AdminMapper;
import com.morphy.musicserver.service.AdminService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class AdminServiceImpl implements AdminService {

    private AdminMapper adminMapper;

    @Autowired
    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    /**
     * 验证密码是否正确
     * @param username 用户名
     * @param password 密码
     * @return 大于0为true，小于o为false
     */
    @Override
    public boolean verifyPassword(String username, String password) {
        return adminMapper.verifyPassword(username, password) > 0;
    }
}
