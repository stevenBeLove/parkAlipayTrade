package com.qt.sso.dao;

import java.util.List;

import com.qt.sso.entity.User;

/**
 * <pre>
 * 【类型】: UserDao <br/> 
 * 【时间】：2016年12月30日 下午6:28:43 <br/> 
 * 【作者】：yinghui zhang <br/>
 * </pre>
 */
public interface UserDao {

    public User createUser(User user);

    public User updateUser(User user);

    public void deleteUser(Long userId);

    User findOne(Long userId);

    List<User> findAll();

    User findByUsername(String username);

}
