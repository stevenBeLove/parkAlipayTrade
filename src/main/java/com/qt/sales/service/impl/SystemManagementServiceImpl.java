/** 
 * 包名: package com.qt.sales.service.impl; <br/> 
 * 添加时间: 2016年11月4日 上午11:03:10 <br/> 
 */
package com.qt.sales.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qt.sales.dao.SystemManagementMapper;
import com.qt.sales.model.SystemParameter;
import com.qt.sales.service.SystemManagementService;

/** 
 * 类名: SystemManagementServiceImpl <br/> 
 * 作用：TODO(简单一句话描述)<br/> 
 * 方法：TODO(简单描述方法)<br/> 
 * 创建者: thinkpad. <br/> 
 * 添加时间: 2016年11月4日 上午11:03:10 <br/> 
 * 版本： JDK 1.6 SalesPlatform 1.0
 */
@Service
public class SystemManagementServiceImpl implements SystemManagementService{
    
    /**
     * Dao层接口
     */
    @Resource
    private SystemManagementMapper systemManagementMapper;
    
    @Override
    public int SystemManagementCount(SystemParameter systemParameter) {
        return systemManagementMapper.SystemManagementCount(systemParameter);
    }
    
    @Override
    public List<SystemParameter> getSystemManagementList(SystemParameter systemParameter) {
        return systemManagementMapper.SystemManagementList(systemParameter);
    }
    
    @Override
    public SystemParameter SystemParameterOne(SystemParameter systemParameter) {
        return systemManagementMapper.SystemManagementOne(systemParameter);
    }
    
    @Override
    public int insertSystemParameter(SystemParameter systemParameter) {
        return systemManagementMapper.insertSystemManagement(systemParameter);
    }
    
    @Override
    public int deleteSystemParameter(SystemParameter systemParameter) {
        return systemManagementMapper.deleteSystemManagement(systemParameter);
    }
    
    @Override
    public int updateSystemParameter(SystemParameter systemParameter) {
        return systemManagementMapper.updateSystemManagement(systemParameter);
    }
}

