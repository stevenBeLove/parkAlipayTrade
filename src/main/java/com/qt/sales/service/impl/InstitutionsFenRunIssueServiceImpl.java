/** 
 * 包名: package com.qt.sales.service.impl; <br/> 
 * 添加时间: 2016年11月2日 上午9:37:52 <br/> 
 */
package com.qt.sales.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qt.sales.dao.InstitutionsFenRunIssueMapper;
import com.qt.sales.model.InstitutionsFenRunIssueVO;
import com.qt.sales.service.InstitutionsFenRunIssueService;

/**
 * 
 * <pre>
 * 【类型】: InstitutionsFenRunIssueServiceImpl <br/> 
 * 【作用】: 机构分润业务逻辑实现类 <br/>  
 * 【时间】：2016年11月7日 上午11:31:23 <br/> 
 * 【作者】：fuyu <br/> 
 * </pre>
 */
@Service
public class InstitutionsFenRunIssueServiceImpl implements InstitutionsFenRunIssueService {

    /**
     * Dao层接口
     */
    @Resource
    private InstitutionsFenRunIssueMapper institutionsFenRunIssueMapper;

    @Override
    public int InstitutionsFenRunIssueCount(InstitutionsFenRunIssueVO institutionsFenRunIssueVO) {
        return institutionsFenRunIssueMapper.InstitutionsFenRunIssueCount(institutionsFenRunIssueVO);
    }

    @Override
    public List<InstitutionsFenRunIssueVO> getInstitutionsFenRunIssueList(InstitutionsFenRunIssueVO institutionsFenRunIssueVO) {
        return institutionsFenRunIssueMapper.InstitutionsFenRunIssueList(institutionsFenRunIssueVO);
    }

}
