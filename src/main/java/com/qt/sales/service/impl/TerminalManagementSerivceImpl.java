/** 
 * 包名: package com.qt.sales.service.impl; <br/> 
 * 添加时间: 2016年11月3日 上午9:53:50 <br/> 
 */
package com.qt.sales.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.qt.sales.common.excel.ParseExcelUtil;
import com.qt.sales.common.excel.SheetBean;
import com.qt.sales.dao.TerminalManagementMapper;
import com.qt.sales.exception.QTException;
import com.qt.sales.model.TerminalManagementVO;
import com.qt.sales.service.TerminalManagementService;
import com.qt.sales.utils.DateUtil;
import com.qt.sales.utils.LogPay;

/**
 * 
 * <pre>
 * 【类型】: TerminalManagementSerivceImpl <br/> 
 * 【作用】: 终端信息管理. <br/>  
 * 【时间】：2016年11月10日 下午5:35:25 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
@Service
public class TerminalManagementSerivceImpl implements TerminalManagementService {

    /**
     * Dao层接口
     */
    @Resource
    private TerminalManagementMapper terminalManagementMapper;

    @Override
    public int TerminalManagementCount(TerminalManagementVO terminalManagementVO) {
        return terminalManagementMapper.TerminalManagementCount(terminalManagementVO);
    }

    @Override
    public List<TerminalManagementVO> getTerminalManagementList(TerminalManagementVO terminalManagementVO) {
        return terminalManagementMapper.TerminalManagementList(terminalManagementVO);
    }
    
    
    @Override
    public int hisTerminalManagementCount(TerminalManagementVO terminalManagementVO) {
        return terminalManagementMapper.hisTerminalManagementCount(terminalManagementVO);
    }

    @Override
    public List<TerminalManagementVO> hisTerminalManagementList(TerminalManagementVO terminalManagementVO) {
        return terminalManagementMapper.hisTerminalManagementList(terminalManagementVO);
    }

    @Override
    public TerminalManagementVO TerminalManagementOne(TerminalManagementVO terminalManagementVO) {
        return terminalManagementMapper.TerminalManagementOne(terminalManagementVO);
    }

    @Override
    public int hisTerminalManagementOne(TerminalManagementVO terminalManagementVO) {
        return terminalManagementMapper.hisTerminalManagementOne(terminalManagementVO);
    }

    @Override
    public int insertHisTerminal(TerminalManagementVO terminalManagementVO) {
        return terminalManagementMapper.insertHisTerminal(terminalManagementVO);
    }

    @Override
    public int deleteTerminalManagement(TerminalManagementVO terminalManagementVO) {
        return terminalManagementMapper.deleteTerminalManagement(terminalManagementVO);
    }

    @Override
    public int updatePaypsam(TerminalManagementVO terminalManagementVO) {
        return terminalManagementMapper.updatePaypsam(terminalManagementVO);
    }

    @Override
    public int insertTerminalConfig(TerminalManagementVO terminalManagementVO) {
        return terminalManagementMapper.insertTerminalConfig(terminalManagementVO);
    }

    @Override
    public List<TerminalManagementVO> paseExcelFile(MultipartFile multipartFile, String excelFilePath) throws Exception {
        List<SheetBean> datas = null;
        List<TerminalManagementVO> listConfig = new ArrayList<TerminalManagementVO>();
        List<TerminalManagementVO> listPayterminal = new ArrayList<TerminalManagementVO>();
        datas = ParseExcelUtil.parseMultipleExcel(multipartFile, excelFilePath);
        if (CollectionUtils.isNotEmpty(datas)) {
            for (SheetBean sheetBean : datas) {
                // 记录导入中行记录数
                int total = 0;
                // 每个sheet data
                String[][] sheetData = sheetBean.getSheetData();
                if (sheetData != null && sheetData.length > 0) {
                    total += sheetData.length - 1;
                }
                // EXCEL中的列名
//                List<String> varNameList = sheetBean.getVarNameList();
                // 从数据行读取
                for (int row = 0; row < sheetData.length; row++) {
                    TerminalManagementVO listConfigvo = new TerminalManagementVO();
                    TerminalManagementVO listPayterminalvo = new TerminalManagementVO();
                    String [] rowsData = sheetData[row];
                    for (int i = 0; i < rowsData.length; i++) {
                        String dataStr = rowsData[i];
                            if (i == 0) {
                                LogPay.info(dataStr);
                                listConfigvo.setTermId(dataStr);
                                listPayterminalvo.setTermId(dataStr);
                            } else if (i == 1) {
                                listConfigvo.setOrderName(dataStr);
                            } else if (i == 2) {
                                listConfigvo.setOrderMobile(dataStr);
                            } else if (i == 3) {
                                listConfigvo.setProvince(dataStr);
                            } else if (i == 4) {
                                listConfigvo.setCity(dataStr);
                            } else if (i == 5) {
                                listConfigvo.setCounty(dataStr);
                            } else if (i == 6) {
                                listConfigvo.setAddress(dataStr);
                            } else if (i == 7) {
                                listConfigvo.setGiveDate(dataStr);
                            } 
                        }
                    Subject subject = SecurityUtils.getSubject();
                    listConfigvo.setCreateId((String)subject.getPrincipal());
                    listConfigvo.setCreatedt(DateUtil.getCurrDateAndTime());
                    listConfig.add(listConfigvo);
                    listPayterminal.add(listPayterminalvo);
                }
            }

        }
        
        for (TerminalManagementVO terminalManagementVO : listConfig) {
            Integer count = terminalManagementMapper.selectTerminalConfig(terminalManagementVO);
            if (count > 0) {
                throw new QTException("失败！导入重复终端，终端Id为：" + terminalManagementVO.getTermId());
            }
        }
        
        
        for (TerminalManagementVO terminalManagementVO : listConfig) {
           
            terminalManagementMapper.insertTerminalConfig(terminalManagementVO);
        }
        
        for (TerminalManagementVO terminalManagementVO : listPayterminal) {
            terminalManagementMapper.insertPayterminal(terminalManagementVO);
        }
        return listConfig;
    }

}
