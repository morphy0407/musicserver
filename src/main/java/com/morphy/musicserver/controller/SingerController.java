package com.morphy.musicserver.controller;


import com.alibaba.fastjson.JSONObject;
import com.morphy.musicserver.entities.Singer;
import com.morphy.musicserver.service.SingerService;
import com.morphy.musicserver.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@RestController
public class SingerController {
    @Autowired
    SingerService singerService;

    /**
     * 添加歌手
     * @return
     */
    @RequestMapping(value = "/singers", method = RequestMethod.POST)
    public Object addSinger(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();

        String name = request.getParameter("name").trim();
        int gender = Integer.parseInt(request.getParameter("gender").trim());
        String pic = request.getParameter("pic").trim();
        String birth = request.getParameter("birth").trim();
        String location = request.getParameter("location").trim();
        String introduction = request.getParameter("introduction").trim();
        // 把生日转换成yy-MM-dd格式
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = new Date();
        try {
            birthDate = dateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Singer singer = new Singer();
        singer.setName(name);
        singer.setGender(gender);
        singer.setBirth(birthDate);
        singer.setLocation(location);
        singer.setPic(pic);
        singer.setIntroduction(introduction);
        boolean flag = singerService.insertSinger(singer);

        if(flag) {
            jsonObject.put(Consts.CODE, "1");
            jsonObject.put(Consts.MSG, "添加成功");
            return jsonObject;
        } else {
            jsonObject.put(Consts.CODE, "0");
            jsonObject.put(Consts.MSG, "添加失败");
            return jsonObject;
        }

    }

    /**
     * 更新歌手信息
     * @return
     */
    @RequestMapping(value = "/singers", method = RequestMethod.PUT)
    public JSONObject updateSinger(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        int id = Integer.parseInt(request.getParameter("id").trim());
        String name = request.getParameter("name").trim();
        int gender = Integer.parseInt(request.getParameter("gender").trim());
        String pic = request.getParameter("pic").trim();
        String birth = request.getParameter("birth").trim();
        String location = request.getParameter("location").trim();
        String introduction = request.getParameter("introduction").trim();
        // 把生日转换成yy-MM-dd格式
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = new Date();
        try {
            birthDate = dateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Singer singer = new Singer();
        singer.setId(id);
        singer.setName(name);
        singer.setGender(gender);
        singer.setBirth(birthDate);
        singer.setLocation(location);
        singer.setPic(pic);
        singer.setIntroduction(introduction);
        boolean flag = singerService.updateSinger(singer);

        if(flag) {
            jsonObject.put(Consts.CODE, "1");
            jsonObject.put(Consts.MSG, "修改成功");
            return jsonObject;
        } else {
            jsonObject.put(Consts.CODE, "0");
            jsonObject.put(Consts.MSG, "修改失败");
            return jsonObject;
        }
    }

    /**
     * 删除歌手
     * @return
     */
    @RequestMapping(value = "/singers/{id}", method = RequestMethod.DELETE)
    public JSONObject deleteSinger(@PathVariable("id") int id) {
        JSONObject jsonObject = new JSONObject();
        boolean flag = singerService.deleteSingerById(id);

        if(flag) {
            jsonObject.put(Consts.CODE, "1");
            jsonObject.put(Consts.MSG, "删除成功");
            return jsonObject;
        } else {
            jsonObject.put(Consts.CODE, "0");
            jsonObject.put(Consts.MSG, "删除失败");
            return jsonObject;
        }
    }

    /**
     * 根据id获取singer
     * @return
     */
    @RequestMapping(value = "/singers/{id}", method = RequestMethod.GET)
    public Object getSingerNyId(@PathVariable("id") int id) {
        return singerService.getSingerById(id);
    }

    /**
     * 获取所有歌手
     * @return
     */
    @RequestMapping(value = "/singers/query/all", method = RequestMethod.GET)
    public Collection<Singer> getSingerNyId() {
        return singerService.getAllSingers();
    }

    /**
     * 根据歌手名查询歌手列表
     * @param name
     * @return
     */
    @RequestMapping(value = "/singers/query/name", method = RequestMethod.GET)
    public Collection<Singer> getSingersByname(@RequestParam("name") String name) {
        return singerService.getSingersByName(name);
    }

    /**
     * 根据性别查询歌手列表
     * @param gender
     * @return
     */
    @RequestMapping(value = "/singers/query/gender", method = RequestMethod.GET)
    public Collection<Singer> getSingersByGender(@RequestParam("gender") int gender) {
        return singerService.getSingersByGender(gender);
    }



}
