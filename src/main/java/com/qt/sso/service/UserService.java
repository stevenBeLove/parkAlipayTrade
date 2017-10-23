package com.qt.sso.service;

import java.util.List;

import com.qt.sso.entity.User;

/**
 * <pre>
 * 【类型】: UserService <br/> 
 * 【时间】：2016年12月30日 下午7:00:11 <br/> 
 * 【作者】：yinghui zhang <br/>
 * </pre>
 */
public interface UserService {
    /**
     * 创建用户
     * 
     * @param user
     */
    public User createUser(User user);

    public User updateUser(User user);

    public void deleteUser(Long userId);

    /**
     * 修改密码
     * 
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword);

    User findOne(Long userId);

    List<User> findAll();

    /**
     * 根据用户名查找用户
     * 
     * @param username
     * @return
     */
    public User findByUsername(String username);

}
