package com.itlinyi.schedule.test;

import com.itlinyi.schedule.dao.BaseDao;
import com.itlinyi.schedule.pojo.SysUser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author 林一
 * @version 1.0
 */
public class TestBaseDao {
    private static BaseDao baseDao;

    @BeforeAll
    public static void initBaseDao() {
        baseDao = new BaseDao();
    }

    @Test
    public void testBaseQueryObject() {
        String sql = "select count(1) from sys_user";
        Long count = baseDao.baseQueryObject(Long.class, sql);
        System.out.println(count);
    }

    @Test
    public void testBaseQuery() {
        String sql = "select uid,username,user_pwd userPwd from sys_user";
        List<Object> SysUserList = baseDao.baseQuery(SysUser.class, sql);
        SysUserList.forEach(System.out::println);
    }

    @Test
    public void testBaseUpdate() {
        String sql = "insert into sys_user values(DEFAULT,?,?)";
        int rows = baseDao.baseUpdate(sql, "wangwu", 8848);
        System.out.println(rows);
    }
}

