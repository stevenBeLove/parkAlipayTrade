package com.qt.shiro.dao;

import java.util.List;

import com.qt.shiro.entity.Resource;

/**
 * <p>Resource: Zhang yinghui
 * <p>Version: 1.0
 */
public interface ResourceDao {

    public Resource createResource(Resource resource);
    public Resource updateResource(Resource resource);
    public void deleteResource(Long resourceId);

    Resource findOne(Long resourceId);
    List<Resource> findAll();

}
