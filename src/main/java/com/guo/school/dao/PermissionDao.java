package com.guo.school.dao;

import java.util.List;

import com.guo.school.domain.Permission;

/**
 * Created by yubotao on 2017/12/03.
 */
public interface PermissionDao {
    
    public Integer insert(Permission permission);
    
    public Integer delete(Long id);
    
    public Integer update(Permission permission);
    
    public List<Permission> listPermissionByRoleId(Integer roleId);
    
    public List<Permission> listPermissions();
    
}
