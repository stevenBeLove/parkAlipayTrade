package com.qt.shiro.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qt.shiro.entity.User;

/**
 * <p>User: Zhang yinghui
 * <p>Version: 1.0
 */
public interface UserService {

    /**
     * 创建用户
     * @param user
     */
    public User createUser(User user)throws Exception;

    public User updateUser(User user)throws Exception;

    public void deleteUser(Long userId)throws Exception;

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword)throws Exception;
    
    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePasswordShiro(Long userId, String newPassword)throws Exception;


    /**
     * 
     * 【方法名】    : (根据用户Id查询用户). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月17日 下午2:23:23 .<br/>
     * 【参数】： .<br/>
     * @param userId 用户Id
     * @return 用户
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public User findOne(Long userId)throws Exception;

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String username);

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username);
    
    /**
     * 
     * 【方法名】    : (查询列表数据). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月17日 下午2:08:45 .<br/>
     * 【参数】： .<br/>
     * @param map Map参数
     * @return 数量
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public int findAllCount(Map<String, Object> map) throws Exception;
    /**
     * 
     * 【方法名】    : (查询列表). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月17日 下午2:09:23 .<br/>
     * 【参数】： .<br/>
     * @param map 参数
     * @return 集合
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public List<User> findAll(Map<String, Object> map) throws Exception;

}
