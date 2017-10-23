package com.qt.sales.model;
/**
 * 
 * <pre>
 * 【类型】: BusinessType <br/> 
 * 【作用】: 业务类型. <br/>  
 * 【时间】：2016年10月27日 下午5:32:32 <br/> 
 * 【作者】：yinghui zhang <br/> 
 * </pre>
 */
public class BusinessType {
    /**
     * 产品类型编码
     */
    private String businessType;

    /**
     * 产品归类信息名称
     */
    private String businessName;

    /**
     * 产品归类信息描述
     */
    private String businessDesc;

    /**
     * 业务场景
     */
    private String businessScenario;
    

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName == null ? null : businessName.trim();
    }

    public String getBusinessDesc() {
        return businessDesc;
    }

    public void setBusinessDesc(String businessDesc) {
        this.businessDesc = businessDesc == null ? null : businessDesc.trim();
    }

    public String getBusinessScenario() {
        return businessScenario;
    }

    public void setBusinessScenario(String businessScenario) {
        this.businessScenario = businessScenario == null ? null : businessScenario.trim();
    }
}