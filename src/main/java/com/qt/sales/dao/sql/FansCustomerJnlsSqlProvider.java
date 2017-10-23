/** 
 * 包名: package com.qt.sales.dao.sql; <br/> 
 * 添加时间: 2016年10月31日 下午4:07:00 <br/> 
 */
package com.qt.sales.dao.sql;

import org.springframework.util.StringUtils;

import com.qt.sales.model.FansCustomerJnls;

/**
 * 
 * <pre>
 * 【类型】: FansCustomerJnlsSqlProvider <br/> 
 * 【作用】: 交易流水SQL <br/>  
 * 【时间】：2016年11月7日 上午10:22:20 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
public class FansCustomerJnlsSqlProvider {
    /**
     * 
     * 【方法名】 : 查询交易流水数量. <br/>
     * 【注意】: 返回int类型.<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午10:22:39 .<br/>
     * 【参数】： .<br/>
     * 
     * @param fansCustomerJnls 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    public static String queryFansCustomerJnlsCount(FansCustomerJnls fansCustomerJnls) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append(" select COUNT(1) ");
        sb.append(" from  tb_fans_customer_jnls s  ");
        sb.append(" left join  paycustomer r1 on r1.customerid=s.top_customerid");
        sb.append(" left join paycustomer r5 on r5.customerid = s.customerid");
        sb.append(" left join paycustomer r3 on r3.customerid=s.parent_customerid");
        sb.append(" left join paycustomer r4 on r4.customerid =s.two_customerid");
        sb.append(" left join payuser u on u.customerid = s.customerid");
        sb.append(" left join payuser u1 on u1.customerid=s.top_customerid ");
        sb.append(" left join payuser u2 on u2.customerid=s.parent_customerid ");
        sb.append(" left join payuser u3 on u3.customerid=s.two_customerid");
        sb.append(" left join TB_FANS_AGENCY y on y.agency_id =s.agency_id");
        sb.append(" left join TB_PRD_BUSINESS_TYPE e on e.business_type =s.business_type");
        sb.append(FansCustomerJnlsWhere(fansCustomerJnls));
        sb.insert(0, "select * from ( select row_.*, rownum rn from ( ");
        sb.append(" ) row_ where rownum <=10  )");
        sb.append(" where rn >0 ");
        return sb.toString();
    }

    /**
     * 
     * 【方法名】 : 查询交易流水List. <br/>
     * 【注意】: 返回List.<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午10:23:16 .<br/>
     * 【参数】： .<br/>
     * 
     * @param fansCustomerJnls 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    public static String queryFansCustomerJnlsList(FansCustomerJnls fansCustomerJnls) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append(" select s.frid,s.servcode,s.localdate,s.localtime,s.locallogno,"
                + "s.termid,s.psamid,s.merchantid,s.productid,s.business_type as businessType , s.customerid, r5.customername as customerName, u.userid as mobile,s.agency_id as agencyId,s.amount as amount,"
                + "s.parent_customerid as parentCustomerid,r3.customername as parentcustomername,u2.userid as parentuserid,s.parent_rate as parentRate,s.parent_profit as parentProfit,"
                + "s.two_customerid as twoCustomerid,r4.customername as twocustomername,u3.userid as twouserid,s.two_rate as twoRate,s.two_profit as twoProfit,"
                + "s.top_customerid as topCustomerid,r1.customername as topcustomername,u1.userid as topuserid,s.top_rate as topRate," + "s.top_profit as topProfit,s.status,"
                + "e.business_name as businessName,y.agency_name as agencyName");
        sb.append(" FROM  tb_fans_customer_jnls s  ");
        sb.append(" left join  paycustomer r1 on r1.customerid=s.top_customerid");
        sb.append(" left join paycustomer r5 on r5.customerid = s.customerid");
        sb.append(" left join paycustomer r3 on r3.customerid=s.parent_customerid");
        sb.append(" left join paycustomer r4 on r4.customerid =s.two_customerid");
        sb.append(" left join payuser u on u.customerid = s.customerid");
        sb.append(" left join payuser u1 on u1.customerid=s.top_customerid ");
        sb.append(" left join payuser u2 on u2.customerid=s.parent_customerid ");
        sb.append(" left join payuser u3 on u3.customerid=s.two_customerid");
        sb.append(" left join TB_FANS_AGENCY y on y.agency_id =s.agency_id");
        sb.append(" left join TB_PRD_BUSINESS_TYPE e on e.business_type =s.business_type");
        sb.append(FansCustomerJnlsWhere(fansCustomerJnls));
        sb.insert(0, "select * from ( select row_.*, rownum rn from ( ");
        sb.append(" ) row_ where rownum <=#{end:INTEGER} ) ");
        sb.append(" where rn  >#{start:INTEGER} ");
        return sb.toString();
    }

    /**
     * 
     * 【方法名】 : 查询交易流水Where条件. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午10:24:00 .<br/>
     * 【参数】： .<br/>
     * 
     * @param fansCustomerJnls 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    private static String FansCustomerJnlsWhere(FansCustomerJnls fansCustomerJnls) {
        StringBuffer sb = new StringBuffer(" WHERE 1 = 1  ");
        if (!StringUtils.isEmpty(fansCustomerJnls.getLocalBeginDate())) {
            sb.append(" and s.LOCALDATE >= "+fansCustomerJnls.getLocalBeginDate());
        }
        if (!StringUtils.isEmpty(fansCustomerJnls.getLocalEndDate())) {
            sb.append(" and s.LOCALDATE  <= "+fansCustomerJnls.getLocalEndDate());
        }
        if (!StringUtils.isEmpty(fansCustomerJnls.getBusinessType())) {
            sb.append(" and s.BUSINESS_TYPE=#{businessType,javaType=string,jdbcType=VARCHAR} ");
        }
        if (!StringUtils.isEmpty(fansCustomerJnls.getLocallogno())) {
            sb.append(" and s.LOCALLOGNO=#{locallogno,javaType=string,jdbcType=VARCHAR} ");
        }
        if (!StringUtils.isEmpty(fansCustomerJnls.getMobile())) {
            sb.append(" and u.userid=#{mobile,javaType=string,jdbcType=VARCHAR} ");
        }
        sb.append(" order by s.locallogno desc ");
        return sb.toString();
    }

}
