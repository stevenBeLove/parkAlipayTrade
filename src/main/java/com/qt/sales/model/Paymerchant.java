package com.qt.sales.model;

import java.math.BigDecimal;

public class Paymerchant {
    private String merchantid;

    private String appId;

    private String appAuthToken;

    private String userId;

    private String authAppId;

    private BigDecimal expiresIn;

    private BigDecimal reExpiresIn;

    private String redirectUri;

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid == null ? null : merchantid.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getAppAuthToken() {
        return appAuthToken;
    }

    public void setAppAuthToken(String appAuthToken) {
        this.appAuthToken = appAuthToken == null ? null : appAuthToken.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getAuthAppId() {
        return authAppId;
    }

    public void setAuthAppId(String authAppId) {
        this.authAppId = authAppId == null ? null : authAppId.trim();
    }

    public BigDecimal getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(BigDecimal expiresIn) {
        this.expiresIn = expiresIn;
    }

    public BigDecimal getReExpiresIn() {
        return reExpiresIn;
    }

    public void setReExpiresIn(BigDecimal reExpiresIn) {
        this.reExpiresIn = reExpiresIn;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri == null ? null : redirectUri.trim();
    }
}