package com.itlinyi.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 林一
 * @version 1.0
 */
public class LoggingFilter implements Filter {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        //参数父转子
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //请求到达目标资源之前打印日志  yyyy-MM-dd HH:mm:ss  ***被访问了
        String requestURI = request.getRequestURI();
        String dateTime = simpleDateFormat.format(new Date());
        String beforeLogging = requestURI + "在" + dateTime + "被访问了";
        System.out.println(beforeLogging);
        long start = System.currentTimeMillis();

        //放行
        filterChain.doFilter(servletRequest, servletResponse);

        //响应之前的功能代码  ***资源 在yyyy-MM-dd HH:mm:ss 的请求耗时多少秒
        long end = System.currentTimeMillis();
        String afterLogging=requestURI+"资源在"+dateTime+"的请求耗时"+(end-start)+"毫秒";
        System.out.println(afterLogging);


    }
}
