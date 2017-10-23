package com.qt.shiro.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.qt.shiro.dao.ResourceDao;
import com.qt.shiro.entity.Resource;

/**
 * <p>User: Zhang yinghui
 * <p>Version: 1.0
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public Resource createResource(Resource resource) {
        return resourceDao.createResource(resource);
    }

    @Override
    public Resource updateResource(Resource resource) {
        return resourceDao.updateResource(resource);
    }

    @Override
    public void deleteResource(Long resourceId) {
        resourceDao.deleteResource(resourceId);
    }

    @Override
    public Resource findOne(Long resourceId) {
        return resourceDao.findOne(resourceId);
    }

    @Override
    public List<Resource> findAll() {
        return resourceDao.findAll();
    }

    @Override
    public Set<String> findPermissions(Set<Long> resourceIds) {
        Set<String> permissions = new HashSet<String>();
        for(Long resourceId : resourceIds) {
            Resource resource = findOne(resourceId);
            if(resource != null && !StringUtils.isEmpty(resource.getPermission())) {
                permissions.add(resource.getPermission());
            }
        }
        return permissions;
    }

    @Override
    public List<Resource> findMenus(Set<String> permissions) {
        List<Resource> allResources = findAll();
        List<Resource> menus = new ArrayList<Resource>();
        Resource res = null;
        for(Resource resource : allResources) {
            if(resource.isRootNode()) {
            	res = new Resource();
            	res.setName("权限管理");
            	res.setIcon("");
            	menus.add(res);
                continue;
            }
            if(resource.getType() != Resource.ResourceType.menu) {
                continue;
            }
            if(!hasPermission(permissions, resource)) {
                continue;
            }
            if(resource.getParentId()==1 && resource.getId()!=11 && resource.getId()!=21 && resource.getId()!=31 && resource.getId()!=41 && resource.getId()!=46){
            	res = new Resource();
            	res.setId(resource.getId());
            	res.setName(resource.getName());
            	res.setUrl(resource.getUrl());
            	res.setIcon(resource.getIcon());
            	res.setParentIds(resource.getParentIds());
            	menus.add(res);
            }else{
            	res.getResourceList().add(resource);
            }
          
        }
        return menus;
    }

    @Override
    public List<Resource> findMenusOrig(Set<String> permissions) {
        List<Resource> allResources = findAll();
        List<Resource> menus = new ArrayList<Resource>();
        Subject subject = SecurityUtils.getSubject();
        List<String> urlList = new ArrayList<String>();
        Resource res =null;
        for(Resource resource : allResources) {
            if(resource.isRootNode()) {
                continue;
            }
            if(resource.getType() != Resource.ResourceType.menu) {
                continue;
            }
            if(!hasPermission(permissions, resource)) {
            	urlList.add(resource.getUrl());
                continue;
            }
            if(resource.getParentId()==1){
            	res = new Resource();
            	res.setId(resource.getId());
            	res.setName(resource.getName());
            	res.setUrl(resource.getUrl());
            	res.setIcon(resource.getIcon());
            	res.setParentIds(resource.getParentIds());
            	menus.add(res);
            }else{
              if(res!=null){  
                  res.getResourceList().add(resource);
              }
            }
//            menus.add(resource);
        }
        subject.getSession().setAttribute("exclusiveList", urlList);
        return menus;
    }
    
    private boolean hasPermission(Set<String> permissions, Resource resource) {
        if(StringUtils.isEmpty(resource.getPermission())) {
            return true;
        }
        for(String permission : permissions) {
            WildcardPermission p1 = new WildcardPermission(permission);
            WildcardPermission p2 = new WildcardPermission(resource.getPermission());
            if(p1.implies(p2) || p2.implies(p1)) {
                return true;
            }
        }
        return false;
    }
}
