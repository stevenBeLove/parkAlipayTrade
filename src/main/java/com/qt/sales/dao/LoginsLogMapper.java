/** 
 * 包名: package com.qt.sales.dao; <br/> 
 * 添加时间: 2016年11月7日 下午2:25:18 <br/> 
 */
package com.qt.sales.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import com.qt.sales.dao.sql.LoginsLogSqlProvider;
import com.qt.sales.model.LoginsLogVO;

/**
 * 
 * <pre>
 * 【类型】: LoginsLogMapper <br/> 
 * 【作用】: 登录日志Mapper. <br/>  
 * 【时间】：2016年11月7日 下午2:25:31 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
public interface LoginsLogMapper {
    /**
     * 
     * 【方法名】 : 登录日志查询数量. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 下午2:26:28 .<br/>
     * 【参数】： .<br/>
     * 
     * @param loginsLogVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @SelectProvider(type = LoginsLogSqlProvider.class, method = "loginsLogCount")
    @ResultType(Integer.class)
    Integer loginsLogCount(LoginsLogVO loginsLogVO);

    /**
     * 
     * 【方法名】 : 登录日志查询List. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 下午2:27:37 .<br/>
     * 【参数】： .<br/>
     * 
     * @param loginsLogVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @SelectProvider(type = LoginsLogSqlProvider.class, method = "loginsLogList")
    @ResultType(LoginsLogVO.class)
    List<LoginsLogVO> loginsLogList(LoginsLogVO loginsLogVO);

    /**
     * 
     * 【方法名】 : 新增登录日志. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 下午2:29:04 .<br/>
     * 【参数】： .<br/>
     * 
     * @param loginsLogVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @InsertProvider(type = LoginsLogSqlProvider.class, method = "insertLoginsLog")
    @ResultType(Integer.class)
    Integer insertLoginsLog(LoginsLogVO loginsLogVO);

}
