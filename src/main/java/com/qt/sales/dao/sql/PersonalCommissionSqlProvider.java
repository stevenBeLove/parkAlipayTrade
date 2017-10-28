/** 
 * 包名: package com.qt.sales.dao.sql; <br/> 
 * 添加时间: 2016年11月1日 上午11:28:04 <br/> 
 */
package com.qt.sales.dao.sql;

import org.springframework.util.StringUtils;

import com.qt.sales.model.PersonalCommissionVO;

/**
 * 
 * <pre>
 * 【类型】: PersonalCommissionSqlProvider <br/> 
 * 【作用】: TODO ADD FUNCTION. <br/>  
 * 【时间】：2016年11月4日 下午5:50:18 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
public class PersonalCommissionSqlProvider {

    /**
     * 
     * 【方法名】 : 交易信息个数. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月4日 下午5:50:24 .<br/>
     * 【参数】： .<br/>
     * 
     * @param personalCommissionVO
     * @return personalCommissionVO.<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    public static String PersonalCommissionCount(PersonalCommissionVO personalCommissionVO) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append(" select COUNT(1) ");
        sb.append("  from (select agency_id,customerid,localdate,(sum(parent_profit) + sum(two_profit) +sum(top_profit))  month_amount from (select agency_id,  parent_customerid customerid, substr(localdate, 1, 6) localdate,sum(parent_profit) parent_profit, 0 two_profit, 0 top_profit from tb_fans_customer_jnls group by agency_id,  parent_customerid,  substr(localdate, 1, 6) union all  select agency_id,  two_customerid customerid,  substr(localdate, 1, 6) localdate,   0 parent_profit,   sum(two_profit) two_profit,  0 top_profit  from tb_fans_customer_jnls  group by agency_id,       two_customerid,    substr(localdate, 1, 6) union all select agency_id,  top_customerid customerid,  substr(localdate, 1, 6) localdate,  0 parent_profit,  0 two_profit,  sum(top_profit) top_profit  from tb_fans_customer_jnls  group by agency_id,   top_customerid,   substr(localdate, 1, 6))   group by agency_id, customerid, localdate) t1 inner join qtpay.paycustomer t2  on t1.customerid = t2.customerid  inner join tb_fans_customer t3  on t1.customerid = t3.customerid inner join (select fs_usercode, substr(fs_origdate, 1, 6) month_date,  sum(FD_AMT) FD_AMT,  sum(FD_REALFEE) FD_REALFEE,    max(fs_origdate) fs_origdate   from qtfund.tdflist   where fs_inchannel in ('20','21')   group by fs_usercode, substr(fs_origdate, 1, 6)) t4   on t1.customerid = t4.fs_usercode inner join (select agency_id, agency_name from TB_FANS_AGENCY) ay on t1.agency_id = ay.agency_id and t1.localdate = t4.month_date");
        sb.append(PersonalCommissionWhere(personalCommissionVO));
        sb.insert(0, "select * from ( select row_.*, rownum rn from ( ");
        sb.append(" ) row_ where rownum <=10 ) ");
        sb.append(" where rn  >0 ");
        return sb.toString();
    }

    /**
     * 
     * 【方法名】 : 查询个人返佣记录List. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月9日 下午3:42:42 .<br/>
     * 【参数】： .<br/>
     * 
     * @param personalCommissionVO
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    public static String PersonalCommissionList(PersonalCommissionVO personalCommissionVO) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append("  select substr(t1.localdate, 1, 4) || '年' || substr(t1.localdate, 5, 2) || '月' as localDate,");
        sb.append("  t1.customerid as customerId,  ");
        sb.append("  t2.customername as customerName, ");
        sb.append("  t3.mobile, ");
        sb.append("  t1.month_amount as monthAmount,");
        sb.append("  t4.FD_AMT as fdAmount,");
        sb.append("  t4.FD_REALFEE as fdRealFee, ");
        sb.append("  t4.FD_AMT - t4.FD_REALFEE as sfAmount, ");
        sb.append("  '资金清算' sendType, ");
        sb.append("  fs_origdate as fsOrigDate,");
        sb.append("  ay.agency_id as agencyId, ");
        sb.append("  ay.agency_name as agencyName,");
        sb.append(" '已发放' status ");
        sb.append("  from (select agency_id,customerid,localdate,(sum(parent_profit) + sum(two_profit) +sum(top_profit))  month_amount from (select agency_id,  parent_customerid customerid, substr(localdate, 1, 6) localdate,sum(parent_profit) parent_profit, 0 two_profit, 0 top_profit from tb_fans_customer_jnls group by agency_id,  parent_customerid,  substr(localdate, 1, 6) union all  select agency_id,  two_customerid customerid,  substr(localdate, 1, 6) localdate,   0 parent_profit,   sum(two_profit) two_profit,  0 top_profit  from tb_fans_customer_jnls  group by agency_id,       two_customerid,    substr(localdate, 1, 6) union all select agency_id,  top_customerid customerid,  substr(localdate, 1, 6) localdate,  0 parent_profit,  0 two_profit , sum(top_profit) top_profit  from tb_fans_customer_jnls  group by agency_id,   top_customerid,   substr(localdate, 1, 6))   group by agency_id, customerid, localdate) t1 inner join qtpay.paycustomer t2  on t1.customerid = t2.customerid  inner join tb_fans_customer t3  on t1.customerid = t3.customerid inner join (select fs_usercode, substr(fs_origdate, 1, 6) month_date,  sum(FD_AMT) FD_AMT,  sum(FD_REALFEE) FD_REALFEE,    max(fs_origdate) fs_origdate   from qtfund.tdflist   where fs_inchannel in ('20','21')   group by fs_usercode, substr(fs_origdate, 1, 6)) t4   on t1.customerid = t4.fs_usercode inner join (select agency_id, agency_name from TB_FANS_AGENCY) ay on t1.agency_id = ay.agency_id and t1.localdate = t4.month_date");
        sb.append(PersonalCommissionWhere(personalCommissionVO));
        sb.insert(0, "select * from ( select row_.*, rownum rn from ( ");
        sb.append(" ) row_ where rownum <=#{end:INTEGER} ) ");
        sb.append(" where rn  >#{start:INTEGER} ");
        return sb.toString();
    }

    /**
     * 
     * 【方法名】 :个人返佣记录查询where条件. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月9日 下午3:43:16 .<br/>
     * 【参数】： .<br/>
     * 
     * @param personalCommissionVO
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    private static String PersonalCommissionWhere(PersonalCommissionVO personalCommissionVO) {
        StringBuffer sb = new StringBuffer(" WHERE 1 = 1");
        if (!StringUtils.isEmpty(personalCommissionVO.getFsOrigDate())) {
            sb.append(" and t4.month_date=#{fsOrigDate,javaType=string,jdbcType=VARCHAR} ");
        }
        if (!StringUtils.isEmpty(personalCommissionVO.getMobile())) {
            sb.append(" and t3.mobile=#{mobile,javaType=string,jdbcType=VARCHAR} ");
        }
        if (!StringUtils.isEmpty(personalCommissionVO.getLocalDate())) {
            sb.append(" and localDate=SUBSTR(" + personalCommissionVO.getLocalDate() + ", 1, 6) ");
        }
        if (!StringUtils.isEmpty(personalCommissionVO.getAgencyId())) {
            sb.append(" and ay.agency_id=#{agencyId,javaType=string,jdbcType=VARCHAR} ");
        }

        if (!StringUtils.isEmpty(personalCommissionVO.getLocalBeginDate())) {
            sb.append(" and fs_origdate >= " + personalCommissionVO.getLocalBeginDate());
        }
        if (!StringUtils.isEmpty(personalCommissionVO.getLocalEndDate())) {
            sb.append(" and fs_origdate  <= " + personalCommissionVO.getLocalEndDate());
        }
        return sb.toString();
    }
}
