package com.guo.school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guo.school.dao.UserDao;
import com.guo.school.domain.User;
import com.guo.school.service.UserService;

/**
 * Created by yubotao on 2017/12/03.
 */
@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    UserDao userDao;
    
    public boolean insert(User user){
        Integer flag = userDao.insert(user);
        if(flag > 0){
            return true;
        }
        return false;
    }
    
    public boolean delete(Long id){
        Integer flag = userDao.delete(id);
        if(flag > 0){
            return true;
        }
        return false;
    }
    
    public boolean update(User user){
        Integer flag = userDao.update(user);
        if(flag > 0){
            return true;
        }
        return false;
    }
    
    public User getUserById(Long id){
        User user = userDao.getUserById(id);
        return user;
    }
    
    public User getUserByName(String name){
        User user = userDao.getUserByName(name);
        return user;
    }
}
