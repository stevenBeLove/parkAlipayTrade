package com.qt.sso.service;

/**
 * <pre>
 * 【类型】: OAuthService <br/> 
 * 【时间】：2016年12月30日 下午7:00:24 <br/> 
 * 【作者】：yinghui zhang <br/>
 * </pre>
 */
public interface OAuthService {

    // 添加 auth code
    public void addAuthCode(String authCode, String username);

    // 添加 access token
    public void addAccessToken(String accessToken, String username);

    // 验证auth code是否有效
    boolean checkAuthCode(String authCode);

    // 验证access token是否有效
    boolean checkAccessToken(String accessToken);

    String getUsernameByAuthCode(String authCode);

    String getUsernameByAccessToken(String accessToken);

    // auth code / access token 过期时间
    long getExpireIn();

    public boolean checkClientId(String clientId);

    public boolean checkClientSecret(String clientSecret);

}
