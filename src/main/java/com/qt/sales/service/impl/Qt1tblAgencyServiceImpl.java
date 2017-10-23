/** 
 * 包名: package com.qt.sales.service.impl; <br/> 
 * 添加时间: 2016年10月24日 上午11:19:42 <br/> 
 */
package com.qt.sales.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qt.sales.dao.Qt1tblAgencyMapper;
import com.qt.sales.model.Qt1tblAgency;
import com.qt.sales.model.Qt1tblAgencyExample;
import com.qt.sales.service.Qt1tblAgencyService;

/** 
 * 类名: Qt1tblAgencyService <br/> 
 * 作用：TODO(简单一句话描述)<br/> 
 * 创建者: zhangyinghui. <br/> 
 * 添加时间: 2016年10月24日 上午11:19:42 <br/> 
 * 版本： JDK 1.6 sales 1.0
 */
@Service("qt1tblAgencyService")
public class Qt1tblAgencyServiceImpl implements Qt1tblAgencyService {

    /**
     * Qt1tblAgencyMapper Dao层接口
     */
    @Resource
    private Qt1tblAgencyMapper qt1tblAgencyMapper;
    
    @Override
    public int countByExample(Qt1tblAgencyExample example) {
        return 0;
    }


    @Override
    public int insert(Qt1tblAgency record)throws Exception {
        return qt1tblAgencyMapper.insert(record);
    }

    @Override
    public int insertSelective(Qt1tblAgency record)throws Exception {
        return qt1tblAgencyMapper.insertSelective(record);
    }



    @Override
    public int updateByPrimaryKeySelective(Qt1tblAgency record)throws Exception {
        return qt1tblAgencyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Qt1tblAgency record)throws Exception {
        return qt1tblAgencyMapper.updateByPrimaryKey(record);
    }


    @Override
    public List<Qt1tblAgency> selectByExample(Qt1tblAgencyExample example) throws Exception {
        return qt1tblAgencyMapper.selectByExample(example);
    }


    @Override
    public Qt1tblAgency selectByPrimaryKey(String agencyId) throws Exception {
        return qt1tblAgencyMapper.selectByPrimaryKey(agencyId);
    }

}

