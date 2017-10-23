package com.qt.shiro.dao;

import java.util.List;
import java.util.Map;

import com.qt.shiro.entity.User;

/**
 * <p>User: Zhang yinghui
 * <p>Version: 1.0
 */
public interface UserDao {

    /**
     * 
     * 【方法名】    : (添加人员). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月17日 下午2:09:55 .<br/>
     * 【参数】： .<br/>
     * @param user User对象
     * @return  User对象
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public User createUser(User user)throws Exception;
    /**
     * 
     * 【方法名】    : (更新人员信息). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月17日 下午2:11:38 .<br/>
     * 【参数】： .<br/>
     * @param user  用户
     * @return 用户
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public User updateUser(User user)throws Exception;
    /**
     * 
     * 【方法名】    : (删除用户). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月17日 下午2:12:04 .<br/>
     * 【参数】： .<br/>
     * @param userId 用户Id
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public void deleteUser(Long userId)throws Exception;
    /**
     * 
     * 【方法名】    : (根据用户id查询用户信息). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月17日 下午2:13:11 .<br/>
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
     * 
     * 【方法名】    : (这里用一句话描述这个方法的作用). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月17日 下午2:13:59 .<br/>
     * 【参数】： .<br/>
     * @param username 用户名 
     * @return 用户对象
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public User findByUsername(String username);
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
