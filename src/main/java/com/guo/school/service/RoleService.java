package com.guo.school.service;

import java.util.List;

import com.guo.school.domain.Role;

/**
 * Created by yubotao on 2017/12/03.
 */
public interface RoleService {
    
    public boolean insert(Role role);
    
    public boolean delete(Long id);
    
    public boolean update(Role role);
    
    public Role getRoleById(Long id);
    
    public List<Role> listRoleByUserId(Integer integer);
    
}
