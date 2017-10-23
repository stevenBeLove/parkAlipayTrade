package com.qt.sales.common.excel;

import java.io.Serializable;

public class ColumnVarBean implements Serializable {
    private static final long serialVersionUID = 8989228426708214373L;
    /**
     * Model中的属性名
     */
    private String            modelAttrName;
    /**
     * Excel中的变量名
     */
    private String            colAttrName;
    /**
     * 保存至Model中的默认值
     */
    private String            defaultVal;
    /**
     * 对应的列类型（在保存至Model中需要做数据转换和验证）
     */
    private String            columnType;
    /**
     * 是否必须 true:必须，不能为空 ,默认为false
     */
    private boolean           required         = false;
    /**
     * 最大长度,默认为32
     */
    private int               maxlength        = 32;

    /**
     * 是否为扩展属性,默认为false
     */
    private boolean           isExt            = false;

    /**
     * 是否忽略此字段
     */
    private boolean           ignore           = false;

    public boolean isExt() {
        return isExt;
    }

    public void setExt(boolean isExt) {
        this.isExt = isExt;
    }

    public String getModelAttrName() {
        return modelAttrName;
    }

    public void setModelAttrName(String modelAttrName) {
        this.modelAttrName = modelAttrName;
    }

    public String getColAttrName() {
        return colAttrName;
    }

    public void setColAttrName(String colAttrName) {
        this.colAttrName = colAttrName;
    }

    public String getDefaultVal() {
        return defaultVal;
    }

    public void setDefaultVal(String defaultVal) {
        this.defaultVal = defaultVal;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public int getMaxlength() {
        return maxlength;
    }

    public void setMaxlength(int maxlength) {
        this.maxlength = maxlength;
    }

    public void setIgnore(boolean ignore) {
        this.ignore = ignore;
    }

    public boolean isIgnore() {
        return ignore;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return columnType .<br/>
     */
    public String getColumnType() {
        return columnType;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月9日 下午3:11:59 <br/>
     * 参数: @param  columnType 设置值.  <br/>
     */
    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }
    

}
