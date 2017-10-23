package com.qt.shiro.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * <p>User: Zhang yinghui
 * <p>Version: 1.0
 */
public class UrlFilter implements Serializable {
    private Integer id;
    private String name; //url名称/描述
    private String url; //地址
    private String roles; //所需要的角色，可省略
    private String permissions; //所需要的权限，可省略

    private List<String> roleNames; //拥有的角色列表
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

	public List<String> getRoleNames() {
		 if(roleNames == null) {
			 roleNames = new ArrayList<String>();
	        }
		 if(!StringUtils.isEmpty(roles)) {
			 String[] roleIdStrs = roles.split(",");
		        for(String roleIdStr : roleIdStrs) {
		            if(StringUtils.isEmpty(roleIdStr)) {
		                continue;
		            }
		            roleNames.add(roleIdStr);
		   }
		 }
		return roleNames;
	}

	public void setRoleNames(List<String> roleNames) {
		this.roleNames = roleNames;
	}
	
	
	
    public void setRoleNamesStr(String roleNames) {
        if(StringUtils.isEmpty(roleNames)) {
            return;
        }
        String[] roleIdStrs = roleNames.split(",");
        for(String roleIdStr : roleIdStrs) {
            if(StringUtils.isEmpty(roleIdStr)) {
                continue;
            }
            getRoleNames().add(roleIdStr);
        }
    }

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UrlFilter urlFilter = (UrlFilter) o;

        if (id != null ? !id.equals(urlFilter.id) : urlFilter.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "UrlFilter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", roles='" + roles + '\'' +
                ", permissions='" + permissions + '\'' +
                '}';
    }
}
