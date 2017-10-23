/** 
 * 包名: package com.qt.sales.service; <br/> 
 * 添加时间: 2016年11月15日 下午3:23:55 <br/> 
 */
package com.qt.sales.service;

import java.util.List;

import com.qt.sales.model.InstitutionsFenRunIssueVO;

/**
 * 
 * <pre>
 * 【类型】: InstitutionsFenRunRecordService <br/> 
 * 【作用】:机构返佣分润记录. <br/>  
 * 【时间】：2016年11月15日 下午7:08:46 <br/> 
 * 【作者】：fuyu <br/> 
 * </pre>
 */
public interface InstitutionsFenRunRecordService {
    /**
     * 
     * 【方法名】    : 机构返佣分润记录查询count. <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月15日 下午7:08:06 .<br/>
     * 【参数】： .<br/>
     * @param institutionsFenRunIssueVO 
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    int InstitutionsFenRunRecordCount(InstitutionsFenRunIssueVO institutionsFenRunIssueVO);
    /**
     * 
     * 【方法名】    : 机构返佣分润查询list. <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月15日 下午7:08:25 .<br/>
     * 【参数】： .<br/>
     * @param institutionsFenRunIssueVO 
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    List<InstitutionsFenRunIssueVO> getInstitutionsFenRunRecordList(InstitutionsFenRunIssueVO institutionsFenRunIssueVO);
    /**
     * 
     * 【方法名】    : 导出机构分润记录. <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月16日 上午9:47:13 .<br/>
     * 【参数】： .<br/>
     * @param institutionsFenRunIssueVO 
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    String institutionsFenRunRecordResultToExcel(InstitutionsFenRunIssueVO institutionsFenRunIssueVO);

}

