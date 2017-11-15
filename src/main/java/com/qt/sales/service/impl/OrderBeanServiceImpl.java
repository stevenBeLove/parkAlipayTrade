package com.qt.sales.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qt.sales.dao.OrderBeanMapper;
import com.qt.sales.model.OrderBean;
import com.qt.sales.model.OrderBeanExample;
import com.qt.sales.service.OrderBeanService;

@Service("orderBeanService")
public class OrderBeanServiceImpl implements OrderBeanService {

	@Resource
	private OrderBeanMapper orderBeanMapper;
	
	@Override
	public int countByExample(OrderBeanExample example) {
		return orderBeanMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(OrderBeanExample example) {
		return orderBeanMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String orderNo) {
		// TODO Auto-generated method stub
		return orderBeanMapper.deleteByPrimaryKey(orderNo);
	}

	@Override
	public int insert(OrderBean record) {
		// TODO Auto-generated method stub
		return orderBeanMapper.insert(record);
	}

	@Override
	public int insertSelective(OrderBean record) {
		// TODO Auto-generated method stub
		return orderBeanMapper.insertSelective(record);
	}

	@Override
	public List<OrderBean> selectByExample(OrderBeanExample example) {
		return orderBeanMapper.selectByExample(example);
	}

	@Override
	public OrderBean selectByPrimaryKey(String orderNo) {
		// TODO Auto-generated method stub
		return orderBeanMapper.selectByPrimaryKey(orderNo);
	}

	@Override
	public int updateByExampleSelective(OrderBean record, OrderBeanExample example) {
		// TODO Auto-generated method stub
		return orderBeanMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(OrderBean record, OrderBeanExample example) {
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(OrderBean record) {
		return orderBeanMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(OrderBean record) {
		return orderBeanMapper.updateByPrimaryKey(record);
	}

	@Override
	public String queryPaidMoneyWithOrderNo(String outOrderNo) {
		return orderBeanMapper.queryPaidMoneyWithOrderNo(outOrderNo);
	}

    @Override
    public OrderBean selectByOrderNo(String orderNo) {
        return orderBeanMapper.selectByOrderNo(orderNo);
    }
    
    @Override
    public OrderBean selectPayOrderByOrderNo(String orderNo) {
        return orderBeanMapper.selectPayOrderByOrderNo(orderNo);
    }
    
    
    @Override
    public int insertFromOrder(OrderBean record){
    	return orderBeanMapper.insertFromOrder(record);
    }

	@Override
	public int updateOrderPayByOrderNo(OrderBean record) {
		return orderBeanMapper.updateOrderPayByOrderNo(record);
	}

}
