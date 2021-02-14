package com.morphy.musicserver.service.Impl;

import com.morphy.musicserver.dao.SingerMapper;
import com.morphy.musicserver.entities.Singer;
import com.morphy.musicserver.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * 歌手服务类
 */
@Service
public class SingerServiceImpl implements SingerService {
    @Autowired
    SingerMapper singerMapper;

    /**
     * 新增歌手
     * @param singer
     * @return
     */
    public boolean insertSinger(Singer singer) {
        return singerMapper.insert(singer, 0) > 0;
    }
    /**
     * 更新歌手
     * @param singer
     * @return
     */
    public boolean updateSinger(Singer singer) {
        return singerMapper.update(singer, 0) > 0;
    }
    /**
     * 删除歌手
     * @return
     */
    public boolean deleteSingerById(int id) {
        return singerMapper.updateStatus(id, 1) > 0;
    }
    /**
     * 根据id查找歌手
     * @param id
     * @return
     */
    public Singer getSingerById(int id) {
        return singerMapper.selectSingerById(id, 0);
    }

    /**
     * 根据歌手名模糊查找歌手列表
     * @param name
     * @return
     */
    public Collection<Singer> getSingersByName(String name) {
        return singerMapper.selectSingersByName(name, 0);
    }

    /**
     * 根据性别查询歌手列表
     * @param gender
     * @return
     */
    public Collection<Singer> getSingersByGender(Integer gender) {
        return singerMapper.selectSingersByGender(gender, 0);
    }
    /**
     * 查找所有歌手
     * @param name
     * @return
     */
    public Collection<Singer> getAllSingers() {
        return singerMapper.selectAllSingers(0);
    }
}
