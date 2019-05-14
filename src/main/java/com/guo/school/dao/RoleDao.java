package com.guo.school.dao;

import java.util.List;

import com.guo.school.domain.Role;

/**
 * Created by yubotao on 2017/12/03.
 */
public interface RoleDao {
    
    public Integer insert(Role role);
    
    public Integer delete(Long id);
    
    public Integer update(Role role);
    
    public Role getRoleById(Long id);
    
    public List<Role> listRoleByUserId(Integer userId);
    
}
