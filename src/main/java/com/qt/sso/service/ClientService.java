package com.qt.sso.service;

import java.util.List;

import com.qt.sso.entity.Client;

/**
 * <pre>
 * 【类型】: ClientService <br/> 
 * 【时间】：2016年12月30日 下午6:31:10 <br/> 
 * 【作者】：yinghui zhang <br/>
 * </pre>
 */
public interface ClientService {

    public Client createClient(Client client);

    public Client updateClient(Client client);

    public void deleteClient(Long clientId);

    Client findOne(Long clientId);

    List<Client> findAll();
    
    List<Client> findByClients(String clients);

    Client findByClientId(String clientId);

    Client findByClientSecret(String clientSecret);

}
