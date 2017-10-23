/** 
 * 包名: package com.qt.sales.common; <br/> 
 * 添加时间: 2016年10月31日 下午7:54:34 <br/> 
 */
package com.qt.sales.common;

/**
 * 类名: CommonEnums <br/>
 * 作用：TODO(Enum类)<br/>
 * 创建者: zhangyinghui. <br/>
 * 添加时间: 2016年10月31日 下午7:54:34 <br/>
 * 版本： JDK 1.6 SalesPlatform 1.0
 */
public class CommonEnums {

    /**
     * 
     * <pre>
     * 【类型】: FlowNodeStatus <br/> 
     * 【作用】: 审批流程. <br/>  
     * 【时间】：2016年10月31日 下午7:56:39 <br/> 
     * 【作者】：yinghui zhang <br/>
     * </pre>
     */
    public enum FlowNodeStatus {
        /**
         * 审核通过
         */
        approved("00"),

        /**
         * 待审核
         */
        waiting_process("01"),
        /**
         * 待配置参数
         */
        waiting_configure("02"),
        /**
         * 审核驳回
         */
        denied("03");

        /**
         * 值
         */
        private String val;

        /**
         * 
         * 【方法名】 : (这里用一句话描述这个方法的作用). <br/>
         * 【作者】: yinghui zhang .<br/>
         * 【时间】： 2016年11月3日 下午7:17:27 .<br/>
         * 【参数】：@val key值 .<br/>
         * 
         * @param val
         *            .<br/>
         *            <p>
         *            修改记录.<br/>
         *            修改人: yinghui zhang 修改描述： .<br/>
         *            <p/>
         */
        private FlowNodeStatus(String val) {
            this.val = val;
        }

        /**
         * 
         * 【方法名】    : (获取方法). <br/> 
         * 【作者】: yinghui zhang .<br/>
         * 【时间】： 2016年11月3日 下午7:18:08 .<br/>
         * 【参数】： .<br/>
         * @return .<br/>
         * <p>
         * 修改记录.<br/>
         * 修改人:  yinghui zhang 修改描述： .<br/>
         * <p/>
         */
        public String getVal() {
            return val;
        }
    }
    
    /**
     * 
     * <pre>
     * 【类型】: AgencyScaleStatus <br/> 
     * 【作用】: 机构参数审核状态. <br/>  
     * 【时间】：2016年11月15日 上午10:47:27 <br/> 
     * 【作者】：yinghui zhang <br/> 
     * </pre>
     */
    public enum AgencyScaleStatus {
        /**
         * 审核通过
         */
        approved("00"),

        /**
         * 未通过审核
         */
        notApproved("01");

        /**
         * 值
         */
        private String val;

        /**
         * 
         * 【方法名】 : (这里用一句话描述这个方法的作用). <br/>
         * 【作者】: yinghui zhang .<br/>
         * 【时间】： 2016年11月3日 下午7:17:27 .<br/>
         * 【参数】：@val key值 .<br/>
         * 
         * @param val
         *            .<br/>
         *            <p>
         *            修改记录.<br/>
         *            修改人: yinghui zhang 修改描述： .<br/>
         *            <p/>
         */
        private AgencyScaleStatus(String val) {
            this.val = val;
        }

        /**
         * 
         * 【方法名】    : (获取方法). <br/> 
         * 【作者】: yinghui zhang .<br/>
         * 【时间】： 2016年11月3日 下午7:18:08 .<br/>
         * 【参数】： .<br/>
         * @return .<br/>
         * <p>
         * 修改记录.<br/>
         * 修改人:  yinghui zhang 修改描述： .<br/>
         * <p/>
         */
        public String getVal() {
            return val;
        }
    }
    
}
