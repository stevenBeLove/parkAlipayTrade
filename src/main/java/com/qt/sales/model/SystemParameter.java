package com.qt.sales.model;
/**
 * 
 * <pre>
 * 【类型】: SystemParameter <br/> 
 * 【作用】: 系统参数实体类. <br/>  
 * 【时间】：2016年11月7日 上午11:56:36 <br/> 
 * 【作者】：fuyu <br/> 
 * </pre>
 */
public class SystemParameter {
    /**
     * id
     */
    private int    id;
    /**
     * 系统编码
     */
    private String parNo;

    /**
     * 系统参数最大值
     */
    private int    parMin;

    /**
     * 系统参数最小值
     */
    private int    parMax;

    /**
     * 系统参数名称
     */
    private String parName;

    /**
     * 系统参数说明
     */
    private String parRemark;

    /**
     * 系统参数状态
     */
    private String status;

    /**
     * 系统创建日期
     */
    private String createDate;

    /**
     * 页面开始
     */
    private int    start;

    /**
     * 页面结束
     */
    private int    end;

    /**
     * 方法名： getParNo.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月4日.<br/>
     * 创建时间：下午2:31:27.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public String getParNo() {
        return parNo;
    }

    /**
     * 方法名： setParNo.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param parNo 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月4日.<br/>
     * 创建时间：下午2:31:27.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setParNo(String parNo) {
        this.parNo = parNo;
    }

    /**
     * 方法名： getStart.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月4日.<br/>
     * 创建时间：上午11:41:35.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public int getStart() {
        return start;
    }

    /**
     * 方法名： setStart.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param start 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月4日.<br/>
     * 创建时间：上午11:41:35.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * 方法名： getEnd.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月4日.<br/>
     * 创建时间：上午11:41:35.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public int getEnd() {
        return end;
    }

    /**
     * 方法名： getId.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月4日.<br/>
     * 创建时间：下午2:49:39.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public int getId() {
        return id;
    }

    /**
     * 方法名： setId.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param id 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月4日.<br/>
     * 创建时间：下午2:49:39.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 方法名： getParMin.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月4日.<br/>
     * 创建时间：下午2:09:34.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public int getParMin() {
        return parMin;
    }

    /**
     * 方法名： setParMin.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param parMin 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月4日.<br/>
     * 创建时间：下午2:09:34.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setParMin(int parMin) {
        this.parMin = parMin;
    }

    /**
     * 方法名： getParMax.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月4日.<br/>
     * 创建时间：下午2:09:34.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public int getParMax() {
        return parMax;
    }

    /**
     * 方法名： setParMax.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param parMax 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月4日.<br/>
     * 创建时间：下午2:09:34.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setParMax(int parMax) {
        this.parMax = parMax;
    }

    /**
     * 方法名： getParName.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月4日.<br/>
     * 创建时间：下午12:16:23.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public String getParName() {
        return parName;
    }

    /**
     * 方法名： setParName.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param parName 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月4日.<br/>
     * 创建时间：下午12:16:23.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setParName(String parName) {
        this.parName = parName;
    }

    /**
     * 方法名： getParRemark.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月4日.<br/>
     * 创建时间：下午12:16:23.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public String getParRemark() {
        return parRemark;
    }

    /**
     * 方法名： setParRemark.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param parRemark 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月4日.<br/>
     * 创建时间：下午12:16:23.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setParRemark(String parRemark) {
        this.parRemark = parRemark;
    }

    /**
     * 方法名： getStatus.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月4日.<br/>
     * 创建时间：下午12:16:23.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public String getStatus() {
        return status;
    }

    /**
     * 方法名： setStatus.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param status 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月4日.<br/>
     * 创建时间：下午12:16:23.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 方法名： getCreateDate.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月4日.<br/>
     * 创建时间：下午1:35:09.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * 方法名： setCreateDate.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param createDate 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月4日.<br/>
     * 创建时间：下午1:35:09.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * 方法名： setEnd.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param end 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月4日.<br/>
     * 创建时间：下午12:16:23.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setEnd(int end) {
        this.end = end;
    }

}