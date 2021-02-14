package com.morphy.musicserver.dao;

import com.morphy.musicserver.entities.Singer;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface SingerMapper {
    /**
     * 增加歌手
     * @param singer
     * @return
     */
    int insert(Singer singer, int status);

    /**
     * 更新歌手
     */
    int update(Singer singer, int status);

    /**
     * 删除歌手, status = 0 歌手为删除状态
     */
    int updateStatus(int id, int status);

    /**
     * 根据id查找歌手
     */
    Singer selectSingerById(int id, int status);

    /**
     * 查询所有歌手
     */
    Collection<Singer> selectAllSingers(int status);
    /**
     * 根据歌手名模糊查询列表
     */
    Collection<Singer> selectSingersByName(String name, int status);

    /**
     * 根据性别查询歌手列表
     * @param gender
     * @param status
     * @return
     */
    Collection<Singer> selectSingersByGender(int gender, int status);
}
