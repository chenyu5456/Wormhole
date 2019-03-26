package com.wormhole.system.domain;

import com.wormhole.system.base.BaseEntity;

/**
 * @Author: ChenYu
 * @Date: 2019/3/26 17:24
 * @Description:
 */
public class SysUser extends BaseEntity {
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 登录名称
     */
    private String loginName;
    /**
     * 登录密码
     */
    private String password;

}
