/** 
 * 包名: package com.qt.sales.dao; <br/> 
 * 添加时间: 2016年11月15日 下午3:22:14 <br/> 
 */
package com.qt.sales.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import com.qt.sales.dao.sql.InstitutionsFenRunRecordSqlProvider;
import com.qt.sales.model.InstitutionsFenRunIssueVO;
import com.qt.sales.model.PersonalCommissionVO;

/** 
 * 类名: InstitutionsFenRunRecordMapper <br/> 
 * 作用：TODO(简单一句话描述)<br/> 
 * 方法：TODO(简单描述方法)<br/> 
 * 创建者: thinkpad. <br/> 
 * 添加时间: 2016年11月15日 下午3:22:14 <br/> 
 * 版本： JDK 1.6 SalesPlatform 1.0
 */
public interface InstitutionsFenRunRecordMapper {
    /**
     * 
     * 【方法名】    : 机构返佣记录查询count. <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月15日 下午7:03:36 .<br/>
     * 【参数】： .<br/>
     * @param institutionsFenRunIssueVO 
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    @SelectProvider(type = InstitutionsFenRunRecordSqlProvider.class, method = "InstitutionsFenRunRecordCount")
    @ResultType(Integer.class)
    Integer InstitutionsFenRunRecordCount(InstitutionsFenRunIssueVO institutionsFenRunIssueVO);

    /**
     * 
     * 【方法名】 : 机构返佣记录查询list<br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:29:30 .<br/>
     * 【参数】： .<br/>
     * 
     * @param institutionsFenRunIssueVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @SelectProvider(type = InstitutionsFenRunRecordSqlProvider.class, method = "InstitutionsFenRunRecordList")
    @ResultType(PersonalCommissionVO.class)
    List<InstitutionsFenRunIssueVO> InstitutionsFenRunRecordList(InstitutionsFenRunIssueVO institutionsFenRunIssueVO);

}

