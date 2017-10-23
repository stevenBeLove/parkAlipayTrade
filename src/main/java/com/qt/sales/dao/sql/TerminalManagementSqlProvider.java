/** 
 * 包名: package com.qt.sales.dao.sql; <br/> 
 * 添加时间: 2016年11月3日 上午9:51:41 <br/> 
 */
package com.qt.sales.dao.sql;

import org.springframework.util.StringUtils;

import com.qt.sales.model.TerminalManagementVO;

/**
 * 
 * <pre>
 * 【类型】: TerminalManagementSqlProvider <br/> 
 * 【作用】: 终端SQL映射 <br/>  
 * 【时间】：2016年11月7日 下午4:47:27 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
public class TerminalManagementSqlProvider {

    /**
     * 
     * 【方法名】 : 查询终端个数. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 下午4:47:48 .<br/>
     * 【参数】： .<br/>
     * 
     * @param terminalManagementVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    public static String TerminalManagementCount(TerminalManagementVO terminalManagementVO) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append(" select  count(1) from TB_FANS_PAYTERMINAL a ");
        sb.append("  left join TB_FANS_TERMINAL_CONFIG a1 on a.termid = a1.termid ");
        sb.append("  left join qtfr2.qt1tblterminal t3  on t3.terminalcode=a.termid ");
        sb.append("  left join TB_FANS_AGENCY t on t.agency_id = t3.agencyid ");
        sb.append("  left join paycustomer t1 on t1.customerid = a.customerid ");
        sb.append("  left join payuser t2 on t1.customerid = t2.customerid ");
        sb.append(TerminalManagementWhere(terminalManagementVO));
        sb.insert(0, "select * from ( select row_.*, rownum rn from ( ");
        sb.append(" ) row_ where rownum <=10 ) ");
        sb.append(" where rn  >0 ");
        return sb.toString();
    }

    /**
     * 
     * 【方法名】 : 查询终端List. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 下午4:48:06 .<br/>
     * 【参数】： .<br/>
     * 
     * @param terminalManagementVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    public static String TerminalManagementList(TerminalManagementVO terminalManagementVO) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append("  select  t3.agencyId , "
                + "  t.agency_name as agencyName,a.termId, a.customerId,t1.customerName, t2.userid as mobile, a.termActivation, a.openDate,a1.order_name as orderName,a1.order_mobile as orderMobile,a1.province,a1.city,a1.county,a1.address,a1.createId,a1.createdt,a1.giveDate ,a.PSAMID from TB_FANS_PAYTERMINAL a ");
        sb.append("  left join TB_FANS_TERMINAL_CONFIG a1 on a.termid = a1.termid ");
        sb.append("  left join qtfr2.qt1tblterminal t3  on t3.terminalcode=a.termid ");
        sb.append("  left join TB_FANS_AGENCY t on t.agency_id = t3.agencyid ");
        sb.append("  left join paycustomer t1 on t1.customerid = a.customerid ");
        sb.append("  left join payuser t2 on t1.customerid = t2.customerid ");
        sb.append(TerminalManagementWhere(terminalManagementVO));
        sb.insert(0, "select * from ( select row_.*, rownum rn from ( ");
        sb.append(" ) row_ where rownum <=#{end:INTEGER} ) ");
        sb.append(" where rn  >#{start:INTEGER} ");
        return sb.toString();
    }

    /**
     * 
     * 【方法名】 : 查询终端Where条件. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 下午4:48:31 .<br/>
     * 【参数】： .<br/>
     * 
     * @param terminalManagementVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    private static String TerminalManagementWhere(TerminalManagementVO terminalManagementVO) {
        StringBuffer sb = new StringBuffer(" WHERE 1 = 1");
        if (!StringUtils.isEmpty(terminalManagementVO.getTermId())) {
            sb.append(" and a.termId=#{termId,javaType=string,jdbcType=VARCHAR} ");
        }
        if (!StringUtils.isEmpty(terminalManagementVO.getMobile())) {
            sb.append(" and  t2.userid=#{mobile,javaType=string,jdbcType=VARCHAR} ");
        }
        if (!StringUtils.isEmpty(terminalManagementVO.getOrderMobile())) {
            sb.append(" and  a1.order_mobile=#{orderMobile,javaType=string,jdbcType=VARCHAR} ");
        }
        if (!StringUtils.isEmpty(terminalManagementVO.getAgencyId())) {
            sb.append(" and  t3.agencyId=#{agencyId,javaType=string,jdbcType=VARCHAR} ");
        }
        if (!StringUtils.isEmpty(terminalManagementVO.getTermActivation())) {
            sb.append(" and  a.termActivation=#{termActivation,javaType=string,jdbcType=VARCHAR} ");
        }
        return sb.toString();
    }
    
    
    /**
     * 
     * 【方法名】    : 历史终端数量查询. <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月12日 上午10:11:33 .<br/>
     * 【参数】： .<br/>
     * @param terminalManagementVO 
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    public static String hisTerminalManagementCount(TerminalManagementVO terminalManagementVO) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append(" select count(1) from tb_his_fans_payterminal l");
        sb.append(" left join qtfr2.qt1tblterminal t3 on t3.terminalcode=l.termid ");
        sb.append(" left join tb_fans_agency y on y.agency_id = t3.agencyid");
        sb.append(" left join paycustomer r on r.customerid = l.customerid ");
        sb.append(" left join TB_FANS_TERMINAL_CONFIG a1 on a1.termid = l.termid ");
        sb.append(hisTerminalManagementWhere(terminalManagementVO));
        sb.insert(0, "select * from ( select row_.*, rownum rn from ( ");
        sb.append(" ) row_ where rownum <=10 ) ");
        sb.append(" where rn  >0 ");
        return sb.toString();

    }
    
    /**
     * 
     * 【方法名】    :查询终端List. <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月12日 上午10:13:03 .<br/>
     * 【参数】： .<br/>
     * @param terminalManagementVO 
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    public static String hisTerminalManagementList(TerminalManagementVO terminalManagementVO) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append(" select l.termid,l.termactivation,l.customerid,r.customername,t3.agencyid as agencyId,y.agency_name as agencyName,l.havepsam,l.psamid,a1.createId,a1.createdt,l.opendate,l.unbuild_date as unbuildDate ,l.unbuildId from tb_his_fans_payterminal l");
        sb.append(" left join qtfr2.qt1tblterminal t3 on t3.terminalcode=l.termid ");
        sb.append(" left join tb_fans_agency y on y.agency_id = t3.agencyid");
        sb.append(" left join paycustomer r on r.customerid = l.customerid ");
        sb.append(" left join TB_FANS_TERMINAL_CONFIG a1 on a1.termid = l.termid ");
        sb.append(hisTerminalManagementWhere(terminalManagementVO));
        sb.insert(0, "select * from ( select row_.*, rownum rn from ( ");
        sb.append(" ) row_ where rownum <=10 ) ");
        sb.append(" where rn  >0 ");
        return sb.toString();

    }
    
    /**
     * 
     * 【方法名】    :历史终端查询Where条件. <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月12日 上午10:17:58 .<br/>
     * 【参数】： .<br/>
     * @param terminalManagementVO 
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    private static String hisTerminalManagementWhere(TerminalManagementVO terminalManagementVO) {
        StringBuffer sb = new StringBuffer(" WHERE 1 = 1");
        if (!StringUtils.isEmpty(terminalManagementVO.getTermId())) {
            sb.append(" and l.termId=#{termId,javaType=string,jdbcType=VARCHAR} ");
        }
        return sb.toString();
    }

    /**
     * 
     * 【方法名】 : 根据PASM卡号查询历史终端表. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 下午4:48:55 .<br/>
     * 【参数】： .<br/>
     * 
     * @param terminalManagementVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    public static String hisTerminalManagementOne(TerminalManagementVO terminalManagementVO) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append(" select count(1) from tb_his_fans_payterminal");
        sb.append(" where  psamId = #{psamId,javaType=string,jdbcType=VARCHAR}");
        return sb.toString();

    }

    /**
     * 
     * 【方法名】 : 根据终端号查询终端信息. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 下午4:49:11 .<br/>
     * 【参数】： .<br/>
     * 
     * @param terminalManagementVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    public static String TerminalManagementOne(TerminalManagementVO terminalManagementVO) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append(" select a.branchid as agencyId, "
                + "  t.agency_name as agencyName,a.termId, a.customerId,t1.customerName,t2.userid as mobile ,a.termActivation, a.openDate, a.havepsam,a.psamid,a1.order_name as orderName,a1.order_mobile as orderMobile,a1.province,a1.city,a1.county,a1.address,a1.createId,a1.createdt ,a1.giveDate from TB_FANS_PAYTERMINAL a ");
        sb.append("  left join TB_FANS_TERMINAL_CONFIG a1 on a.termid = a1.termid ");
        sb.append("  left join TB_FANS_AGENCY t on t.agency_id = a.branchid ");
        sb.append("  left join paycustomer t1 on t1.customerid = a.customerid ");
        sb.append("  left join payuser t2 on t1.customerid = t2.customerid ");
        sb.append("  where  a.termId = #{termId,javaType=string,jdbcType=VARCHAR}");
        return sb.toString();

    }

    /**
     * 
     * 【方法名】 : 新增终端信息. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 下午4:49:22 .<br/>
     * 【参数】： .<br/>
     * 
     * @param terminalManagementVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    public static String insertHisTerminal(TerminalManagementVO terminalManagementVO) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append("   insert into tb_his_fans_payterminal" + "   (termid," + "termequity," + "termstate," + "tempuser," + "customerid," + "branchid,"
                + "havepsam," + "psamid," + "opendate," + "termactivation," +"UNBUILDID,"+ "unbuild_date ) values(   ");
        sb.append("#{termId ,javaType=string,jdbcType=VARCHAR},   ");
        sb.append("#{termEquity ,javaType=string,jdbcType=VARCHAR},   ");
        sb.append("#{termState ,javaType=string,jdbcType=VARCHAR},   ");
        sb.append("#{tempUser ,javaType=string,jdbcType=VARCHAR},   ");
        sb.append("#{customerId ,javaType=string,jdbcType=VARCHAR},   ");
        sb.append("#{agencyId ,javaType=string,jdbcType=VARCHAR},   ");
        sb.append("#{havePsam,javaType=string,jdbcType=VARCHAR},   ");
        sb.append("#{psamId,javaType=string,jdbcType=VARCHAR},   ");
        sb.append("#{openDate ,javaType=string,jdbcType=VARCHAR},   ");
        sb.append("#{termActivation,javaType=string,jdbcType=VARCHAR},   ");
        sb.append("#{unbuildId,javaType=string,jdbcType=VARCHAR},   ");
        sb.append("#{unbuildDate,javaType=string,jdbcType=VARCHAR}  ");
        sb.append(")    ");
        return sb.toString();

    }

    /**
     * 
     * 【方法名】 : 删除终端信息. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 下午4:49:32 .<br/>
     * 【参数】： .<br/>
     * 
     * @param terminalManagementVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    public static String deleteTerminalManagement(TerminalManagementVO terminalManagementVO) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append(" delete from tb_fans_payterminal  ");
        sb.append(" where  termId = #{termId,javaType=string,jdbcType=VARCHAR}");
        return sb.toString();

    }
    /**
     * 
     * 【方法名】 : 修改机构号以及状态. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 下午4:49:44 .<br/>
     * 【参数】： .<br/>
     * 
     * @param terminalManagementVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    public static String updatePaypsam(TerminalManagementVO terminalManagementVO) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append("  update tb_fans_paypsam m  set m.branchid='00000000',m.psamstatus='1' ");
        sb.append("  where  PSAMID = #{psamId,javaType=string,jdbcType=VARCHAR}");
        return sb.toString();

    }
    
    /**
     * 
     * 【方法名】    : 导入终端信息至数据库. <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月10日 下午5:30:03 .<br/>
     * 【参数】： .<br/>
     * @param terminalManagementVO 
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    public static String insertTerminalConfig(TerminalManagementVO terminalManagementVO) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append("  insert into TB_FANS_TERMINAL_CONFIG(AGENCY_ID,termid,Order_Name,Order_Mobile,Province,City,County,Address,Givedate,Createid,Createdt) values(");
        sb.append(" #{agencyId ,javaType=string,jdbcType=VARCHAR},");
        sb.append(" #{termId ,javaType=string,jdbcType=VARCHAR},");
        sb.append(" #{orderName ,javaType=string,jdbcType=VARCHAR},");
        sb.append(" #{orderMobile ,javaType=string,jdbcType=VARCHAR},");
        sb.append(" #{province ,javaType=string,jdbcType=VARCHAR},");
        sb.append(" #{city ,javaType=string,jdbcType=VARCHAR},");
        sb.append(" #{county ,javaType=string,jdbcType=VARCHAR},");
        sb.append(" #{address ,javaType=string,jdbcType=VARCHAR},");
        sb.append(" #{giveDate ,javaType=string,jdbcType=VARCHAR},");
        sb.append(" #{createId ,javaType=string,jdbcType=VARCHAR},");
        sb.append(" #{createdt ,javaType=string,jdbcType=VARCHAR}");
        sb.append(")    ");
        return sb.toString();

    }
    
    /**
     * 
     * 【方法名】    : 新增终端信息. <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月11日 下午1:34:13 .<br/>
     * 【参数】： .<br/>
     * @param terminalManagementVO 
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    public static String insertPayterminal(TerminalManagementVO terminalManagementVO) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append(" insert into TB_FANS_PAYTERMINAL(termid,BRANCHID,TERMACTIVATION) values(");
        sb.append(" #{termId ,javaType=string,jdbcType=VARCHAR},");
        sb.append(" #{agencyId ,javaType=string,jdbcType=VARCHAR},");
        sb.append(" #{termActivation ,javaType=string,jdbcType=VARCHAR}");
        sb.append(")    ");
        return sb.toString();
    }
    
    /**
     * 
     * 【方法名】    : (这里用一句话描述这个方法的作用). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月25日 下午8:45:06 .<br/>
     * 【参数】： .<br/>
     * @param terminalManagementVO TerminalManagementVO终端属性
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public static String selectTerminalConfig(TerminalManagementVO terminalManagementVO) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append(" select count(*) from TB_FANS_TERMINAL_CONFIG  ");
        sb.append(" where  termId = #{termId,javaType=string,jdbcType=VARCHAR}");
        return sb.toString();

    }
    

}
