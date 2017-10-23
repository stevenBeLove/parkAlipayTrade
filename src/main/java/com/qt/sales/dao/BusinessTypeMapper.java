package com.qt.sales.dao;

import java.util.List;

import com.qt.sales.model.BusinessType;
import com.qt.sales.model.BusinessTypeExample;

/**
 * 
 * <pre>
 * 【类型】: BusinessTypeMapperDao层 <br/> 
 * 【作用】: 查询业务类型. <br/>  
 * 【时间】：2016年10月27日 下午5:30:14 <br/> 
 * 【作者】：yinghui zhang <br/> 
 * </pre>
 */
public interface BusinessTypeMapper {

    /**
     * 
     * 【方法名】    : (根据条件查询列表). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年10月27日 下午5:30:28 .<br/>
     * 【参数】： .<br/>
     * @param example BusinessTypeExample对象
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    List<BusinessType> selectByExample(BusinessTypeExample example);
}