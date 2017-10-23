/** 
 * 包名: package com.qt.sales.service; <br/> 
 * 添加时间: 2016年10月27日 下午4:24:32 <br/> 
 */
package com.qt.sales.service;

import java.util.List;

import com.qt.sales.model.Announcement;
import com.qt.sales.model.AnnouncementExample;

/**
 * 
 * <pre>
 * 【类型】: AnnouncementService <br/> 
 * 【作用】:系统公告发送业务逻辑接口层 <br/>  
 * 【时间】：2016年11月7日 上午9:56:13 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
public interface AnnouncementService {
    /**
     * 
     * 【方法名】 : 查询系统公告数量. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午9:56:44 .<br/>
     * 【参数】： .<br/>
     * 
     * @param example 
     * @return example 
     * @throws Exception .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    int countByExample(AnnouncementExample example) throws Exception;

    /**
     * 
     * 【方法名】 : 查询系统公告List. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午9:57:28 .<br/>
     * 【参数】： .<br/>
     * 
     * @param example 
     * @return example 
     * @throws Exception .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    List<Announcement> selectByExample(AnnouncementExample example) throws Exception;

    /**
     * 
     * 【方法名】 : 系统公告新增. <br/>
     * 【注意】: 返回int类型.<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午9:57:58 .<br/>
     * 【参数】： .<br/>
     * 
     * @param record 
     * @return record 
     * @throws Exception .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    int insert(Announcement record) throws Exception;

    /**
     * 
     * 【方法名】 : 修改公告内容. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午9:58:38 .<br/>
     * 【参数】： .<br/>
     * 
     * @param record 
     * @return record 
     * @throws Exception .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    int updateByPrimaryKeySelective(Announcement record) throws Exception;

    /**
     * 
     * 【方法名】 :删除公告. <br/>
     * 【注意】: 返回int类型.<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午9:59:16 .<br/>
     * 【参数】： .<br/>
     * 
     * @param id 
     * @return id 
     * @throws Exception .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    int deleteByPrimaryKey(String id) throws Exception;

    /**
     * 
     * 【方法名】 :查询系统公告对象. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午9:59:40 .<br/>
     * 【参数】： .<br/>
     * 
     * @param id 
     * @return id 
     * @throws Exception .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    Announcement selectByPrimaryKey(String id) throws Exception;
}
