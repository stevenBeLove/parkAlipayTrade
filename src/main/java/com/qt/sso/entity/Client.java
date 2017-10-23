package com.qt.sso.entity;

import java.io.File;
import java.io.Serializable;

/**
 * <pre>
 * 【类型】: Client <br/> 
 * 【时间】：2016年12月30日 下午6:29:13 <br/> 
 * 【作者】：yinghui zhang <br/>
 * </pre>
 */
public class Client implements Serializable {

    /**
     * Id 
     */
    private Long   id;
    /**
     * 名称
     */
    private String clientName;
    /**
     *clientId 
     */
    private String clientId;
    /**
     *clientSecret
     */
    private String clientSecret;
    /**
     *clientUri 
     */
    private String clientUri;
    
    /**
     * 图标
     */
    private String clientIcon;
    
    /**
     * 文件图片
     */
    private File iconFile;
    

    public String getClientUri() {
        return clientUri;
    }

    public void setClientUri(String clientUri) {
        this.clientUri = clientUri;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Client client = (Client) o;

        if (id != null ? !id.equals(client.id) : client.id != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", clientName='" + clientName + '\'' + ", clientId='" + clientId + '\'' + ", clientSecret='" + clientSecret + '\'' + '}';
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return clientIcon .<br/>
     */
    public String getClientIcon() {
        return clientIcon;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2017年5月22日 上午11:51:43 <br/>
     * 参数: @param  clientIcon 设置值.  <br/>
     */
    public void setClientIcon(String clientIcon) {
        this.clientIcon = clientIcon;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return iconFile .<br/>
     */
    public File getIconFile() {
        return iconFile;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2017年6月12日 上午10:56:39 <br/>
     * 参数: @param  iconFile 设置值.  <br/>
     */
    public void setIconFile(File iconFile) {
        this.iconFile = iconFile;
    }
    
    
}
