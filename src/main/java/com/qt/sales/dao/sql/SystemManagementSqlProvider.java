/** 
 * 包名: package com.qt.sales.dao.sql; <br/> 
 * 添加时间: 2016年11月4日 上午11:00:48 <br/> 
 */
package com.qt.sales.dao.sql;

import org.springframework.util.StringUtils;

import com.qt.sales.model.SystemParameter;

/**
 * 
 * <pre>
 * 【类型】: SystemManagementSqlProvider <br/> 
 * 【作用】: 系统配置参数Sql. <br/>  
 * 【时间】：2016年11月7日 上午11:47:00 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
public class SystemManagementSqlProvider {
    /**
     * 
     * 【方法名】 : 系统配置参数查询数量. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:47:33 .<br/>
     * 【参数】： .<br/>
     * 
     * @param systemParameter 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    public static String SystemManagementCount(SystemParameter systemParameter) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append(" select COUNT(1) ");
        sb.append(" from TB_FANS_PARAM m");
        sb.append(SystemManagementWhere(systemParameter));
        sb.insert(0, "select * from ( select row_.*, rownum rn from ( ");
        sb.append(" ) row_ where rownum <=10 ) ");
        sb.append(" where rn  >0 ");
        return sb.toString();
    }

    /**
     * 
     * 【方法名】 : 系统配置参数查询List <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:47:55 .<br/>
     * 【参数】： .<br/>
     * 
     * @param systemParameter 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    public static String SystemManagementList(SystemParameter systemParameter) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append("  select m.id,m.PAR_NO as parNo ," + "m.par_min as parMin," + "m.par_max as parMax," + "m.par_name as parName ," + "m.par_remark as parRemark," + "m.status,"
                + "m.createdate as createDate" + " from tb_fans_param m ");
        sb.append(SystemManagementWhere(systemParameter));
        sb.insert(0, "select * from ( select row_.*, rownum rn from ( ");
        sb.append(" ) row_ where rownum <=#{end:INTEGER} ) ");
        sb.append(" where rn  >#{start:INTEGER} ");
        return sb.toString();
    }

    /**
     * 
     * 【方法名】 : 系统配置参数查询where条件. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:48:10 .<br/>
     * 【参数】： .<br/>
     * 
     * @param systemParameter 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    public static String SystemManagementWhere(SystemParameter systemParameter) {
        StringBuffer sb = new StringBuffer(" WHERE 1 = 1 order by id desc");
        if (!StringUtils.isEmpty(systemParameter.getParName())) {
            sb.append(" and m.par_name=#{parName,javaType=string,jdbcType=VARCHAR} ");
        }
        return sb.toString();
    }

    /**
     * 
     * 【方法名】 : 查询系统配置参数对象. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:48:29 .<br/>
     * 【参数】： .<br/>
     * 
     * @param systemParameter 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    public static String SystemManagementOne(SystemParameter systemParameter) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append("  select  m.id,m.PAR_NO as parNo," + "m.par_min as parMin," + "m.par_max as parMax," + "m.par_name as parName ," + "m.par_remark as parRemark," + "m.status," + "m.createdate "
                + "from tb_fans_param m ");
        sb.append("  where  m.Id = #{id,javaType=int,jdbcType=INTEGER}");
        return sb.toString();
    }

    /**
     * 
     * 【方法名】 : 新增系统配置参数. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月4日 下午6:04:30 .<br/>
     * 【参数】： .<br/>
     * 
     * @param systemParameter 
     * @return systemParameter.<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    public static String insertSystemManagement(SystemParameter systemParameter) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append("   insert into TB_FANS_PARAM ( id,PAR_NO,par_min,par_max,par_name,par_remark,status,createDate)");
        sb.append(" values( qtfans.seq_SEQ_FANS_SYS_NOTICE.nextval, ");
        sb.append("#{parNo,javaType=string,jdbcType=VARCHAR},   ");
        sb.append("#{parMin,javaType=int,jdbcType=INTEGER},   ");
        sb.append("#{parMax,javaType=int,jdbcType=INTEGER},   ");
        sb.append("#{parName,javaType=string,jdbcType=VARCHAR}  , ");
        sb.append("#{parRemark,javaType=string,jdbcType=VARCHAR} ,  ");
        sb.append("#{status,javaType=string,jdbcType=VARCHAR} ,  ");
        sb.append("#{createDate,javaType=string,jdbcType=VARCHAR}   ");
        sb.append(")    ");
        return sb.toString();
    }

    /**
     * 
     * 【方法名】 :修改系统配置参数. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:49:29 .<br/>
     * 【参数】： .<br/>
     * 
     * @param systemParameter 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    public static String updateSystemManagement(SystemParameter systemParameter) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append("  update tb_fans_param  set PAR_NO=#{parNo,javaType=string,jdbcType=VARCHAR},PAR_MIN = #{parMin,javaType=int,jdbcType=INTEGER},"
                + "PAR_MAX = #{parMax,javaType=int,jdbcType=INTEGER}," + "PAR_NAME = #{parName,javaType=string,jdbcType=VARCHAR}," + "PAR_REMARK = #{parRemark,javaType=string,jdbcType=VARCHAR},"
                + "STATUS = #{status,javaType=string,jdbcType=VARCHAR}," + "CREATEDATE = #{createDate,javaType=string,jdbcType=VARCHAR}");
        sb.append("  where  Id = #{id,javaType=int,jdbcType=INTEGER} ");
        return sb.toString();
    }

    /**
     * 
     * 【方法名】 : 删除系统配置参数 <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:49:51 .<br/>
     * 【参数】： .<br/>
     * 
     * @param systemParameter 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    public static String deleteSystemManagement(SystemParameter systemParameter) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append("  update tb_fans_param set status='0' ");
        sb.append("  where  Id = #{id,javaType=int,jdbcType=INTEGER}");
        return sb.toString();
    }

}
