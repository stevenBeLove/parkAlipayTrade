/** 
 * 包名: package com.qt.sales.service; <br/> 
 * 添加时间: 2016年10月27日 下午3:12:24 <br/> 
 */
package com.qt.sales.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qt.sales.model.BusinessType;
import com.qt.sales.model.BusinessTypeExample;
import com.qt.sales.model.FansAgencyScale;
import com.qt.sales.model.FansAgencyScaleExample;
import com.qt.sales.web.AjaxReturnInfo;

/** 
 * 类名: FansAgencyScaleService <br/> 
 * 作用：TODO(分销商经营模式)<br/> 
 * 创建者: zhangyinghui. <br/> 
 * 添加时间: 2016年10月27日 下午3:12:24 <br/> 
 * 版本： JDK 1.6 SalesPlatform 1.0
 */
public interface FansAgencyScaleService {
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
    int deleteByExample(FansAgencyScaleExample example)throws Exception;

    /**
     * 根据主键删除
     * @param id 主键
     * @throws Exception 异常
     * @return int
     */
    int deleteByPrimaryKey(String id)throws Exception;

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
    int insertSelective(FansAgencyScale record)throws Exception;

    /**
     * 根据条件搜索
     * @param example List<FansAgencyScale> 对象
     * @throws Exception 异常
     * @return List
     */
    List<FansAgencyScale> selectByExample(FansAgencyScaleExample example)throws Exception;

    /**
     * 根据主键搜索
     * @param id 主键id 
     * @return FansAgencyScale 对象
     * @throws Exception 异常
     */
    FansAgencyScale selectByPrimaryKey(String id)throws Exception;

    /**
     * 更新
     * @param record FansAgencyScale
     * @param example FansAgencyScaleExample
     * @throws Exception 异常
     * @return int
     */
    int updateByExampleSelective(@Param("record") FansAgencyScale record, @Param("example") FansAgencyScaleExample example)throws Exception;

    /**
     * 更新
     * @param record record
     * @param example FansAgencyScaleExample
     * @throws Exception 异常
     * @return int
     */
    int updateByExample(@Param("record") FansAgencyScale record, @Param("example") FansAgencyScaleExample example)throws Exception;

    /**
     * 更新
     * @param record FansAgencyScale
     * @throws Exception 异常
     * @return int
     */
    int updateByPrimaryKeySelective(FansAgencyScale record)throws Exception;

    /**
     * 根据主键更新记录
     * @param record record
     * @throws Exception 异常
     * @return int
     */
    int updateByPrimaryKey(FansAgencyScale record)throws Exception;
    
    /**
     * 
     * 【方法名】    : (根据条件查询列表). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年10月27日 下午5:30:28 .<br/>
     * 【参数】： .<br/>
     * @param example BusinessTypeExample对象
     * @throws Exception 异常
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    List<BusinessType> selectBusinessTypeByExample(BusinessTypeExample example)throws Exception;

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
     * 【方法名】    : (删除分佣比例). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月12日 下午2:56:15 .<br/>
     * 【参数】： .<br/>
     * @param scaleId 分佣比例Id
     * @return AjaxReturnInfo对象
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public AjaxReturnInfo deleteFansAgencyScale(String scaleId) throws Exception;
    
    /**
     * 
     * 【方法名】    : (查询三级分销业务类型集合). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月15日 上午10:28:08 .<br/>
     * 【参数】： .<br/>
     * @return List<BusinessType>
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public List<BusinessType> selectFansBusinessTypeByExample()throws Exception;
    /**
     * 
     * 【方法名】    : (比较上级机构的起始分佣比). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月17日 上午10:53:56 .<br/>
     * 【参数】： .<br/>
     * @param agencyScale FansAgencyScale对象
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public void compareMycost(FansAgencyScale agencyScale) throws Exception;
}

