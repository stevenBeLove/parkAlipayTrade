package com.qt.sales.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.qt.sales.model.FansAgencyScale;
import com.qt.sales.model.FansAgencyScaleExample;

/**
 * 
 * <pre>
 * 【类型】: 分销商经营模式Dao <br/> 
 * 【作用】: TODO ADD FUNCTION. <br/>  
 * 【时间】：2016年10月27日 下午3:13:48 <br/> 
 * 【作者】：yinghui zhang <br/> 
 * </pre>
 */
public interface FansAgencyScaleMapper {

    /**
    * 符合条件数量
     * @param example 对象
     * @return int
     * @throws Exception 异常
     */
    int countByExample(FansAgencyScaleExample example)throws Exception;

    /**
     * 根据条件删除
     * @param example 对象
     * @throws Exception 异常
     * @return int
     */
    int deleteByExample(FansAgencyScaleExample example)throws Exception;;

    /**
     * 根据主键删除
     * @param id 主键
     * @throws Exception 异常
     * @return int
     */
    int deleteByPrimaryKey(String id)throws Exception;;

    /**
     * 添加
     * @param record 对象
     * @return int
     * @throws Exception 异常
     */
    int insert(FansAgencyScale record)throws Exception;

    /**
     * 添加记录
     * @param record 对象
     * @throws Exception 异常
     * @return 产生影响的行数
     */
    int insertSelective(FansAgencyScale record)throws Exception;;

    /**
     * 根据条件搜索
     * @param example 对象
     * @throws Exception 异常
     * @return List
     */
    List<FansAgencyScale> selectByExample(FansAgencyScaleExample example)throws Exception;;

    /**
     * 根据主键搜索
     * @param id 主键id 
     * @throws Exception 异常
     * @return 对象
     */
    FansAgencyScale selectByPrimaryKey(String id)throws Exception;;

    /**
     * 更新
     * @param record FansAgencyScale
     * @param example FansAgencyScaleExample
     * @return int
     */
    int updateByExampleSelective(@Param("record") FansAgencyScale record, @Param("example") FansAgencyScaleExample example);

    /**
     * 更新
     * @param record record
     * @param example FansAgencyScaleExample
     * @return int
     */
    int updateByExample(@Param("record") FansAgencyScale record, @Param("example") FansAgencyScaleExample example);

    /**
     * 更新
     * @param record FansAgencyScale
     * @return int
     */
    int updateByPrimaryKeySelective(FansAgencyScale record);

    /**
     * 根据主键更新记录
     * @param record record
     * @throws Exception 异常
     * @return int
     */
    int updateByPrimaryKey(FansAgencyScale record)throws Exception;
    
    /**
     * 
     * 【方法名】    : (查询符合条件的配置参数中，最大开始日期的记录). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月4日 下午5:24:04 .<br/>
     * 【参数】： .<br/>
     * @param record FansAgencyScale对象
     * @return FansAgencyScale对象
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    FansAgencyScale selectMaxBegindateScale(FansAgencyScale record)throws Exception;
    /**
     * 
     * 【方法名】    : (设置结束日期为空). <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月7日 上午11:02:28 .<br/>
     * 【参数】： .<br/>
     * @param record FansAgencyScale对象
     * @return 受影响的行数
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    int updateEndTimesetNull(FansAgencyScale record)throws  Exception;
    
    /**
     * 
     * 【方法名】    : (这里用一句话描述这个方法的作用). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月11日 下午12:00:22 .<br/>
     * 【参数】： .<br/>
     * @param agencyId 分销商Id
     * @return int 分佣参数数量
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    int queryScaleCountWithAgencyId(String agencyId)throws  Exception;
    
    /**
     * 
     * 【方法名】    : (查询结束日期最大的记录). <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月12日 下午2:49:06 .<br/>
     * 【参数】： .<br/>
     * @param record FansAgencyScale对象
     * @return FansAgencyScale
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    FansAgencyScale selectMaxEndDateScale(FansAgencyScale record)throws Exception;
    
    /**
     * 
     * 【方法名】    : (根据机构Id分组查询配置表里参数类型数量). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月15日 上午10:15:42 .<br/>
     * 【参数】： .<br/>
     * @param agencyId 机构Id
     * @return 参数类型总数
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    int selectBussinessTypeCountByAgencyId(String agencyId)throws Exception;
    
    /**
     * 
     * 【方法名】    : (查询父级分佣参数比). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月17日 上午10:28:19 .<br/>
     * 【参数】： .<br/>
     * @param map  Map<String, Object>
     * @return FansAgencyScale对象
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    FansAgencyScale selectParentScale(Map<String, Object> map)throws Exception;
    
}