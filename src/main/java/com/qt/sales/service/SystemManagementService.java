/** 
 * 包名: package com.qt.sales.service; <br/> 
 * 添加时间: 2016年11月4日 上午11:03:23 <br/> 
 */
package com.qt.sales.service;

import java.util.List;

import com.qt.sales.model.SystemParameter;

/**
 * 
 * <pre>
 * 【类型】: SystemManagementService <br/> 
 * 【作用】: 系统参数业务逻辑实现接口类 <br/>  
 * 【时间】：2016年11月7日 上午11:57:07 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
public interface SystemManagementService {
    /**
     * 
     * 【方法名】 : 查询系统参数数量. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:57:28 .<br/>
     * 【参数】： .<br/>
     * 
     * @param systemParameter 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    int SystemManagementCount(SystemParameter systemParameter);

    /**
     * 
     * 【方法名】 : 查询系统参数List. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:57:40 .<br/>
     * 【参数】： .<br/>
     * 
     * @param systemParameter 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    List<SystemParameter> getSystemManagementList(SystemParameter systemParameter);

    /**
     * 
     * 【方法名】 : 查询系统参数对象. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:57:54 .<br/>
     * 【参数】： .<br/>
     * 
     * @param systemParameter 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    SystemParameter SystemParameterOne(SystemParameter systemParameter);

    /**
     * 
     * 【方法名】 : 新增系统参数. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:58:07 .<br/>
     * 【参数】： .<br/>
     * 
     * @param systemParameter 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    int insertSystemParameter(SystemParameter systemParameter);

    /**
     * 
     * 【方法名】 : 删除系统参数. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:58:20 .<br/>
     * 【参数】： .<br/>
     * 
     * @param systemParameter 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    int deleteSystemParameter(SystemParameter systemParameter);

    /**
     * 
     * 【方法名】 : 修改系统参数. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:58:34 .<br/>
     * 【参数】： .<br/>
     * 
     * @param systemParameter 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    int updateSystemParameter(SystemParameter systemParameter);

}
