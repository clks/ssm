package com.guo.school.shiro;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.AllowAllCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.guo.school.domain.Permission;
import com.guo.school.domain.Role;
import com.guo.school.domain.User;
import com.guo.school.service.PermissionService;
import com.guo.school.service.RoleService;
import com.guo.school.service.UserService;

import util.SplitUtil;

/**
 * Created by yubotao on 2017/12/03.
 */
@SuppressWarnings("ALL")
@Component
public class MyRealm extends AuthorizingRealm{
    private static final Log log = LogFactory.getLog(MyRealm.class);
    public MyRealm(){
        super(new AllowAllCredentialsMatcher());
        setAuthenticationTokenClass(UsernamePasswordToken.class);
        //FIXME:暂时禁用Cache
        setCachingEnabled(false);
    }
    
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;
    //验证时调用
    //此方法调用subject.hasRole("admin")或subject.isPermitted("admin");
    //自己去调用这个是否有什么角色或有什么权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
        User user = (User) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        
        User user1 = null;
        
        /*新建角色与权限的set*/
        Set<String> shiroPermissions = new HashSet<>();
        Set<String> roleSet = new HashSet<>();
        try{
            /*1.通过userName获取userId*/
            user1 = userService.getUserByName(user.getName());
            if(user1 != null){	
            	List<Role> roles=roleService.listRoleByUserId(user1.getId());
            	log.info("role"+roles);
            	for (Iterator iterator = roles.iterator(); iterator.hasNext();) {
					Role role = (Role) iterator.next();
					List<Permission> permissions=permissionService.listPermissionByRoleId(role.getId());
					log.info("permissions"+permissions);
					for (Iterator iterator2 = permissions.iterator(); iterator2.hasNext();) {
						Permission permission = (Permission) iterator2.next();
						shiroPermissions.add(permission.getCode());
					}
				}
            	
				/*
				 * Role role = roleService.getRoleById(user.getRole());
				 * log.info("role permission : " + role.getPermission()); SplitUtil splitUtil =
				 * new SplitUtil(); List<Integer> permissionList =
				 * splitUtil.stringToIntegerList(role.getPermission());
				 * log.info("permisson list : " + permissionList); for (int i = 0; i <
				 * permissionList.size(); i++){
				 * shiroPermissions.add(permissionList.get(i).toString()); }
				 */
                authorizationInfo.setStringPermissions(shiroPermissions);
                log.info("shiroPermissions : " + shiroPermissions);
                return authorizationInfo;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    //登陆时调用
    //调用Subject currentUser = SecurityUtils.getSubject();
    //    currentUser.login(token);
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token){
        String username = (String) token.getPrincipal();
        log.info("username : " + username);
        User user = null;
        String password = null;
        
        try{
            /*通过username获取User*/
            user = userService.getUserByName(username);
            log.info("user : " + user);
            password = new String((char[]) token.getCredentials());
            log.info("password : " + password);
            //账号不存在
            if(user == null){
                throw new UnknownAccountException("账号不正确");
            }
            //密码错误
            //简单起见，没有加密，应该加上
            if(!password.equals(user.getPassword())){
                throw new UnknownAccountException("密码错误");
            }
        }catch (Exception e){
            throw new AuthenticationException();
        }
        
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,password,getName());
        
        return info;
    }
    
}
