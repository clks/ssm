package com.guo.school.dao;

import java.util.List;

import com.guo.school.domain.User;

public interface UserDao {
    public  User findByUsername(String username);
    public  List<User> listUsers();
    public  Integer addUser(User user);
    

    public Integer insert(User user);
    
    public Integer delete(Long id);
    
    public Integer update(User user);
    
    public User getUserById(Long id);
    
    public User getUserByName(String name);
}