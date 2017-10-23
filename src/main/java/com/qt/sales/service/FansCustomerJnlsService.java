/** 
 * 包名: package com.qt.sales.service; <br/> 
 * 添加时间: 2016年10月31日 上午10:51:43 <br/> 
 */
package com.qt.sales.service;

import java.util.List;

import com.qt.sales.model.BusinessType;
import com.qt.sales.model.BusinessTypeExample;
import com.qt.sales.model.FansCustomerJnls;

/**
 * 
 * <pre>
 * 【类型】: FansCustomerJnlsService <br/> 
 * 【作用】:交易流水接口层<br/>  
 * 【时间】：2016年11月7日 上午10:27:06 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
public interface FansCustomerJnlsService {

    /**
     * 
     * 【方法名】 : 查询APP用户List. <br/>
     * 【注意】:返回List类型<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午10:27:53 .<br/>
     * 【参数】： .<br/>
     * 
     * @param example 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    List<BusinessType> selectByExample(BusinessTypeExample example);

    /**
     * 
     * 【方法名】 : 查询交易流水List. <br/>
     * 【注意】: 返回List类型.<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午10:28:25 .<br/>
     * 【参数】： .<br/>
     * 
     * @param fansCustomerJnls 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    List<FansCustomerJnls> getFansCustomerJnlsList(FansCustomerJnls fansCustomerJnls);

    /**
     * 
     * 【方法名】 : 查询交易流水数量. <br/>
     * 【注意】: 返回int类型.<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午10:28:57 .<br/>
     * 【参数】： .<br/>
     * 
     * @param fansCustomerJnls 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    int fansCustomerJnlsCount(FansCustomerJnls fansCustomerJnls);
}
