/** 
 * 包名: package com.qt.sales.dao; <br/> 
 * 添加时间: 2016年10月31日 下午5:08:16 <br/> 
 */
package com.qt.sales.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import com.qt.sales.dao.sql.FansCustomerJnlsSqlProvider;
import com.qt.sales.model.FansCustomerJnls;

/**
 * 
 * <pre>
 * 【类型】: FansCustomerJnlsMapper <br/> 
 * 【作用】: 交易流水Mapper <br/>  
 * 【时间】：2016年11月7日 上午10:24:50 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
public interface FansCustomerJnlsMapper {

    /**
     * 
     * 【方法名】 : 查询交易流水数量. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午10:25:04 .<br/>
     * 【参数】： .<br/>
     * 
     * @param fansCustomerJnls 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @SelectProvider(type = FansCustomerJnlsSqlProvider.class, method = "queryFansCustomerJnlsCount")
    @ResultType(Integer.class)
    Integer queryFansCustomerJnlsCount(FansCustomerJnls fansCustomerJnls);

    /**
     * 
     * 【方法名】 : 查询交易流水List. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午10:25:35 .<br/>
     * 【参数】： .<br/>
     * 
     * @param fansCustomerJnls 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @SelectProvider(type = FansCustomerJnlsSqlProvider.class, method = "queryFansCustomerJnlsList")
    @ResultType(FansCustomerJnls.class)
    List<FansCustomerJnls> queryAllFansCustomerJnls(FansCustomerJnls fansCustomerJnls);
}
