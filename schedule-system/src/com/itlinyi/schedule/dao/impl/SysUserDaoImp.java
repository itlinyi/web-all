package com.itlinyi.schedule.dao.impl;

import com.itlinyi.schedule.dao.BaseDao;
import com.itlinyi.schedule.dao.SysUserDao;
import com.itlinyi.schedule.pojo.SysSchedule;
import com.itlinyi.schedule.pojo.SysUser;

import java.util.List;

/**
 * @author 林一
 * @version 1.0
 */
public class SysUserDaoImp extends BaseDao implements SysUserDao {
    @Override
    public int addSysUser(SysUser sysUser) {
        String sql = "insert into sys_user values(DEFAULT,?,?)";
        return baseUpdate(sql, sysUser.getUsername(), sysUser.getUserPwd());
    }

    @Override
    public SysUser findByUsername(String username) {
        String sql = "select uid,username,user_pwd userPwd from sys_user where username = ?";
        List<SysUser> sysUserList = baseQuery(SysUser.class, sql, username);

        return sysUserList != null && sysUserList.size() > 0 ? sysUserList.get(0) : null;
    }
}
