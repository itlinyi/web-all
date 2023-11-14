package com.itlinyi.schedule.service.impl;

import com.itlinyi.schedule.dao.SysUserDao;
import com.itlinyi.schedule.dao.impl.SysUserDaoImp;
import com.itlinyi.schedule.pojo.SysUser;
import com.itlinyi.schedule.service.SysUserService;
import com.itlinyi.schedule.util.MD5Util;

/**
 * @author 林一
 * @version 1.0
 */
public class SysUserServiceImp implements SysUserService {
    private SysUserDao userDao = new SysUserDaoImp();

    @Override
    public int regist(SysUser sysUser) {
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));
        return userDao.addSysUser(sysUser);
    }

    @Override
    public SysUser findByUsername(String username) {
        return userDao.findByUsername(username);
    }

}
