/** 
 * 包名: package com.qt.sales.service.impl; <br/> 
 * 添加时间: 2016年10月21日 下午1:55:44 <br/> 
 */
package com.qt.sales.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.qt.sales.common.CommonEnums.AgencyScaleStatus;
import com.qt.sales.common.CommonEnums.FlowNodeStatus;
import com.qt.sales.dao.FansAgencyMapper;
import com.qt.sales.dao.FansAgencyScaleMapper;
import com.qt.sales.exception.QTException;
import com.qt.sales.model.BusinessType;
import com.qt.sales.model.BusinessTypeExample;
import com.qt.sales.model.FansAgency;
import com.qt.sales.model.FansAgencyExample;
import com.qt.sales.model.FansAgencyScale;
import com.qt.sales.model.FansAgencyScaleExample;
import com.qt.sales.service.FansAgencyScaleService;
import com.qt.sales.service.FansAgencyService;
import com.qt.sales.utils.DateUtil;
import com.qt.sales.utils.PropertyPlaceholderConfigurerExt;
import com.qt.sales.web.AjaxReturnInfo;

/** 
 * 类名: FansAgencyServiceImpl <br/> 
 * 创建者: zhangyinghui. <br/> 
 * 添加时间: 2016年10月21日 下午1:55:44 <br/> 
 * 版本： JDK 1.6 sales 1.0
 */
@Service("fansAgencyService") 
public class FansAgencyServiceImpl implements FansAgencyService {

    /**
     * dao层
     */
    @Resource
    private FansAgencyMapper fansAgencyMapper;
    
    /**
     * Dao层
     */
    @Resource
    private FansAgencyScaleMapper fansAgencyScaleMapper;
    
    /**
     *分销商经营模式 
     */
    @Resource
    private FansAgencyScaleService fansAgencyScaleService;
    
    
    
    @Override
    public int countByExample(FansAgencyExample example)throws Exception {
        // TODO Auto-generated method stub
        return fansAgencyMapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String agencyId)throws Exception {
        // TODO Auto-generated method stub
        return fansAgencyMapper.deleteByPrimaryKey(agencyId);
    }

    @Override
    public int insert(FansAgency record)throws Exception {
        // TODO Auto-generated method stub
        return fansAgencyMapper.insert(record);
    }

    @Override
    public List<FansAgency> selectByExample(FansAgencyExample example)throws Exception {
        return fansAgencyMapper.selectByExample(example);
    }

    @Override
    public FansAgency selectByPrimaryKey(String agencyId)throws Exception {
        return fansAgencyMapper.selectByPrimaryKey(agencyId);
    }

    @Override
    public int updateByPrimaryKeySelective(FansAgency record) throws Exception{
        // TODO Auto-generated method stub
        return fansAgencyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FansAgency record)throws Exception {
        // TODO Auto-generated method stub
        return fansAgencyMapper.updateByPrimaryKey(record);
    }
    @Override
    public void updateFansAgencyStatus(FansAgency record) throws Exception {
        // 三级分销业务类型
        BusinessTypeExample be = new BusinessTypeExample();
        com.qt.sales.model.BusinessTypeExample.Criteria cr = be.createCriteria();
        cr.andBusinessScenarioLike("%三级分销%");
        List<BusinessType> busList = fansAgencyScaleService.selectBusinessTypeByExample(be);

        // 已经配置的返佣参数数量
        int count = fansAgencyScaleMapper.queryScaleCountWithAgencyId(record.getAgencyId());
        if (count >= busList.size()) {
            record.setStatus(FlowNodeStatus.waiting_process.getVal());
            fansAgencyMapper.updateByPrimaryKey(record);
        }
    }
    
    @Override
    public JSONObject validateFourElement(String cardNum, String userName, String idCardNum) throws Exception {
        /** 组装发送报文 */
        Map<String, Object> sendData = new HashMap<String, Object>();
        sendData.put("P_TRANCODE", "CV100001");
        // 来源系统
        sendData.put("FRMSYS", "salesPlatform");
        // 银行卡号
        sendData.put("CARDNO", cardNum);
        // 姓名
        sendData.put("ACCTNAME", userName);
        // 身份证号
        sendData.put("IDNO", idCardNum);
        // 3要素
        sendData.put("ELETYPE", "3");
        Properties properties = PropertyPlaceholderConfigurerExt.getProperties();
        if (StringUtils.isEmpty(properties.get("sale.tibco.url"))) {
            throw new QTException("验证失败！找不到队列链接[sale.tibco.url]的配置信息！");
        }
        if (StringUtils.isEmpty(properties.get("sale.tibco.user"))) {
            throw new QTException("验证失败！找不到队列链接[sale.tibco.user]的配置信息！");
        }
        if (StringUtils.isEmpty(properties.get("sale.tibco.password"))) {
            throw new QTException("验证失败！找不到队列链接[sale.tibco.password]的配置信息！");
        }
        if (StringUtils.isEmpty(properties.get("sale.tibco.encode"))) {
            throw new QTException("验证失败！找不到队列链接[sale.tibco.encode]的配置信息！");
        }
        if (StringUtils.isEmpty(properties.get("sale.tibco.sendtcp"))) {
            throw new QTException("验证失败！找不到队列链接[sale.tibco.sendtcp]的配置信息！");
        }
        if (StringUtils.isEmpty(properties.get("sale.tibco.retcp"))) {
            throw new QTException("验证失败！找不到队列链接[sale.tibco.retcp]的配置信息！");
        }
        String url = properties.get("sale.tibco.url").toString();
        String user = properties.get("sale.tibco.user").toString();
        String password = properties.get("sale.tibco.password").toString();
        String encode = properties.get("sale.tibco.encode").toString();
        String sendtcp = properties.get("sale.tibco.sendtcp").toString();
        String retcp = properties.get("sale.tibco.retcp").toString();
        JSONObject receiveJson = null;
        int serverTimeOut = 30000;
//        try {
////            receiveJson = PubTibcoSend.sendCoreInfo(url, encode, user, password, "QueueConnectionFactory", sendtcp, retcp, serverTimeOut, sendData, true);
//        } catch (QTException e) {
//            LogPay.error(e.getMessage(), e);
//            if (receiveJson == null) {
//                receiveJson = new JSONObject();
//            }
//            receiveJson.put("P_MSG_CODE", "99999");
//            receiveJson.put("P_MSG_TEXT", e.getRespMsg());
//        }
        return receiveJson;
    }
    
    @Override
    public AjaxReturnInfo updateAgencyApprove(String agencyId) throws Exception {
        AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
        int bussCount = fansAgencyScaleMapper.selectBussinessTypeCountByAgencyId(agencyId);
        // 三级分销业务类型
        List<BusinessType> busList = fansAgencyScaleService.selectFansBusinessTypeByExample();
        int typeSize = busList.size();

        if (bussCount < typeSize) {
            // 审核失败
            ajaxinfo.setSuccess("false");
            ajaxinfo.setMessage("审核失败!每个业务类型都需要设置分佣参数!");
        } else {
            FansAgency agency = new FansAgency();
            // 机构审核通过
            agency.setAgencyId(agencyId);
            agency.setStatus(FlowNodeStatus.approved.getVal());
            updateByPrimaryKeySelective(agency);
            // 机构参数审核
            List<FansAgencyScale> scaleList = queryNotApprovedScaleByAgencyId(agencyId); // 查询未审核的记录
            for (FansAgencyScale fanScale : scaleList) {
                int count = queryScaleCount(fanScale.getAgencyId(), fanScale.getBusinessType());
                if (count > 1) {
                    FansAgencyScale scale = fansAgencyScaleService.selectMaxBegindateScale(fanScale);
                    if (scale != null) {
                        // 要插入记录的开始日期
                        String begindate = fanScale.getBegindate();
                        String newEndTime = DateUtil.getAddDate(begindate, -1);
                        scale.setEnddate(newEndTime);
                        scale.setAuditStatus(AgencyScaleStatus.approved.getVal());
                        fansAgencyScaleService.updateByPrimaryKey(scale);
                    }
                }
                // 要插入记录的开始日期
                fanScale.setAuditStatus(AgencyScaleStatus.approved.getVal());
                fansAgencyScaleService.updateByPrimaryKey(fanScale);
            }
            ajaxinfo.setSuccess("true");
            ajaxinfo.setMessage("审核成功！");

        }
        return ajaxinfo;
    }
    /**
     * 
     * 【方法名】    : (根据机构Id查询机构参数配比). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月15日 下午1:37:06 .<br/>
     * 【参数】： .<br/>
     * @param agencyId 机构Id
     * @return List<FansAgencyScale> 
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    private List<FansAgencyScale> queryNotApprovedScaleByAgencyId(String agencyId)throws Exception {
        //分佣信息
        FansAgencyScaleExample example = new FansAgencyScaleExample();
        com.qt.sales.model.FansAgencyScaleExample.Criteria cr2 = example.createCriteria();
        cr2.andAgencyIdEqualTo(agencyId);
        cr2.andAuditstatusEqualTo(AgencyScaleStatus.notApproved.getVal());
        List<FansAgencyScale> scaleList = fansAgencyScaleService.selectByExample(example);
        return scaleList;
    }
    /**
     * 
     * 【方法名】    : (查询符合条件的比例数量). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月15日 下午2:41:29 .<br/>
     * 【参数】： .<br/>
     * @param agencyId 分销商Id
     * @param businessType 参数类型
     * @return int 数量
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    private int queryScaleCount(String agencyId, String businessType)throws Exception {
        //分佣信息
        FansAgencyScaleExample example = new FansAgencyScaleExample();
        com.qt.sales.model.FansAgencyScaleExample.Criteria cr2 = example.createCriteria();
        cr2.andAgencyIdEqualTo(agencyId);
        cr2.andBusinessTypeEqualTo(businessType);
        return fansAgencyScaleService.countByExample(example);
    }
    
    @Override
    public AjaxReturnInfo updateAgencyDeniedWithAgency(FansAgency agency) throws Exception {
        AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
        //查询未通过审核的参数列表
        List<FansAgencyScale> scaleList = queryNotApprovedScaleByAgencyId(agency.getAgencyId()); 
        for (FansAgencyScale fansAgencyScale : scaleList) {
            fansAgencyScaleService.deleteByPrimaryKey(fansAgencyScale.getId());
        }
        agency.setStatus(FlowNodeStatus.denied.getVal());
        fansAgencyMapper.updateByPrimaryKeySelective(agency);
        ajaxinfo.setSuccess("true");
        ajaxinfo.setMessage("审核驳回成功!");
        return ajaxinfo;
    } 
    
}

