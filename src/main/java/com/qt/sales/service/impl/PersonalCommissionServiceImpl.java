/** 
 * 包名: package com.qt.sales.service.impl; <br/> 
 * 添加时间: 2016年11月1日 上午11:28:43 <br/> 
 */
package com.qt.sales.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qt.sales.dao.PersonalCommissionMapper;
import com.qt.sales.model.PersonalCommissionVO;
import com.qt.sales.service.PersonalCommissionService;
import com.qt.sales.utils.Format;

/**
 * 
 * <pre>
 * 【类型】: PersonalCommissionServiceImpl <br/> 
 * 【作用】: 个人返佣业务逻辑实现类 <br/>  
 * 【时间】：2016年11月7日 上午11:05:30 <br/> 
 * 【作者】：fuyu <br/> 
 * </pre>
 */
@Service
public class PersonalCommissionServiceImpl implements PersonalCommissionService {

    /**
     * Dao层接口
     */
    @Resource
    private PersonalCommissionMapper personalCommissionMapper;

    @Override
    public int PersonalCommissionCount(PersonalCommissionVO personalCommissionVO) {
        return personalCommissionMapper.PersonalCommissionCount(personalCommissionVO);
    }

    @Override
    public List<PersonalCommissionVO> getPersonalCommissionList(PersonalCommissionVO personalCommissionVO) {
        return personalCommissionMapper.PersonalCommissionList(personalCommissionVO);
    }

}
