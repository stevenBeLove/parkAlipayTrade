package com.qt.shiro.dao;

import java.util.List;

import com.qt.shiro.entity.Role;

/**
 * <p>User: Zhang yinghui
 * <p>Version: 1.0
 */
public interface RoleDao {

    public Role createRole(Role role);
    public Role updateRole(Role role);
    public void deleteRole(Long roleId);

    public Role findOne(Long roleId);
    public List<Role> findAll();
}
