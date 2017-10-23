package com.qt.shiro.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qt.shiro.dao.UserDao;
import com.qt.shiro.entity.User;
import com.qt.shiro.web.taglib.Functions;

/**
 * <p>User: Zhang yinghui
 * <p>Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * UserDao
     */
    @Autowired
    private UserDao userDao;
    /**
     * PasswordHelper
     */
    @Autowired
    private PasswordHelper passwordHelper;
    /**
     * RoleService
     */
    @Autowired
    private RoleService roleService;
    /**
     * UrlFilterService
     */
    @Autowired
    private UrlFilterService urlFilterService;
    

    @Override
    public User createUser(User user)throws Exception {
        //加密密码
        passwordHelper.encryptPassword(user);
        return userDao.createUser(user);
    }

    @Override
    public User updateUser(User user)throws Exception{
        return userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Long userId)throws Exception {
        userDao.deleteUser(userId);
    }

    /**
     * 修改密码
     * @param userId 用户Id
     * @param newPassword 新密码
     */
    public void changePassword(Long userId, String newPassword)throws Exception {
        User user =userDao.findOne(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userDao.updateUser(user);
    }
    
    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePasswordShiro(Long userId, String newPassword)throws Exception {
        User user =userDao.findOne(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userDao.updateUser(user);
    }
    

    @Override
    public User findOne(Long userId)throws Exception {
        return userDao.findOne(userId);
    }

    @Override
    public List<User> findAll(Map<String, Object> map)throws Exception {
        List<User> list = userDao.findAll(map);
        return list;
    }
    
    @Override
    public int findAllCount(Map<String, Object> map) throws Exception{
        return userDao.findAllCount(map);
    }
    

    @Override
    public User findByUsername(String username){
        return userDao.findByUsername(username);
    }

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String username) {
        User user =findByUsername(username);
        if(user == null) {
            return Collections.EMPTY_SET;
        }
        return roleService.findRoles(user.getRoleIds().toArray(new Long[0]));
    }

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username) {
        User user =findByUsername(username);
        if(user == null) {
            return Collections.EMPTY_SET;
        }
//        urlFilterService.initFilterChain();
        return roleService.findPermissions(user.getRoleIds().toArray(new Long[0]));
    }

}
