/** 
 * 包名: package com.qt.sales.service.impl; <br/> 
 * 添加时间: 2016年11月15日 下午3:23:45 <br/> 
 */
package com.qt.sales.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qt.sales.dao.InstitutionsFenRunRecordMapper;
import com.qt.sales.model.InstitutionsFenRunIssueVO;
import com.qt.sales.service.InstitutionsFenRunRecordService;
import com.qt.sales.utils.Format;

/**
 * 
 * <pre>
 * 【类型】: InstitutionsFenRunRecordServiceImpl <br/> 
 * 【作用】: TODO ADD FUNCTION. <br/>  
 * 【时间】：2016年11月15日 下午3:24:03 <br/> 
 * 【作者】：fuyu <br/> 
 * </pre>
 */
@Service
public class InstitutionsFenRunRecordServiceImpl implements InstitutionsFenRunRecordService {
    
    /**
     * Dao层接口
     */
    @Resource
    private InstitutionsFenRunRecordMapper institutionsFenRunRecordMapper;

    @Override
    public int InstitutionsFenRunRecordCount(InstitutionsFenRunIssueVO institutionsFenRunIssueVO) {
        return institutionsFenRunRecordMapper.InstitutionsFenRunRecordCount(institutionsFenRunIssueVO);
    }

    @Override
    public List<InstitutionsFenRunIssueVO> getInstitutionsFenRunRecordList(InstitutionsFenRunIssueVO institutionsFenRunIssueVO) {
        return institutionsFenRunRecordMapper.InstitutionsFenRunRecordList(institutionsFenRunIssueVO);
    }
    
    
    @Override
    public String institutionsFenRunRecordResultToExcel(InstitutionsFenRunIssueVO institutionsFenRunIssueVO) {
        StringBuffer sBuffer = new StringBuffer();
        List<InstitutionsFenRunIssueVO> institutionsFenRunIssueVOList = institutionsFenRunRecordMapper.InstitutionsFenRunRecordList(institutionsFenRunIssueVO);
        sBuffer.append("交易流水号,");
        sBuffer.append("交易日期,");
        sBuffer.append("隶属机构,");
        sBuffer.append("隶属机构编号,");
        sBuffer.append("交易类型,");
        sBuffer.append("交易金额（元）,");
        sBuffer.append("交易人,");
        sBuffer.append("交易人手机号,");
        sBuffer.append("可分润机构,");
        sBuffer.append("可分润机构编号,");
        sBuffer.append("分润比,");
        sBuffer.append("分润金额\n");
        if (institutionsFenRunIssueVOList != null && !institutionsFenRunIssueVOList.isEmpty()) {
            for (int i = 0; i < institutionsFenRunIssueVOList.size(); i++) {
                institutionsFenRunIssueVO = institutionsFenRunIssueVOList.get(i);
                sBuffer.append(institutionsFenRunIssueVO.getLocalLogno() + ",");
                sBuffer.append(institutionsFenRunIssueVO.getLocalDate() + ",");
                sBuffer.append(institutionsFenRunIssueVO.getAgencyId() + ",");
                sBuffer.append(institutionsFenRunIssueVO.getAgencyName() + ",");
                sBuffer.append(institutionsFenRunIssueVO.getBusinessType() + ",");
                sBuffer.append(Format.replaceMoney(institutionsFenRunIssueVO.getAmount()) + ",");
                sBuffer.append(institutionsFenRunIssueVO.getCustomername() + ",");
                sBuffer.append(institutionsFenRunIssueVO.getMobile() + ",");
                sBuffer.append(institutionsFenRunIssueVO.getAgencyName() + ",");
                sBuffer.append(institutionsFenRunIssueVO.getSuperAgencyId() + ",");
                sBuffer.append(Format.replaceMoney(institutionsFenRunIssueVO.getRate()) + ",");
                sBuffer.append(Format.replaceMoney(institutionsFenRunIssueVO.getMonthProfit()) + "\n");
            }
        }
        return sBuffer.toString();
    }

}

