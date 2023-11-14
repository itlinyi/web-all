package com.itlinyi.schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author 林一
 * @version 1.0
 */

/**
 * 增加日程请求  /schedule/add
 * 查询日程请求  /schedule/find
 * 修改日程请求  /schedule/update
 * 删除日程请求  /schedule/delete
 */
@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController {
    protected void add(HttpServletRequest request, HttpServletResponse response){
        System.out.println("ADD");
    }

}