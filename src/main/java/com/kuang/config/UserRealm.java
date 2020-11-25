package com.kuang.config;

import com.kuang.pojo.User;
import com.kuang.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm
{
    @Autowired
    UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("shouquan Ok");
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermission("user:add");
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("renzheng ok");

        UsernamePasswordToken userToken=(UsernamePasswordToken) token;
        User user=userService.queryUserById(((UsernamePasswordToken) token).getUsername());
        System.out.println(user);
        if(user==null)
            return null;

        return new SimpleAuthenticationInfo("",user.getPwd(),"");
    }
}
