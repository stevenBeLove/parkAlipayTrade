/** 
 * 包名: package com.qt.sales.dao; <br/> 
 * 添加时间: 2016年11月3日 上午9:52:49 <br/> 
 */
package com.qt.sales.dao;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.qt.sales.dao.sql.TerminalManagementSqlProvider;
import com.qt.sales.model.PersonalCommissionVO;
import com.qt.sales.model.TerminalManagementVO;
/**
 * 
 * <pre>
 * 【类型】: TerminalManagementMapper <br/> 
 * 【作用】: 终端管理. <br/>  
 * 【时间】：2016年11月10日 下午5:32:29 <br/> 
 * 【作者】：fuyu <br/> 
 * </pre>
 */
public interface TerminalManagementMapper {
    /**
     * 
     * 【方法名】    : 查询终端数量. <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月10日 下午5:32:16 .<br/>
     * 【参数】： .<br/>
     * @param terminalManagementVO 
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    @SelectProvider(type = TerminalManagementSqlProvider.class, method = "TerminalManagementCount")
    @ResultType(Integer.class)
    Integer TerminalManagementCount(TerminalManagementVO terminalManagementVO);

    /**
     * 
     * 【方法名】    : 查询终端信息List. <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月10日 下午5:31:54 .<br/>
     * 【参数】： .<br/>
     * @param terminalManagementVO 
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    @SelectProvider(type = TerminalManagementSqlProvider.class, method = "TerminalManagementList")
    @ResultType(PersonalCommissionVO.class)
    List<TerminalManagementVO> TerminalManagementList(TerminalManagementVO terminalManagementVO);
    

   /**
    * 
    * 【方法名】    : 查询终端信息对象. <br/> 
    * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
    * 【作者】: fuyu .<br/>
    * 【时间】： 2016年11月10日 下午5:31:32 .<br/>
    * 【参数】： .<br/>
    * @param terminalManagementVO 
    * @return .<br/>
    * <p>
    * 修改记录.<br/>
    * 修改人: fuyu 修改描述： .<br/>
    * <p/>
    */
    @SelectProvider(type = TerminalManagementSqlProvider.class, method = "TerminalManagementOne")
    @ResultType(Integer.class)
    TerminalManagementVO TerminalManagementOne(TerminalManagementVO terminalManagementVO);
    
    /**
     * 
     * 【方法名】    : 历史终端查询数量. <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月12日 上午10:20:37 .<br/>
     * 【参数】： .<br/>
     * @param terminalManagementVO 
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    @SelectProvider(type = TerminalManagementSqlProvider.class, method = "hisTerminalManagementCount")
    @ResultType(Integer.class)
    Integer hisTerminalManagementCount(TerminalManagementVO terminalManagementVO);
    
    /**
     * 
     * 【方法名】    : (这里用一句话描述这个方法的作用). <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月12日 上午10:21:35 .<br/>
     * 【参数】： .<br/>
     * @param terminalManagementVO 
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    @SelectProvider(type = TerminalManagementSqlProvider.class, method = "hisTerminalManagementList")
    @ResultType(PersonalCommissionVO.class)
    List<TerminalManagementVO> hisTerminalManagementList(TerminalManagementVO terminalManagementVO);
    
    /**
     * 
     * 【方法名】    : (这里用一句话描述这个方法的作用). <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月25日 下午8:50:31 .<br/>
     * 【参数】： .<br/>
     * @param terminalManagementVO TerminalManagementVO对象
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    @SelectProvider(type = TerminalManagementSqlProvider.class, method = "selectTerminalConfig")
    @ResultType(Integer.class)
    Integer selectTerminalConfig(TerminalManagementVO terminalManagementVO);
    
    /**
     * 
     * 方法名： hisTerminalManagementOne.<br/>
     * 方法作用:根据PASM卡号查询历史终端表.<br/>
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月3日.<br/>
     * 创建时间：下午3:02:50.<br/>
     * 参数者异常：@param terminalManagementVO
     * 参数者异常：@return .<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    @InsertProvider(type = TerminalManagementSqlProvider.class, method = "hisTerminalManagementOne")
    @ResultType(Integer.class)
    Integer hisTerminalManagementOne(TerminalManagementVO terminalManagementVO);
    
    /**
     * 
     * 方法名： insertHisTerminal.<br/>
     * 方法作用:新增终端信息.<br/>
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月3日.<br/>
     * 创建时间：下午3:32:44.<br/>
     * 参数者异常：@param terminalManagementVO
     * 参数者异常：@return .<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    @InsertProvider(type = TerminalManagementSqlProvider.class, method = "insertHisTerminal")
    @ResultType(Integer.class)
    Integer insertHisTerminal(TerminalManagementVO terminalManagementVO);
    
    /**
     * 
     * 方法名： deleteTerminalManagement.<br/>
     * 方法作用:删除终端信息(简单描述).<br/>
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月3日.<br/>
     * 创建时间：下午3:33:35.<br/>
     * 参数者异常：@param terminalManagementVO
     * 参数者异常：@return .<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    @DeleteProvider(type = TerminalManagementSqlProvider.class, method = "deleteTerminalManagement")
    @ResultType(Integer.class)
    Integer deleteTerminalManagement(TerminalManagementVO terminalManagementVO);
    
    /**
     * 
     * 方法名： updatePaypsam.<br/>
     * 方法作用:修改机构号以及状态(简单描述).<br/>
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月3日.<br/>
     * 创建时间：下午3:34:08.<br/>
     * 参数者异常：@param terminalManagementVO
     * 参数者异常：@return .<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    @UpdateProvider(type = TerminalManagementSqlProvider.class, method = "updatePaypsam")
    @ResultType(Integer.class)
    Integer updatePaypsam(TerminalManagementVO terminalManagementVO);
    /**
     * 
     * 【方法名】    : 新增终端信息. <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月10日 下午5:31:02 .<br/>
     * 【参数】： .<br/>
     * @param terminalManagementVO 
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    @InsertProvider(type = TerminalManagementSqlProvider.class, method = "insertTerminalConfig")
    @ResultType(Integer.class)
    Integer insertTerminalConfig(TerminalManagementVO terminalManagementVO);
    
    /**
     * 
     * 【方法名】    :新增终端信息. <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月11日 下午1:34:49 .<br/>
     * 【参数】： .<br/>
     * @param terminalManagementVO 
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    @InsertProvider(type = TerminalManagementSqlProvider.class, method = "insertPayterminal")
    @ResultType(Integer.class)
    Integer insertPayterminal(TerminalManagementVO terminalManagementVO);
}
