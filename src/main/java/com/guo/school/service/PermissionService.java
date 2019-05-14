package com.guo.school.service;

import java.util.List;

import com.guo.school.domain.Permission;

/**
 * Created by yubotao on 2017/12/03.
 */
public interface PermissionService {
	 public List<Permission> listPermissionByRoleId(Integer roleId);
	 public List<Permission> listPermissions();
    
}
