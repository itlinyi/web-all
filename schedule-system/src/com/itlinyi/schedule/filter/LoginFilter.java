package com.itlinyi.schedule.filter;

import com.itlinyi.schedule.pojo.SysUser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author 林一
 * @version 1.0
 */
@WebFilter(urlPatterns = {"/showSchedule.html","/schedule/*"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //参数父转子
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //获得session对象
        HttpSession session = req.getSession();
        //从session域中获得登录的用户对象
        SysUser sysUser = (SysUser) session.getAttribute("sysUser");
        //判断用户对象是否为空
        if (null == sysUser) {
            resp.sendRedirect("/login.html");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        //为空则没登录获 跳转到login.html
        //登陆过就放行
    }

}
