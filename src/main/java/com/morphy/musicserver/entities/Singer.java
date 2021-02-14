package com.morphy.musicserver.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Singer {
    // id
    private int id;
    // 姓名
    private String name;
    // 性别
    private int gender;
    // 地址
    private String location;
    // 生日
    private Date birth;
    // 简介
    private String introduction;
    // 头像
    private String pic;

    public Singer(String name, int gender, String location, Date birth, String introduction, String pic) {
        this.name = name;
        this.gender = gender;
        this.location = location;
        this.birth = birth;
        this.introduction = introduction;
        this.pic = pic;
    }


}
