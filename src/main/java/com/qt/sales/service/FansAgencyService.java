/** 
 * 包名: package com.qt.sales.service; <br/> 
 * 添加时间: 2016年10月21日 下午1:53:35 <br/> 
 */
package com.qt.sales.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.qt.sales.model.FansAgency;
import com.qt.sales.model.FansAgencyExample;
import com.qt.sales.web.AjaxReturnInfo;

/**
 * 类名: FansAgencyService <br/>
 * 作用：TODO(分销商接口)<br/>
 * 创建者: zhangyinghui. <br/>
 * 添加时间: 2016年10月21日 下午1:53:35 <br/>
 * 版本： JDK 1.6 sales 1.0
 */
public interface FansAgencyService {

    /**
     * 根据条件查询记录数量
     * @param example 实体类
     * @return 数量
     * @throws Exception 异常
      */
    public int countByExample(FansAgencyExample example) throws Exception;

    /**
     * 根据主键删除记录
     * @param agencyId 主键
     * @return 影响记录数
     * @throws Exception 异常
     */
    public int deleteByPrimaryKey(String agencyId) throws Exception;

    /**
     * 插入记录
     * @param record 实体对象
     * @return 影响的记录数
     * @throws Exception 异常
     */
    public int insert(FansAgency record) throws Exception;

    
    /**
     * 根据对象查询
     * @param example 条件对象
     * @return List
     * @throws Exception 异常
     */
    public List<FansAgency> selectByExample(FansAgencyExample example) throws Exception;

    /**
     * 根据主键查询
     * @param agencyId 主键
     * @return 实体
     * @throws Exception 异常
     */
    public FansAgency selectByPrimaryKey(String agencyId) throws Exception;
    
    /**
     *根据主键更新记录 
     * @param record 实体
     * @return 影响记录数
     * @throws Exception 异常
     */
    public int updateByPrimaryKeySelective(FansAgency record) throws Exception;

    /**
     * 
     * 【方法名】    : (更新FansAgency对象). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年10月28日 下午7:03:22 .<br/>
     * 【参数】： .<br/>
     * @param record FansAgency
     * @return int
     * @throws Exception 异常.<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public int updateByPrimaryKey(FansAgency record) throws Exception;
    
    /**
     * 
     * 【方法名】    : (更新状态标识). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月11日 下午2:38:31 .<br/>
     * 【参数】： .<br/>
     * @param record FansAgency对象
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public void updateFansAgencyStatus(FansAgency record)throws Exception;
    
    
    /**
     * 
     * 【方法名】    : (验证三要素). <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月3日 下午4:33:12 .<br/>
     * 【参数】：@param cardNum  银行卡号.<br/>
     * @param userName  姓名.<br/>
     * @param idCardNum  身份证号.<br/>
     * @return .<br/>
     * @throws Exception
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * 验证成功：{"P_MSG_CODE":"0000","P_MSG_TEXT":"验证成功","VERFLAG":"0"}
     * 非法卡号：{"P_MSG_CODE":"9108","P_MSG_TEXT":"非法卡号"}
     * 四要素不匹配：{"P_MSG_CODE":"9941","P_MSG_TEXT":"四要素不匹配","VERFLAG":"1"}
     * 
     * <p/>
     */
    public JSONObject validateFourElement(String cardNum, String userName, String idCardNum)throws Exception;
    
    /**
     * 
     * 【方法名】 : (审核通过). <br/>
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月15日 上午9:53:29 .<br/>
     * 【参数】： .<br/>
     * 
     * @param agencyId 机构Id
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: yinghui zhang 修改描述： .<br/>
     *         <p/>
     * @throws Exception Exception异常
     */
    public AjaxReturnInfo updateAgencyApprove(String agencyId) throws Exception;
    /**
     * 
     * 【方法名】    : (审核驳回). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月15日 下午1:58:32 .<br/>
     * 【参数】： .<br/>
     * @param agency 机构实体
     * @return AjaxReturnInfo
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public AjaxReturnInfo updateAgencyDeniedWithAgency(FansAgency agency) throws Exception;
}
