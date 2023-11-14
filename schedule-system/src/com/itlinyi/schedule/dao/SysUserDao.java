package com.itlinyi.schedule.dao;

import com.itlinyi.schedule.pojo.SysUser;

/**
 * @author 林一
 * @version 1.0
 */
public interface SysUserDao {
    /**
     * 向数据库中插入数据
     *
     * @param sysUser 要增加的记录的username和user_pwd字段以SysUser实体类对象的形式入参
     * @return 返回值为1则插入成功返回值为0则插入失败
     */
    int addSysUser(SysUser sysUser);

    /**
     * 在数据库中查找对应用户名的用户信息
     * @param username  要查找的用户名
     * @return 找到了则返回SysUser对象 没找到则返回null
     */
    SysUser findByUsername(String username);
}
