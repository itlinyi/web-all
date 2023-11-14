package com.itlinyi.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author 林一
 * @version 1.0
 */
@WebServlet("/servletB")
public class ServletB extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求域数据
        String reqMessage = (String)req.getAttribute("request");
        System.out.println("请求域数据为："+reqMessage);
        //获取会话域数据
        HttpSession session = req.getSession();
        String sessionMessage = (String) session.getAttribute("session");
        System.out.println("会话域数据为："+sessionMessage);
        //获取应用域数据
        ServletContext application = req.getServletContext();
        String applicationMessage = (String) application.getAttribute("application");
        System.out.println("应用域："+applicationMessage);


    }
}
