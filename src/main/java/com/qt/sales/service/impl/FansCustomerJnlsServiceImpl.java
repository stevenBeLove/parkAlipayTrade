/** 
 * 包名: package com.qt.sales.service.impl; <br/> 
 * 添加时间: 2016年10月31日 上午10:51:13 <br/> 
 */
package com.qt.sales.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qt.sales.dao.BusinessTypeMapper;
import com.qt.sales.dao.FansCustomerJnlsMapper;
import com.qt.sales.model.BusinessType;
import com.qt.sales.model.BusinessTypeExample;
import com.qt.sales.model.FansCustomerJnls;
import com.qt.sales.service.FansCustomerJnlsService;
import com.qt.sales.utils.Format;

/**
 * 
 * <pre>
 * 【类型】: FansCustomerJnlsServiceImpl <br/> 
 * 【作用】: 交易流水业务逻辑实现层. <br/>  
 * 【时间】：2016年11月7日 上午10:26:31 <br/> 
 * 【作者】：fuyu <br/> 
 * </pre>
 */
@Service
public class FansCustomerJnlsServiceImpl implements FansCustomerJnlsService {

    /**
     * Dao层接口
     */
    @Resource
    private FansCustomerJnlsMapper fansCustomerJnlsMapper;
    /**
     * 
     */
    @Resource
    private BusinessTypeMapper     businessTypeMapper;

    @Override
    public int fansCustomerJnlsCount(FansCustomerJnls fansCustomerJnls) {
        return fansCustomerJnlsMapper.queryFansCustomerJnlsCount(fansCustomerJnls);
    }

    @Override
    public List<FansCustomerJnls> getFansCustomerJnlsList(FansCustomerJnls fansCustomerJnls) {
        return fansCustomerJnlsMapper.queryAllFansCustomerJnls(fansCustomerJnls);
    }

    @Override
    public List<BusinessType> selectByExample(BusinessTypeExample example) {
        return businessTypeMapper.selectByExample(example);
    }

}
