package com.qt.sales.dao;

import java.util.List;

import com.qt.sales.model.FansAgency;
import com.qt.sales.model.FansAgencyExample;
/**
 * 
 * <pre>
 * 【类型】: FansAgencyMapper <br/> 
 * 【作用】: TODO ADD FUNCTION. <br/>  
 * 【时间】：2016年11月1日 下午7:39:09 <br/> 
 * 【作者】：yinghui zhang <br/> 
 * </pre>
 */
public interface FansAgencyMapper {
    /**
     * 根据条件查询记录数量
     * @param example 实体类
     * @return 数量
     * @throws Exception 异常
      */
    public int countByExample(FansAgencyExample example) throws Exception;

    /**
     * 根据主键删除记录
     * @param agencyId 主键
     * @return 影响记录数
     * @throws Exception 异常
     */
    public int deleteByPrimaryKey(String agencyId) throws Exception;

    /**
     * 插入记录
     * @param record 实体对象
     * @return 影响的记录数
     * @throws Exception 异常
     */
    public int insert(FansAgency record) throws Exception;

    
    /**
     * 根据对象查询
     * @param example 条件对象
     * @return List
     * @throws Exception 异常
     */
    public List<FansAgency> selectByExample(FansAgencyExample example) throws Exception;

    /**
     * 根据主键查询
     * @param agencyId 主键
     * @return 实体
     * @throws Exception 异常
     */
    public FansAgency selectByPrimaryKey(String agencyId) throws Exception;
    
    /**
     *根据主键更新记录 
     * @param record 实体
     * @return 影响记录数
     * @throws Exception 异常
     */
    public int updateByPrimaryKeySelective(FansAgency record) throws Exception;

    /**
     * 
     * 【方法名】    : (更新FansAgency对象). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年10月28日 下午7:03:22 .<br/>
     * 【参数】： .<br/>
     * @param record FansAgency
     * @return int
     * @throws Exception 异常.<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public int updateByPrimaryKey(FansAgency record) throws Exception;
}