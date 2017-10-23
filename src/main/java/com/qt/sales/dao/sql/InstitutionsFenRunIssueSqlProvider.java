/** 
 * 包名: package com.qt.sales.dao.sql; <br/> 
 * 添加时间: 2016年11月2日 上午9:36:25 <br/> 
 */
package com.qt.sales.dao.sql;

import org.springframework.util.StringUtils;

import com.qt.sales.model.InstitutionsFenRunIssueVO;

/**
 * 
 * <pre>
 * 【类型】: InstitutionsFenRunIssueSqlProvider <br/> 
 * 【作用】: 机构分润Sql映射类 <br/>  
 * 【时间】：2016年11月7日 上午11:28:32 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
public class InstitutionsFenRunIssueSqlProvider {

    /**
     * 
     * 【方法名】 : 查询机构分润数量 <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:28:54 .<br/>
     * 【参数】： .<br/>
     * 
     * @param institutionsFenRunIssueVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    public static String InstitutionsFenRunIssueCount(InstitutionsFenRunIssueVO institutionsFenRunIssueVO) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append(" select count(1) ");
        sb.append(" from ( ");
        sb.append(" select SUPER_AGENCY_ID,sum(MY_PROFIT) month_amount," + "substr(localdate, 1, 6) months " + "from qtfans.tb_fans_AGENCY_jnls "
                + "group by SUPER_AGENCY_ID, substr(localdate, 1, 6)) tt1 " + "left join TB_FANS_AGENCY y on y.agency_id = tt1.SUPER_AGENCY_ID ");
        sb.append(InstitutionsFenRunIssueWhere(institutionsFenRunIssueVO));
        sb.insert(0, "select * from ( select row_.*, rownum rn from ( ");
        sb.append(" ) row_ where rownum <=10 ) ");
        sb.append(" where rn  >0 ");
        return sb.toString();

    }

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
    public static String InstitutionsFenRunIssueList(InstitutionsFenRunIssueVO institutionsFenRunIssueVO) {
        StringBuffer sb = null; 
        
        sb = new StringBuffer();
        sb.append("select " + "substr(tt1.months , 1, 4) || '年' || substr(tt1.months, 5, 2) || '月' as localDate," + "tt1.SUPER_AGENCY_ID as agencyId, " + "tt1.month_amount as monthProfit," + "y.agency_name as agencyName");
        sb.append(" from ( ");
        sb.append(" select SUPER_AGENCY_ID,sum(MY_PROFIT) month_amount," + "substr(localdate, 1, 6) months " + "from qtfans.tb_fans_AGENCY_jnls "
                + "group by SUPER_AGENCY_ID, substr(localdate, 1, 6)) tt1 " + "left join TB_FANS_AGENCY y on y.agency_id = tt1.SUPER_AGENCY_ID ");
        sb.append(InstitutionsFenRunIssueWhere(institutionsFenRunIssueVO));
        sb.insert(0, "select * from ( select row_.*, rownum rn from ( ");
        sb.append(" ) row_ where rownum <=#{end:INTEGER} ) ");
        sb.append(" where rn  >#{start:INTEGER} ");
        return sb.toString();

    }

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
    private static String InstitutionsFenRunIssueWhere(InstitutionsFenRunIssueVO institutionsFenRunIssueVO) {
        StringBuffer sb = new StringBuffer(" WHERE 1 = 1");
        if (!StringUtils.isEmpty(institutionsFenRunIssueVO.getAgencyId())) {
            sb.append(" and tt1.SUPER_AGENCY_ID=#{agencyId,javaType=string,jdbcType=VARCHAR} ");
        }
        if (!StringUtils.isEmpty(institutionsFenRunIssueVO.getLocalDate())) {
            sb.append(" and tt1.months like '%" + institutionsFenRunIssueVO.getLocalDate().substring(1, 6) + "%'");
        }
        return sb.toString();
    }

}
