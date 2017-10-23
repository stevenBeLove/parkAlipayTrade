/** 
 * 包名: package com.qt.sales.service; <br/> 
 * 添加时间: 2016年11月7日 下午2:31:14 <br/> 
 */
package com.qt.sales.service;

import java.util.List;

import com.qt.sales.model.LoginsLogVO;

/**
 * 
 * <pre>
 * 【类型】: LoginsLogService <br/> 
 * 【作用】: 登录日志业务逻辑实现类接口. <br/>  
 * 【时间】：2016年11月7日 下午2:31:25 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
public interface LoginsLogService {
    /**
     * 
     * 【方法名】 : 查询登陆日志数量. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 下午2:37:35 .<br/>
     * 【参数】： .<br/>
     * 
     * @param loginsLogVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    int LoginsLogCount(LoginsLogVO loginsLogVO);

    /**
     * 
     * 【方法名】 :查询登录日志List. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 下午2:37:54 .<br/>
     * 【参数】： .<br/>
     * 
     * @param loginsLogVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    List<LoginsLogVO> getLoginsLogList(LoginsLogVO loginsLogVO);

    /**
     * 
     * 【方法名】 : 新增登录日志. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 下午2:38:08 .<br/>
     * 【参数】： .<br/>
     * 
     * @param loginsLogVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    int insertLoginsLog(LoginsLogVO loginsLogVO);

}
