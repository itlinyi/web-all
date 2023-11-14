package com.itlinyi.schedule.service;

import com.itlinyi.schedule.pojo.SysUser;

/**
 * @author 林一
 * @version 1.0
 */
public interface SysUserService {
    /**
     * 注册用户的方法
     *
     * @param sysUser 要注册的用户的用户名和明文密码以SysUser对象的形式入参
     * @return 注册成功返回1注册失败返回0
     */
    int regist(SysUser sysUser);

    /**
     * 根据用户名查询用户信息
     * @param username 要查询的用户名
     * @return  如果找到了返回SysUser对象，找不到返回null
     */
    SysUser findByUsername(String username);

}
