package com.itlinyi.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author 林一
 * @version 1.0
 */
/*
* 1.实例化                         构造器
* 2.初始化                         init
* 3.接受请求，处理请求  服务          service
* 销毁                            destory
*
*
 */
@WebServlet("/servletLifeCycle")
public class ServletLifeCycle extends HttpServlet {
    public ServletLifeCycle() {
        System.out.println("构造器");
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("服务");
    }
    @Override
    public void init() throws ServletException {
        System.out.println("初始化");
    }

    @Override
    public void destroy() {
        System.out.println("destory");
    }
}