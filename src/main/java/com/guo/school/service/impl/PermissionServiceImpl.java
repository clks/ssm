package com.guo.school.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guo.school.dao.PermissionDao;
import com.guo.school.domain.Permission;
import com.guo.school.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionDao permissionDao;

	@Override
	public List<Permission> listPermissionByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return permissionDao.listPermissionByRoleId(roleId);
	}

	@Override
	public List<Permission> listPermissions() {
		// TODO Auto-generated method stub
		return permissionDao.listPermissions();
	}

}
