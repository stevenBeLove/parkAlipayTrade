/** 
 * 包名: package com.qt.sales.service.impl; <br/> 
 * 添加时间: 2016年10月27日 下午4:21:25 <br/> 
 */
package com.qt.sales.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qt.sales.dao.AnnouncementMapper;
import com.qt.sales.model.Announcement;
import com.qt.sales.model.AnnouncementExample;
import com.qt.sales.service.AnnouncementService;

/**
 * 
 * <pre>
 * 【类型】: AnnouncementServiceImpl <br/> 
 * 【作用】: 系统公告发送业务逻辑实现层 <br/>  
 * 【时间】：2016年11月7日 上午9:55:26 <br/> 
 * 【作者】：fuyu <br/> 
 * </pre>
 */
@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    /**
     * Dao层接口
     */
    @Resource
    private AnnouncementMapper announcementMapper;

    @Override
    public List<Announcement> selectByExample(AnnouncementExample example) throws Exception {
        return announcementMapper.selectByExample(example);
    }

    @Override
    public int countByExample(AnnouncementExample example) throws Exception {
        return announcementMapper.countByExample(example);
    }

    @Override
    public Announcement selectByPrimaryKey(String id) throws Exception {
        return announcementMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Announcement record) throws Exception {
        return announcementMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(String id) throws Exception {
        return announcementMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Announcement record) throws Exception {
        return announcementMapper.updateByPrimaryKeySelective(record);
    }


}
