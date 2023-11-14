package com.itlinyi.schedule.dao;

import com.itlinyi.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * @author 林一
 * @version 1.0
 */
public interface SysScheduleDao {
    /**
     *
     * @param schedule 日程数据以SysSchedule实体类对象形式入参
     * @return 返回影响数据库记录的行数，行数为o说明增加失败，行数大于0说明增加成功
     */
    int addSchedule(SysSchedule schedule);

    /**
     * 查询所有用户的所有日程
     * @return 将所有的日程放入一个List<SysSchedule>集合中返回
     */
    List<SysSchedule> findAll();
}
