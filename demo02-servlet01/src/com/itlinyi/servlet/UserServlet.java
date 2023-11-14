package com.itlinyi.servlet;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 林一
 * @version 1.0
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String info = "<h1>YES<h1/>";
        if ("itlinyi".equals(username)) {
            info = "<h1>NO<h1/>";
        }
        //将要响应的数据放入response
        //应该要设置Content-Type响应头
//        response.setHeader("Content-Type","text/html");
        response.setContentType("text/css");
        PrintWriter writer = response.getWriter();
        writer.write(info);
    }
}
