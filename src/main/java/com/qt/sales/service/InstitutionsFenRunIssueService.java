/** 
 * 包名: package com.qt.sales.service; <br/> 
 * 添加时间: 2016年11月2日 上午9:38:05 <br/> 
 */
package com.qt.sales.service;

import java.util.List;

import com.qt.sales.model.InstitutionsFenRunIssueVO;

/**
 * 
 * <pre>
 * 【类型】: InstitutionsFenRunIssueService <br/> 
 * 【作用】: 机构分润业务逻辑接口 <br/>  
 * 【时间】：2016年11月7日 上午11:31:44 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
public interface InstitutionsFenRunIssueService {

    /**
     * 
     * 【方法名】 : 查询机构返佣分润数量. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:32:46 .<br/>
     * 【参数】： .<br/>
     * 
     * @param institutionsFenRunIssueVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    int InstitutionsFenRunIssueCount(InstitutionsFenRunIssueVO institutionsFenRunIssueVO);

    /**
     * 
     * 【方法名】 : 查询机构分佣分润List. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:38:37 .<br/>
     * 【参数】： .<br/>
     * 
     * @param institutionsFenRunIssueVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    List<InstitutionsFenRunIssueVO> getInstitutionsFenRunIssueList(InstitutionsFenRunIssueVO institutionsFenRunIssueVO);


}
