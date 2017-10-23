/** 
 * 包名: package com.qt.sales.service; <br/> 
 * 添加时间: 2016年11月3日 上午9:54:01 <br/> 
 */
package com.qt.sales.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.qt.sales.model.TerminalManagementVO;

/**
 * 
 * 类名: TerminalManagementService <br/>
 * 作用：TODO(简单一句话描述)<br/>
 * 方法：TODO(简单描述方法)<br/>
 * 创建者: Fuyu. <br/>
 * 添加时间: 2016年11月3日 上午9:54:31 <br/>
 * 版本：
 * 
 * @since JDK 1.6 SalesPlatform 1.0
 */
public interface TerminalManagementService {
    /**
     * 
     * 【方法名】 : 查询终端数量. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月10日 下午5:41:05 .<br/>
     * 【参数】： .<br/>
     * 
     * @param terminalManagementVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    int TerminalManagementCount(TerminalManagementVO terminalManagementVO);

    /**
     * 
     * 【方法名】 : 查询终端列表. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月10日 下午5:40:51 .<br/>
     * 【参数】： .<br/>
     * 
     * @param terminalManagementVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    List<TerminalManagementVO> getTerminalManagementList(TerminalManagementVO terminalManagementVO);

    /**
     * 
     * 【方法名】 : 新增终端历史表. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月10日 下午5:40:39 .<br/>
     * 【参数】： .<br/>
     * 
     * @param terminalManagementVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    TerminalManagementVO TerminalManagementOne(TerminalManagementVO terminalManagementVO);

    /**
     * 
     * 【方法名】 :查询终端历史对象 <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月10日 下午5:41:30 .<br/>
     * 【参数】： .<br/>
     * 
     * @param terminalManagementVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    int hisTerminalManagementOne(TerminalManagementVO terminalManagementVO);

    /**
     * 
     * 【方法名】 : 新增终端历史表. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月10日 下午5:41:50 .<br/>
     * 【参数】： .<br/>
     * 
     * @param terminalManagementVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    int insertHisTerminal(TerminalManagementVO terminalManagementVO);

    /**
     * 
     * 【方法名】 : 删除终端. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月10日 下午5:42:04 .<br/>
     * 【参数】： .<br/>
     * 
     * @param terminalManagementVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    int deleteTerminalManagement(TerminalManagementVO terminalManagementVO);

    /**
     * 
     * 【方法名】 : 修改终端. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月10日 下午5:42:21 .<br/>
     * 【参数】： .<br/>
     * 
     * @param terminalManagementVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    int updatePaypsam(TerminalManagementVO terminalManagementVO);

    /**
     * 
     * 【方法名】 : 导入终端列表. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月9日 下午2:50:12 .<br/>
     * 【参数】： .<br/>
     * 
     * @param multipartFile
     *            MultipartFile对象
     * @param excelFilePath
     *            路径
     * @return List<TerminalManagementVO>
     * @throws Exception .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: yinghui zhang 修改描述： .<br/>
     *         <p/>
     */
    public List<TerminalManagementVO> paseExcelFile(MultipartFile multipartFile, String excelFilePath) throws Exception;

    /**
     * 
     * 【方法名】 : 新增终端信息. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月10日 下午5:33:29 .<br/>
     * 【参数】： .<br/>
     * 
     * @param terminalManagementVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    int insertTerminalConfig(TerminalManagementVO terminalManagementVO);
    /**
     * 
     * 【方法名】    :历史总段查询数量. <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月12日 上午10:23:52 .<br/>
     * 【参数】： .<br/>
     * @param terminalManagementVO 
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    int hisTerminalManagementCount(TerminalManagementVO terminalManagementVO);
    /**
     * 
     * 【方法名】    : 历史终端查询List. <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月12日 上午10:24:18 .<br/>
     * 【参数】： .<br/>
     * @param terminalManagementVO 
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    List<TerminalManagementVO> hisTerminalManagementList(TerminalManagementVO terminalManagementVO);

}
