package com.qt.shiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.qt.shiro.dao.UrlFilterDao;
import com.qt.shiro.entity.UrlFilter;

/**
 * <p>User: Zhang yinghui
 * <p>Version: 1.0
 */
@Service
public class UrlFilterServiceImpl implements UrlFilterService {

    @Autowired
    private UrlFilterDao urlFilterDao;

//    @Autowired
//    private ShiroFilerChainManager shiroFilerChainManager;

    @Override
    public UrlFilter createUrlFilter(UrlFilter urlFilter)throws Exception {
    	if(!StringUtils.isEmpty(urlFilter.getRoleNames())){
	    	StringBuilder sb = new StringBuilder("");
	    	for (String roleName : urlFilter.getRoleNames()) {
	    		sb.append(roleName).append(",");
			}
	    	urlFilter.setRoles(sb.toString());
    	}
    	urlFilterDao.createUrlFilter(urlFilter);
        initFilterChain();
        return urlFilter;
    }



    @Override
    public UrlFilter updateUrlFilter(UrlFilter urlFilter) {
    	if(!StringUtils.isEmpty(urlFilter.getRoleNames())){
	    	StringBuilder sb = new StringBuilder("");
	    	for (String roleName : urlFilter.getRoleNames()) {
	    		sb.append(roleName).append(",");
			}
	    	urlFilter.setRoles(sb.toString());
    	}
    	urlFilterDao.updateUrlFilter(urlFilter);
        initFilterChain();
        return urlFilter;
    }

    @Override
    public void deleteUrlFilter(Long urlFilterId) {
        urlFilterDao.deleteUrlFilter(urlFilterId);
        initFilterChain();
    }

    @Override
    public UrlFilter findOne(Long urlFilterId) {
        return urlFilterDao.findOne(urlFilterId);
    }

    @Override
    public List<UrlFilter> findAll()throws Exception {
        return urlFilterDao.findAll();
    }

    public void initFilterChain() {
        try {
//            Meta_draw.urlFilterList = findAll();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
