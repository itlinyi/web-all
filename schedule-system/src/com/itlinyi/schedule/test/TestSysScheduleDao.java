package com.itlinyi.schedule.test;

import com.itlinyi.schedule.dao.SysScheduleDao;
import com.itlinyi.schedule.dao.impl.SysScheduleDaoImp;
import com.itlinyi.schedule.pojo.SysSchedule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

/**
 * @author 林一
 * @version 1.0
 */
public class TestSysScheduleDao {
    private static SysScheduleDao scheduleDao;

    @BeforeAll
    public static void initSysScheduleDaoImp() {
        scheduleDao = new SysScheduleDaoImp();
    }

    @Test
    public void testAddSchedule() {
        int rows = scheduleDao.addSchedule(new SysSchedule(null,2,"学习数据库",1));
        System.out.println(rows);
    }

    @Test
    public void testfindAll() {
        List<SysSchedule> scheduleList = scheduleDao.findAll();
        scheduleList.forEach(System.out::println);
    }
}
