package com.vinfai.shiro.config;

import com.vinfai.entity.User;
import com.vinfai.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 用户认证
 *
 * @author fangwenhui
 * @date 2017-12-13 17:48
 **/
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String userName = token.getUsername();
        String password = String.valueOf(token.getPassword());

        User user = userService.getUserByName(userName);
        if (user == null) {
            throw new UnknownAccountException("账号不存在");
        }
        System.out.println(getName());
        //密码salt..
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPswd(), getName());

        /**
         *    // 当验证都通过后，把用户信息放在session里
         Session session = SecurityUtils.getSubject().getSession();
         session.setAttribute("userSession", user);
         session.setAttribute("userSessionId", user.getId());
         */
                return authenticationInfo;
    }
}
