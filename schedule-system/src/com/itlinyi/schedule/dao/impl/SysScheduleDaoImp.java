package com.itlinyi.schedule.dao.impl;

import com.itlinyi.schedule.dao.BaseDao;
import com.itlinyi.schedule.dao.SysScheduleDao;
import com.itlinyi.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * @author 林一
 * @version 1.0
 */
public class SysScheduleDaoImp extends BaseDao implements SysScheduleDao {
    @Override
    public int addSchedule(SysSchedule schedule) {
        String sql = "insert into sys_schedule values(DEFAULT,?,?,?)";
        int rows = baseUpdate(sql, schedule.getUid(), schedule.getTitle(), schedule.getCompleted());
        return rows;
    }

    @Override
    public List<SysSchedule> findAll() {
        String sql = "select sid,uid,title,completed from sys_schedule";
        List<SysSchedule> scheduleList = baseQuery(SysSchedule.class, sql);
        return scheduleList;
    }
}
