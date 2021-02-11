package com.morphy.musicserver.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor // 全参数构造器
@NoArgsConstructor  // 无参构造器
public class Admin {
    /**
     * 管理员id
     */
    private int id;
    /**
     * 管理员用户名
     */
    private String username;
    /**
     * 管理员密码
     */
    private String password;

}
