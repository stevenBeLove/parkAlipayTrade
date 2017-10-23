/** 
 * 包名: package com.qt.sales.dao; <br/> 
 * 添加时间: 2016年11月2日 上午9:36:51 <br/> 
 */
package com.qt.sales.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import com.qt.sales.dao.sql.InstitutionsFenRunIssueSqlProvider;
import com.qt.sales.model.InstitutionsFenRunIssueVO;
import com.qt.sales.model.PersonalCommissionVO;

/**
 * 
 * <pre>
 * 【类型】: InstitutionsFenRunIssueMapper <br/> 
 * 【作用】: 机构分润Mapper <br/>  
 * 【时间】：2016年11月7日 上午11:30:38 <br/> 
 * 【作者】：fuyu <br/> 
 * </pre>
 */
public interface InstitutionsFenRunIssueMapper {

    /**
     * 
     * 【方法名】 : 查询机构分润List. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:29:11 .<br/>
     * 【参数】： .<br/>
     * 
     * @param institutionsFenRunIssueVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @SelectProvider(type = InstitutionsFenRunIssueSqlProvider.class, method = "InstitutionsFenRunIssueCount")
    @ResultType(Integer.class)
    Integer InstitutionsFenRunIssueCount(InstitutionsFenRunIssueVO institutionsFenRunIssueVO);

    /**
     * 
     * 【方法名】 :机构分润where条件 <br/>
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
    @SelectProvider(type = InstitutionsFenRunIssueSqlProvider.class, method = "InstitutionsFenRunIssueList")
    @ResultType(PersonalCommissionVO.class)
    List<InstitutionsFenRunIssueVO> InstitutionsFenRunIssueList(InstitutionsFenRunIssueVO institutionsFenRunIssueVO);

}
