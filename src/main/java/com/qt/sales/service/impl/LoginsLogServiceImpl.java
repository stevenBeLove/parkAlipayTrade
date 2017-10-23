/** 
 * 包名: package com.qt.sales.service.impl; <br/> 
 * 添加时间: 2016年11月7日 下午2:30:38 <br/> 
 */
package com.qt.sales.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qt.sales.dao.LoginsLogMapper;
import com.qt.sales.model.LoginsLogVO;
import com.qt.sales.service.LoginsLogService;

/**
 * 
 * <pre>
 * 【类型】: LoginsLogServiceImpl <br/> 
 * 【作用】: 登录日志业务逻辑实现类 <br/>  
 * 【时间】：2016年11月7日 下午2:30:44 <br/> 
 * 【作者】：fuyu <br/> 
 * </pre>
 */
@Service
public class LoginsLogServiceImpl implements LoginsLogService{
    
    /**
     * Dao层接口
     */
    @Resource
    private LoginsLogMapper loginsLogMapper;
    
    @Override
    public int LoginsLogCount(LoginsLogVO loginsLogVO) {
        return loginsLogMapper.loginsLogCount(loginsLogVO);
    }

    @Override
    public List<LoginsLogVO> getLoginsLogList(LoginsLogVO loginsLogVO) {
        return loginsLogMapper.loginsLogList(loginsLogVO);
    }
    
    @Override
    public int insertLoginsLog(LoginsLogVO loginsLogVO) {
        return loginsLogMapper.insertLoginsLog(loginsLogVO);
    }

}

