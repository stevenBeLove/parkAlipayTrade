/** 
 * 包名: package com.qt.sales.dao; <br/> 
 * 添加时间: 2016年11月1日 上午11:28:17 <br/> 
 */
package com.qt.sales.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import com.qt.sales.dao.sql.PersonalCommissionSqlProvider;
import com.qt.sales.model.PersonalCommissionVO;

/**
 * 
 * 类名: PersonalCommissionMapper <br/>
 * 作用：TODO(简单一句话描述)<br/>
 * 方法：TODO(简单描述方法)<br/>
 * 创建者: Fuyu. <br/>
 * 添加时间: 2016年11月2日 上午10:50:08 <br/>
 * 版本：
 * 
 * @since JDK 1.6 SalesPlatform 1.0
 */
public interface PersonalCommissionMapper {
    /**
     * 
     * 方法名： PersonalCommissionCount.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午10:49:38.<br/>
     * 参数者异常：@param personalCommissionVO 参数者异常：@return .<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    @SelectProvider(type = PersonalCommissionSqlProvider.class, method = "PersonalCommissionCount")
    @ResultType(Integer.class)
    Integer PersonalCommissionCount(PersonalCommissionVO personalCommissionVO);

    /**
     * 
     * 方法名： PersonalCommissionList.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午10:49:48.<br/>
     * 参数者异常：@param personalCommissionVO 参数者异常：@return .<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    @SelectProvider(type = PersonalCommissionSqlProvider.class, method = "PersonalCommissionList")
    @ResultType(PersonalCommissionVO.class)
    List<PersonalCommissionVO> PersonalCommissionList(PersonalCommissionVO personalCommissionVO);

}
