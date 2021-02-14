package com.morphy.musicserver.service;

import com.morphy.musicserver.entities.Singer;

import java.util.Collection;

public interface SingerService {
    /**
     * 新增歌手
     * @param singer
     * @return
     */
    boolean insertSinger(Singer singer);
    /**
     * 更新歌手
     * @param singer
     * @return
     */
    boolean updateSinger(Singer singer);
    /**
     * 删除歌手
     * @return
     */
    boolean deleteSingerById(int id);
    /**
     * 根据id查找歌手
     * @param id
     * @return
     */
    Singer getSingerById(int id);

    /**
     * 根据歌手名模糊查找歌手列表
     * @param name
     * @return
     */
    Collection<Singer> getSingersByName(String name);

    /**
     * 根据性别查询歌手列表
     * @param gender
     * @return
     */
    Collection<Singer> getSingersByGender(Integer gender);
    /**
     * 查找所有歌手
     * @param name
     * @return
     */
    Collection<Singer> getAllSingers();
}
