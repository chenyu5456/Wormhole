package com.wormhole.framework.shiro;

import com.wormhole.system.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: ChenYu
 * @Date: 2019/3/28 10:35
 * @Description:
 */
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 用于获取登录成功的鴃舌、权限等信息
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 验证当亲登录的subject
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //拿到username
        String username = (String)token.getPrincipal();
        //检测token的信息
        String result = (String) token.getCredentials();

        return null;
    }
}
