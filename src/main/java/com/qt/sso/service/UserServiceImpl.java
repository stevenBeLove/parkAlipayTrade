package com.qt.sso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qt.shiro.service.PasswordHelper;
import com.qt.sso.dao.UserDao;
import com.qt.sso.entity.User;

/**
 * <pre>
 * 【类型】: UserServiceImpl <br/> 
 * 【时间】：2016年12月30日 下午6:35:45 <br/> 
 * 【作者】：yinghui zhang <br/> 
 * </pre>
 */
@Transactional
@Service("userServiceAuth")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private PasswordHelper passwordHelper;

    /**
     * 创建用户
     * @param user
     */
    public User createUser(User user) {
        //加密密码
//        passwordHelper.encryptPassword(user);
        return userDao.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userDao.deleteUser(userId);
    }

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword) {
        User user =userDao.findOne(userId);
        user.setPassword(newPassword);
//        passwordHelper.encryptPassword(user);
        userDao.updateUser(user);
    }

    @Override
    public User findOne(Long userId) {
        return userDao.findOne(userId);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }


}
