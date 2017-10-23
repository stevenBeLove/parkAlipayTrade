/** 
 * 包名: package com.qt.sales.service.impl; <br/> 
 * 添加时间: 2016年10月27日 下午3:23:14 <br/> 
 */
package com.qt.sales.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.qt.sales.common.CommonEnums.AgencyScaleStatus;
import com.qt.sales.common.CommonEnums.FlowNodeStatus;
import com.qt.sales.dao.BusinessTypeMapper;
import com.qt.sales.dao.FansAgencyScaleMapper;
import com.qt.sales.exception.QTException;
import com.qt.sales.model.BusinessType;
import com.qt.sales.model.BusinessTypeExample;
import com.qt.sales.model.FansAgency;
import com.qt.sales.model.FansAgencyScale;
import com.qt.sales.model.FansAgencyScaleExample;
import com.qt.sales.service.FansAgencyScaleService;
import com.qt.sales.service.FansAgencyService;
import com.qt.sales.utils.DateUtil;
import com.qt.sales.web.AjaxReturnInfo;

/** 
 * 类名: FansAgencyScaleServiceImpl <br/> 
 * 作用：TODO(分销商经营模式Service)<br/> 
 * 创建者: zhangyinghui. <br/> 
 * 添加时间: 2016年10月27日 下午3:23:14 <br/> 
 * 版本： JDK 1.6 SalesPlatform 1.0
 */
@Service("fansAgencyScaleService")
public class FansAgencyScaleServiceImpl implements FansAgencyScaleService {

    
    /**
     * 注入Dao
     */
    @Resource
    private FansAgencyScaleMapper fansAgencyScaleMapper;
    
    /**
     * 分销商服务层
     */
    @Resource
    private FansAgencyService fansAgencyService;
    
    /**
     * 业务类型
     */
    @Resource
    private BusinessTypeMapper businessTypeMapper;
    
    @Override
    public int countByExample(FansAgencyScaleExample example) throws Exception {
        return fansAgencyScaleMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(FansAgencyScaleExample example)throws Exception {
        return fansAgencyScaleMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id)throws Exception {
        return fansAgencyScaleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FansAgencyScale record) throws Exception {
        record.setAuditStatus(AgencyScaleStatus.notApproved.getVal());
        return fansAgencyScaleMapper.insert(record);
    }

    @Override
    public int insertSelective(FansAgencyScale record)throws Exception {
        // TODO Auto-generated method stub
        return fansAgencyScaleMapper.insertSelective(record);
    }

    @Override
    public List<FansAgencyScale> selectByExample(FansAgencyScaleExample example)throws Exception {
        // TODO Auto-generated method stub
        return fansAgencyScaleMapper.selectByExample(example);
    }

    @Override
    public FansAgencyScale selectByPrimaryKey(String id)throws Exception {
        // TODO Auto-generated method stub
        return fansAgencyScaleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(FansAgencyScale record, FansAgencyScaleExample example)throws Exception {
        return fansAgencyScaleMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(FansAgencyScale record, FansAgencyScaleExample example)throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(FansAgencyScale record)throws Exception {
        return fansAgencyScaleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FansAgencyScale record)throws Exception {
        return fansAgencyScaleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BusinessType> selectBusinessTypeByExample(BusinessTypeExample example)throws Exception {
        return businessTypeMapper.selectByExample(example);
    }

    @Override
    public List<BusinessType> selectFansBusinessTypeByExample()throws Exception {
        BusinessTypeExample be = new BusinessTypeExample();
        com.qt.sales.model.BusinessTypeExample.Criteria cr = be.createCriteria();
        cr.andBusinessScenarioLike("%三级分销%");
        List<BusinessType> busList = businessTypeMapper.selectByExample(be);
        return busList;
    } 
    
    @Override
    public FansAgencyScale selectMaxBegindateScale(FansAgencyScale record) throws Exception {
        return fansAgencyScaleMapper.selectMaxBegindateScale(record);
    }

    @Override
    public int updateEndTimesetNull(FansAgencyScale record) throws Exception {
        return fansAgencyScaleMapper.updateEndTimesetNull(record);
    }
    
    
    @Override
    public AjaxReturnInfo deleteFansAgencyScale(String scaleId) throws Exception {
        AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
        FansAgencyScale scale = fansAgencyScaleMapper.selectByPrimaryKey(scaleId);
        FansAgencyScaleExample example = new FansAgencyScaleExample();
        com.qt.sales.model.FansAgencyScaleExample.Criteria cr = example.createCriteria();
        cr.andAgencyIdEqualTo(scale.getAgencyId());
        cr.andBusinessTypeEqualTo(scale.getBusinessType());
        int count = countByExample(example);
        // 首先判断是否已经生效
        String endTime = scale.getEnddate();
        if (!StringUtils.isEmpty(endTime) && DateUtil.compareBefore(endTime)) {
            ajaxinfo.setSuccess("false");
            ajaxinfo.setMessage("已经生效,不允许删除！");
        } else if (count <= 1) {
            ajaxinfo.setSuccess("false");
            ajaxinfo.setMessage("必须保留一个不同类型的交易类型！");
            scale.setEnddate(null);
            updateByPrimaryKey(scale);
        } else {
            // 更新结束日期最大值为空
            FansAgencyScale endDateMaxscale = fansAgencyScaleMapper.selectMaxEndDateScale(scale);
            if (!StringUtils.isEmpty(endDateMaxscale)) {
                endDateMaxscale.setEnddate(null);
                updateByPrimaryKey(endDateMaxscale);
            }
            deleteByPrimaryKey(scaleId);
            //更新状态为待审核
            FansAgency agency = fansAgencyService.selectByPrimaryKey(scale.getAgencyId());
            if (!StringUtils.isEmpty(agency)){
                agency.setStatus(FlowNodeStatus.waiting_process.getVal());
                fansAgencyService.updateByPrimaryKey(agency);
            }
            ajaxinfo.setSuccess("true");
            ajaxinfo.setMessage("删除成功！");
        }
        return ajaxinfo;
    }
    
    @Override
    public void compareMycost(FansAgencyScale agencyScale) throws Exception {
        // 分销商
        FansAgency fansAgency = fansAgencyService.selectByPrimaryKey(agencyScale.getAgencyId());
        Long myCost = agencyScale.getMycost();
        // 上级分销商
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("agencyId", fansAgency.getParentId() == null ? "" : fansAgency.getParentId());
        map.put("businessType", agencyScale.getBusinessType());
        FansAgencyScale scale = fansAgencyScaleMapper.selectParentScale(map);
        if (!StringUtils.isEmpty(scale)) {
            Long parentMycost = scale.getMycost();
            if (myCost > parentMycost) {
                throw new QTException("添加失败!&nbsp;[" + agencyScale.getBusinessName() + "]&nbsp;起始分佣比不能大于上级机构!");
            }
        }
    }

}

