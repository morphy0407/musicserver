package com.morphy.musicserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.morphy.musicserver.service.AdminService;
import com.morphy.musicserver.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    /**
     * 验证是否能够登陆成功
     * code代表登陆状态，0表示用户名或密码错误，1表示登录成功
     * @param request
     * @return
     */
    @RequestMapping(value = "/admin/login/status", method = RequestMethod.POST)
    public Object loginStatus(HttpServletRequest request, HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean flag = adminService.verifyPassword(username, password);
        // 用户名密码正确
        if(flag) {
            jsonObject.put(Consts.CODE, "1");
            jsonObject.put(Consts.MSG, "登录成功");
            session.setAttribute(Consts.USERNAME, username);
            return jsonObject;
        }
        // 用户名密码错误
        jsonObject.put(Consts.CODE, "0");
        jsonObject.put(Consts.MSG, "用户名或密码错误");
        return jsonObject;
    }
}
