package com.qt.shiro.dao;

import java.util.List;

import com.qt.shiro.entity.UrlFilter;

/**
 * <p>User: Zhang yinghui
 * <p>Version: 1.0
 */
public interface UrlFilterDao {

    public UrlFilter createUrlFilter(UrlFilter urlFilter)throws Exception;
    public UrlFilter updateUrlFilter(UrlFilter urlFilter);
    public void deleteUrlFilter(Long urlFilterId);

    public UrlFilter findOne(Long urlFilterId);
    public List<UrlFilter> findAll();
}
