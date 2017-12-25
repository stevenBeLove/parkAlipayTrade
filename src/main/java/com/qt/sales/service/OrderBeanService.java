package com.qt.sales.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.qt.sales.exception.QTException;
import com.qt.sales.model.OrderBean;
import com.qt.sales.model.OrderBeanExample;

public interface OrderBeanService {
	 int countByExample(OrderBeanExample example);

	    int deleteByExample(OrderBeanExample example);

	    int deleteByPrimaryKey(String orderNo);

	    int insert(OrderBean record);

	    List<OrderBean> selectByExample(OrderBeanExample example);

	    OrderBean selectByPrimaryKey(String orderNo);

	    int updateByExampleSelective(@Param("record") OrderBean record, @Param("example") OrderBeanExample example);

	    int updateByExample(@Param("record") OrderBean record, @Param("example") OrderBeanExample example);

	    int updateByPrimaryKeySelective(OrderBean record);

	    int updateByPrimaryKey(OrderBean record);
	    
	    /**
	     *查询已经支付的金额
	     * @param outOrderNo
	     * @return
	     */
	    String queryPaidMoneyWithOrderNo(String outOrderNo);
	    
	    
	    /**
	     * 临时订单表已经支付的金额
	     * @param orderTrade
	     * @return
	     */
	    String queryTempPaidWithOrderTrade(String orderTrade);
	    
	    /**
	     * 【方法名】    : (查询已交费用). <br/> 
	     * 【作者】: yinghui zhang .<br/>
	     * 【时间】： 2017年12月16日 下午8:45:21 .<br/>
	     * 【参数】： .<br/>
	     * @return .<br/>
	     * <p>
	     * 修改记录.<br/>
	     * 修改人:  yinghui zhang 修改描述： .<br/>
	     * <p/>
	     */
	    String queryPaidWithCarNumber(String carNumber);
	    
	    /**
	     * 根据订单ID获取订单
	     * 【方法名】    : (这里用一句话描述这个方法的作用). <br/> 
	     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
	     * 【作者】: yinghui zhang .<br/>
	     * 【时间】： 2017年11月10日 下午2:50:05 .<br/>
	     * 【参数】： .<br/>
	     * @param orderNo
	     * @return .<br/>
	     * <p>
	     * 修改记录.<br/>
	     * 修改人:  yinghui zhang 修改描述： .<br/>
	     * <p/>
	     */
	    OrderBean selectByOrderNo(String orderNo);
	    /**
	     * 同步订单表
	     * @param record
	     * @return
	     */
	    int insertFromOrder(OrderBean record);
	    /**
	     * 更新订单
	     * @param record
	     * @return
	     */
	    int updateOrderPayByOrderNo(OrderBean record);
	    
	    /**
	     * 【方法名】    : (退单接口). <br/> 
	     * 【作者】: yinghui zhang .<br/>
	     * 【时间】： 2017年11月15日 下午2:29:05 .<br/>
	     * 【参数】： .<br/>
	     * @param orderNo
	     * @return .<br/>
	     * <p>
	     * 修改记录.<br/>
	     * 修改人:  yinghui zhang 修改描述： .<br/>
	     * <p/>
	     */
	    public OrderBean selectPayOrderByOrderNo(String orderNo);
	    /**
	     * 删除订单
	     * @param orderTrade
	     * @return
	     */
	    int deleteWithOrderTrade(String orderTrade);
	    
	    /**
	     * 免密状态变更
	     * @param params
	     * @throws QTException
	     */
	    public void updateAgreementNotify(Map<String, String> params) throws QTException;
	    
	    /**
	     * 查询支付订单数量
	     * @param orderNo
	     * @return
	     */
	    public Integer queryOrderPayCountByOrderNo(String outOrderNo);
}
