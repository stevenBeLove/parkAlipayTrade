/** 
 * 包名: package com.qt.sales.dao.sql; <br/> 
 * 添加时间: 2016年11月15日 下午3:21:50 <br/> 
 */
package com.qt.sales.dao.sql;

import org.springframework.util.StringUtils;

import com.qt.sales.model.InstitutionsFenRunIssueVO;

/** 
 * 类名: InstitutionsFenRunRecordSqlProvider <br/> 
 * 方法：TODO(简单描述方法)<br/> 
 * 创建者: thinkpad. <br/> 
 * 添加时间: 2016年11月15日 下午3:21:50 <br/> 
 * 版本： JDK 1.6 SalesPlatform 1.0
 */
public class InstitutionsFenRunRecordSqlProvider {
    /**
     * 
     * 【方法名】    :机构返佣分润记录查询Count. <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月15日 下午6:54:14 .<br/>
     * 【参数】： .<br/>
     * @param institutionsFenRunIssueVO 
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    public static String InstitutionsFenRunRecordCount(InstitutionsFenRunIssueVO institutionsFenRunIssueVO) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append(" select count(1) ");
        sb.append(" from qtfans.tb_fans_AGENCY_jnls tt1 ");
        sb.append(" left join TB_FANS_AGENCY y on y.agency_id = tt1.SUPER_AGENCY_ID ");
        sb.append(" left join TB_FANS_AGENCY y1 on tt1.agency_id=y1.agency_id ");
        sb.append(" left join TB_PRD_BUSINESS_TYPE e on e.business_type = tt1.business_type ");
        sb.append(" left join tb_fans_customer_jnls s on s.LOCALLOGNO = tt1.LOCALLOGNO and s.localdate=tt1.localdate and s.LOCALTIME=tt1.LOCALTIME ");
        sb.append(" left join paycustomer r on r.customerid = s.customerid ");
        sb.append(" left join payuser u on u.customerid = r.customerid");
        sb.append(InstitutionsFenRunRecordWhere(institutionsFenRunIssueVO));
        sb.insert(0, "select * from ( select row_.*, rownum rn from ( ");
        sb.append(" ) row_ where rownum <=10 ) ");
        sb.append(" where rn  >0 ");
        return sb.toString();

    }
    
    /**
     * 
     * 【方法名】    : 查询机构返佣分润List. <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月15日 下午6:54:44 .<br/>
     * 【参数】： .<br/>
     * @param institutionsFenRunIssueVO 
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    public static String InstitutionsFenRunRecordList(InstitutionsFenRunIssueVO institutionsFenRunIssueVO) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append(" select tt1.localLogno  as localLogno, "
                + " tt1.localDate, tt1.localtime,  "
                + " tt1.AGENCY_ID  as agencyId,      "
                + " y1.agency_name      as agencyName,     "
                + " tt1.SUPER_AGENCY_ID as superAgencyId,  "
                + " y.agency_name       as superAgencyName, "
                + " tt1.BUSINESS_TYPE   as businessType,    "
                + " e.BUSINESS_NAME     as businessName,   "
                + " s.customerid, "
                + " r.customername,                      "
                + " u.userid            as mobile,      "
                + " s.amount,                           "
                + " nvl(tt1.differ_rate,tt1.rate-s.parent_rate-s.two_rate-s.top_rate)   as rate,       "
                + " tt1.MY_PROFIT    as monthProfit   ");
        sb.append(" from qtfans.tb_fans_AGENCY_jnls tt1 ");
        sb.append(" left join TB_FANS_AGENCY y on y.agency_id = tt1.SUPER_AGENCY_ID ");
        sb.append(" left join TB_FANS_AGENCY y1 on tt1.agency_id=y1.agency_id ");
        sb.append(" left join TB_PRD_BUSINESS_TYPE e on e.business_type = tt1.business_type ");
        sb.append(" left join tb_fans_customer_jnls s on s.LOCALLOGNO = tt1.LOCALLOGNO and s.localdate=tt1.localdate and s.LOCALTIME=tt1.LOCALTIME ");
        sb.append(" left join paycustomer r on r.customerid = s.customerid ");
        sb.append(" left join payuser u on u.customerid = r.customerid");
        sb.append(InstitutionsFenRunRecordWhere(institutionsFenRunIssueVO));
        sb.insert(0, "select * from ( select row_.*, rownum rn from ( ");
        sb.append(" ) row_ where rownum <=#{end:INTEGER} ) ");
        sb.append(" where rn  >#{start:INTEGER} ");
        return sb.toString();

    }

    /**
     * 
     * 【方法名】    : 机构返佣分润查询List. <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月15日 下午7:02:28 .<br/>
     * 【参数】： .<br/>
     * @param institutionsFenRunIssueVO 
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    private static Object InstitutionsFenRunRecordWhere(InstitutionsFenRunIssueVO institutionsFenRunIssueVO) {
        StringBuffer sb = new StringBuffer(" WHERE 1 = 1  ");
        if (!StringUtils.isEmpty(institutionsFenRunIssueVO.getLocalBeginDate())) {
            sb.append(" and tt1.localDate >= "+institutionsFenRunIssueVO.getLocalBeginDate());
        }
        if (!StringUtils.isEmpty(institutionsFenRunIssueVO.getLocalEndDate())) {
            sb.append(" and tt1.localDate <= "+institutionsFenRunIssueVO.getLocalEndDate());
        }
        if (!StringUtils.isEmpty(institutionsFenRunIssueVO.getBusinessType())) {
            sb.append(" and tt1.BUSINESS_TYPE=#{businessType,javaType=string,jdbcType=VARCHAR} ");
        }
        if (!StringUtils.isEmpty(institutionsFenRunIssueVO.getLocalLogno())) {
            sb.append(" and tt1.LOCALLOGNO=#{localLogno,javaType=string,jdbcType=VARCHAR} ");
        }
        if (!StringUtils.isEmpty(institutionsFenRunIssueVO.getAgencyId())) {
            sb.append(" and tt1.AGENCY_ID =#{agencyId,javaType=string,jdbcType=VARCHAR} ");
        }
        if (!StringUtils.isEmpty(institutionsFenRunIssueVO.getMobile())) {
            sb.append(" and u.userid=#{mobile,javaType=string,jdbcType=VARCHAR} ");
        }
        sb.append(" order by tt1.LOCALLOGNO desc ");
        return sb.toString();
    }

}

