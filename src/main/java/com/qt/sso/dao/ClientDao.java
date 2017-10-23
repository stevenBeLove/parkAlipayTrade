package com.qt.sso.dao;

import java.util.List;

import com.qt.sso.entity.Client;

/**
 * 
 * <pre>
 * 【类型】: ClientDao <br/> 
 * 【时间】：2016年12月30日 下午6:26:19 <br/> 
 * 【作者】：yinghui zhang <br/>
 * </pre>
 */
public interface ClientDao {

    /**
     * 【方法名】    : (创建客户端). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年12月30日 下午6:26:37 .<br/>
     * 【参数】：@param  param 设置值.  <br/>
     * @param client
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: yinghui zhang 修改描述：创建新方法 .<br/>
     * <p/>
     */
    public Client createClient(Client client);

    public Client updateClient(Client client);

    public void deleteClient(Long clientId);

    Client findOne(Long clientId);

    List<Client> findAll();

    Client findByClientId(String clientId);

    Client findByClientSecret(String clientSecret);
    
    public List<Client> findAllByClientids(String clientIds);

}
