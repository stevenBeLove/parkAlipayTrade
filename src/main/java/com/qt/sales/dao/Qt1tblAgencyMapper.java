package com.qt.sales.dao;

import com.qt.sales.model.Qt1tblAgency;
import com.qt.sales.model.Qt1tblAgencyExample;
import com.qt.sales.model.Qt1tblAgencyKey;

import java.util.List;

import org.apache.ibatis.annotations.Param;
/**
 * 
 * <pre>
 * 【类型】: Qt1tblAgencyMapper <br/> 
 * 【作用】: TODO ADD FUNCTION. <br/>  
 * 【时间】：2016年11月1日 下午7:23:57 <br/> 
 * 【作者】：yinghui zhang <br/> 
 * </pre>
 */
public interface Qt1tblAgencyMapper {
    /**
     * 
     * 【方法名】    : (查询符合条件的数量). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月1日 下午7:24:07 .<br/>
     * 【参数】： .<br/>
     * @param example Qt1tblAgencyExample
     * @return int.<br/>
     * @throws Exception 
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    int countByExample(Qt1tblAgencyExample example)throws Exception;

    /**
     * 
     * 【方法名】    : (添加记录). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月1日 下午7:25:50 .<br/>
     * 【参数】： .<br/>
     * @param record Qt1tblAgency
     * @return int.<br/>
     * @throws Exception
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    int insert(Qt1tblAgency record)throws Exception;

    /**
     * 
     * 【方法名】    : (根据条件不为空的新增). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月1日 下午7:26:47 .<br/>
     * 【参数】： .<br/>
     * @param record Qt1tblAgency
     * @return .<br/>
     * @throws Exception
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    int insertSelective(Qt1tblAgency record)throws Exception;

    /**
     * 
     * 【方法名】    : (根据条件对象查询). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月1日 下午7:27:52 .<br/>
     * 【参数】： .<br/>
     * @param example Qt1tblAgencyExample
     * @return  List<Qt1tblAgency>.<br/>
     * @throws Exception
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    List<Qt1tblAgency> selectByExample(Qt1tblAgencyExample example)throws Exception;

    /**
     * 
     * 【方法名】    : (根据主键查询对象). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月1日 下午7:28:47 .<br/>
     * 【参数】： .<br/>
     * @param agencyId String
     * @return Qt1tblAgency.<br/>
     * @throws Exception
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    Qt1tblAgency selectByPrimaryKey(String agencyId)throws Exception;

    /**
     * 
     * 【方法名】    : (根据主键更新不为空的字段). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月1日 下午7:30:01 .<br/>
     * 【参数】： .<br/>
     * @param record Qt1tblAgency
     * @return int.<br/>
     * @throws Exception
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    int updateByPrimaryKeySelective(Qt1tblAgency record)throws Exception;

    /**
     * 
     * 【方法名】    : (这里用一句话描述这个方法的作用). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月1日 下午7:31:26 .<br/>
     * 【参数】： .<br/>
     * @param record Qt1tblAgency
     * @return int
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    int updateByPrimaryKey(Qt1tblAgency record)throws Exception;

}