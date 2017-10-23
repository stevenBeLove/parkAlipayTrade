/** 
 * 包名: package com.qt.sales.dao; <br/> 
 * 添加时间: 2016年11月4日 上午11:01:14 <br/> 
 */
package com.qt.sales.dao;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.qt.sales.dao.sql.SystemManagementSqlProvider;
import com.qt.sales.model.SystemParameter;

/**
 * 
 * <pre>
 * 【类型】: SystemManagementMapper <br/> 
 * 【作用】: 系统配置参数Mapper <br/>  
 * 【时间】：2016年11月7日 上午11:50:39 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
public interface SystemManagementMapper {
    /**
     * 
     * 【方法名】 :系统配置参数查询数量. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:51:02 .<br/>
     * 【参数】： .<br/>
     * 
     * @param systemParameter 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @SelectProvider(type = SystemManagementSqlProvider.class, method = "SystemManagementCount")
    @ResultType(Integer.class)
    Integer SystemManagementCount(SystemParameter systemParameter);

    /**
     * 
     * 【方法名】 : 系统配置参数查询List <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:51:21 .<br/>
     * 【参数】： .<br/>
     * 
     * @param systemParameter 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @SelectProvider(type = SystemManagementSqlProvider.class, method = "SystemManagementList")
    @ResultType(SystemParameter.class)
    List<SystemParameter> SystemManagementList(SystemParameter systemParameter);

    /**
     * 
     * 【方法名】 : 查询系统配置参数对象. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:51:38 .<br/>
     * 【参数】： .<br/>
     * 
     * @param systemParameter 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @SelectProvider(type = SystemManagementSqlProvider.class, method = "SystemManagementOne")
    @ResultType(Integer.class)
    SystemParameter SystemManagementOne(SystemParameter systemParameter);

    /**
     * 
     * 【方法名】 : 新增系统配置参数. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:51:55 .<br/>
     * 【参数】： .<br/>
     * 
     * @param systemParameter 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @InsertProvider(type = SystemManagementSqlProvider.class, method = "insertSystemManagement")
    @ResultType(Integer.class)
    Integer insertSystemManagement(SystemParameter systemParameter);

    /**
     * 
     * 【方法名】 : 删除系统配置参数. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:52:12 .<br/>
     * 【参数】： .<br/>
     * 
     * @param systemParameter 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @DeleteProvider(type = SystemManagementSqlProvider.class, method = "deleteSystemManagement")
    @ResultType(Integer.class)
    Integer deleteSystemManagement(SystemParameter systemParameter);

    /**
     * 
     * 【方法名】 : 修改系统配置参数. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:52:33 .<br/>
     * 【参数】： .<br/>
     * 
     * @param systemParameter 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @UpdateProvider(type = SystemManagementSqlProvider.class, method = "updateSystemManagement")
    @ResultType(Integer.class)
    Integer updateSystemManagement(SystemParameter systemParameter);
}
