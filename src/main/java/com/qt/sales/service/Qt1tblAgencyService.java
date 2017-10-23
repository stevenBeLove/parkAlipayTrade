/** 
 * 包名: package com.qt.sales.service; <br/> 
 * 添加时间: 2016年10月24日 上午11:17:39 <br/> 
 */
package com.qt.sales.service;

import java.util.List;

import com.qt.sales.model.Qt1tblAgency;
import com.qt.sales.model.Qt1tblAgencyExample;

/**
 * 类名: Qt1tblAgency <br/>
 * 作用：TODO(简单一句话描述)<br/>
 * 创建者: zhangyinghui. <br/>
 * 添加时间: 2016年10月24日 上午11:17:39 <br/>
 * 版本： JDK 1.6 sales 1.0
 */
public interface Qt1tblAgencyService {

    /**
     * 
     * 【方法名】 : (根据条件查询列表). <br/>
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年10月31日 上午11:53:02 .<br/>
     * 【参数】： .<br/>
     * 
     * @param example Qt1tblAgencyExample
     * @return int
     * @throws Exception .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: yinghui zhang 修改描述： .<br/>
     *         <p/>
     */
    public int countByExample(Qt1tblAgencyExample example) throws Exception;

    /**
     * 
     * 【方法名】 : (添加数据方法). <br/>
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年10月31日 上午11:54:18 .<br/>
     * 【参数】： .<br/>
     * 
     * @param record
     *            Qt1tblAgency
     * @return int
     * @throws Exception
     *             Exception.<br/>
     *             <p>
     *             修改记录.<br/>
     *             修改人: yinghui zhang 修改描述： .<br/>
     *             <p/>
     */
    public int insert(Qt1tblAgency record) throws Exception;

    /**
     * 
     * 【方法名】 : (根据条件添加方法). <br/>
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年10月31日 上午11:55:09 .<br/>
     * 【参数】： .<br/>
     * 
     * @param record
     *            Qt1tblAgency
     * @return int
     * @throws Exception
     *             Exception.<br/>
     *             <p>
     *             修改记录.<br/>
     *             修改人: yinghui zhang 修改描述： .<br/>
     *             <p/>
     */
    public int insertSelective(Qt1tblAgency record) throws Exception;

    /**
     * 
     * 【方法名】 : (根据条件查询列表). <br/>
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年10月31日 上午11:55:55 .<br/>
     * 【参数】： .<br/>
     * 
     * @param example
     *            条件对象
     * @return List<Qt1tblAgency>
     * @throws Exception
     *             Exception.<br/>
     *             <p>
     *             修改记录.<br/>
     *             修改人: yinghui zhang 修改描述： .<br/>
     *             <p/>
     */
    public List<Qt1tblAgency> selectByExample(Qt1tblAgencyExample example) throws Exception;

    /**
     * 
     * 【方法名】 : (更新Qt1tblAgency对象). <br/>
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年10月31日 上午11:51:15 .<br/>
     * 【参数】： .<br/>
     * 
     * @param record
     *            Qt1tblAgency
     * @return int
     * @throws Exception
     *             Exception.<br/>
     *             <p>
     *             修改记录.<br/>
     *             修改人: yinghui zhang 修改描述： .<br/>
     *             <p/>
     */
    public int updateByPrimaryKeySelective(Qt1tblAgency record) throws Exception;

    /**
     * 
     * 【方法名】 : (更新老机构信息). <br/>
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年10月31日 上午11:49:07 .<br/>
     * 【参数】： .<br/>
     * 
     * @throws Exception
     *             异常
     * @param record
     *            Qt1tblAgency
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: yinghui zhang 修改描述： .<br/>
     *         <p/>
     */
    public int updateByPrimaryKey(Qt1tblAgency record) throws Exception;

    /**
     * 根据主键查询
     * 
     * @param agencyId
     *            主键
     * @return 实体
     * @throws Exception
     *             异常
     */
    public Qt1tblAgency selectByPrimaryKey(String agencyId) throws Exception;
}
