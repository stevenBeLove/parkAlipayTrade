/** 
 * 包名: package com.qt.sales.dao.sql; <br/> 
 * 添加时间: 2016年11月7日 下午2:09:39 <br/> 
 */
package com.qt.sales.dao.sql;

import org.springframework.util.StringUtils;

import com.qt.sales.model.LoginsLogVO;

/**
 * 
 * <pre>
 * 【类型】: LoginsLogSqlProvider <br/> 
 * 【作用】: 登录日志. <br/>  
 * 【时间】：2016年11月7日 下午2:09:44 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
public class LoginsLogSqlProvider {
    /**
     * 
     * 【方法名】 : 查询登录日志数量. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 下午2:12:30 .<br/>
     * 【参数】： .<br/>
     * 
     * @param loginsLogVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    public static String loginsLogCount(LoginsLogVO loginsLogVO) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append(" select COUNT(1) ");
        sb.append(" from TB_FANS_SYS_LOGIN_LOG ");
        sb.append(loginsLogWhere(loginsLogVO));
        sb.insert(0, "select * from ( select row_.*, rownum rn from ( ");
        sb.append(" ) row_ where rownum <=10 ) ");
        sb.append(" where rn  >0 ");
        return sb.toString();
    }

    /**
     * 
     * 【方法名】 : 查询登录日志Where条件 <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 下午2:13:45 .<br/>
     * 【参数】： .<br/>
     * 
     * @param loginsLogVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    private static Object loginsLogWhere(LoginsLogVO loginsLogVO) {
        StringBuffer sb = new StringBuffer(" WHERE 1 = 1 ");
        if (!StringUtils.isEmpty(loginsLogVO.getUserName())) {
            sb.append(" and USERNAME=#{userName,javaType=string,jdbcType=VARCHAR} ");
        }
        sb.append(" order by logindate desc ");
        return sb.toString();
    }

    /**
     * 
     * 【方法名】 : 查询登录日志Where条件. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 下午2:16:22 .<br/>
     * 【参数】： .<br/>
     * 
     * @param loginsLogVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    public static String loginsLogList(LoginsLogVO loginsLogVO) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append(" select id,username,logindate,outdate, status ");
        sb.append(" from TB_FANS_SYS_LOGIN_LOG ");
        sb.append(loginsLogWhere(loginsLogVO));
        sb.insert(0, "select * from ( select row_.*, rownum rn from ( ");
        sb.append(" ) row_ where rownum <=#{end:INTEGER} ) ");
        sb.append(" where rn  >#{start:INTEGER} ");
        return sb.toString();
    }

    /**
     * 
     * 【方法名】 : 新增登录日志. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 下午2:20:11 .<br/>
     * 【参数】： .<br/>
     * 
     * @param loginsLogVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    public static String insertLoginsLog(LoginsLogVO loginsLogVO) {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb.append("   insert into TB_FANS_SYS_LOGIN_LOG" + "   (" + "id," + "username," + "logindate," + "outdate," + "status ) values(   ");
        sb.append("parkpay.seq_SEQ_FANS_SYS_NOTICE.nextval,   ");
        sb.append("#{userName ,javaType=string,jdbcType=VARCHAR},   ");
        sb.append("#{loginDate ,javaType=string,jdbcType=VARCHAR},   ");
        sb.append("#{outDate ,javaType=string,jdbcType=VARCHAR},   ");
        sb.append("#{status ,javaType=string,jdbcType=VARCHAR}  ");
        sb.append(")    ");
        return sb.toString();

    }
}
