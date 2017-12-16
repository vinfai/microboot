package com.vinfai.config.shiro;

import com.vinfai.entity.User;
import com.vinfai.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * 用户认证
 *
 * @author fangwenhui
 * @date 2017-12-13 17:48
 **/
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    //授权 获取当前用户的权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User dbUser = userService.getUserByName(user.getUserName());

        //查询有的权限和角色
        Set<String> roleSet = userService.getRolesByUserId(dbUser.getId());
        Set<String> permissionSet = userService.getPermissionsByUserId(dbUser.getId());

        authorizationInfo.setRoles(roleSet);
        authorizationInfo.setStringPermissions(permissionSet);

        return authorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String userName = token.getUsername();
        User user = userService.getUserByName(userName);
        if (user == null) {
            throw new UnknownAccountException("用户不存在");
        }
//        HashedCredentialsMatcher
        //密码校验
        //TODO 加密算法+密码比较,在shiroconfig中配置
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), null, getName());

        return authenticationInfo;
        /*UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;

        String password = String.valueOf(token.getPassword());

        User user = userService.getUserByName(userName);
        if (user == null) {
            throw new UnknownAccountException("账号不存在");
        }
        System.out.println(getName());
        //密码salt..
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPswd(), getName());
*/
        /*
        当验证都通过后，把用户信息放在session里
         Session session = SecurityUtils.getSubject().getSession();
         session.setAttribute("userSession", user);
         session.setAttribute("userSessionId", user.getId());

                return null;
         */
    }
}
