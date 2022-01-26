package com.sdu.demo.shiro;

import com.sdu.demo.entity.User;
import com.sdu.demo.mapping.UserMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: tomato.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-03-27 10:39
 **/

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("身份认证");
        String principal = (String) token.getPrincipal();
        System.out.println(principal);

            User user = userMapper.findByName(principal);
//            User user = userMapper.findByName(principal);
//            User user = new User();
//            user.setUserName(principal);
//            user.setPassword("123456");
            if (user == null) {
                return null;
            }
            String password = user.getPassword();
            return new SimpleAuthenticationInfo(principal, password, this.getName());
    }
}
