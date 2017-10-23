/** 
 * 包名: package com.qt.sales.service; <br/> 
 * 添加时间: 2016年11月1日 上午11:28:55 <br/> 
 */
package com.qt.sales.service;

import java.util.List;

import com.qt.sales.model.PersonalCommissionVO;

/**
 * 
 * <pre>
 * 【类型】: PersonalCommissionService <br/> 
 * 【作用】: 个人返佣业务逻辑接口类. <br/>  
 * 【时间】：2016年11月7日 上午11:03:51 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
public interface PersonalCommissionService {
    /**
     * 
     * 【方法名】 : 查询个人返佣记录数量. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:04:16 .<br/>
     * 【参数】： .<br/>
     * 
     * @param personalCommissionVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    int PersonalCommissionCount(PersonalCommissionVO personalCommissionVO);

    /**
     * 
     * 【方法名】 : 查询个人返佣List. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:04:38 .<br/>
     * 【参数】： .<br/>
     * 
     * @param personalCommissionVO 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    List<PersonalCommissionVO> getPersonalCommissionList(PersonalCommissionVO personalCommissionVO);


}
