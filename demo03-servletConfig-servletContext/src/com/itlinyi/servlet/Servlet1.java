package com.itlinyi.servlet;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * @author 林一
 * @version 1.0
 */
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        String keya = servletConfig.getInitParameter("keya");
        System.out.println("keya=" + keya);

        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String pname = initParameterNames.nextElement();
            System.out.println(pname + "=" + servletConfig.getInitParameter(pname));
        }
        System.out.println("------------------------------------------------");

        ServletContext servletContext1 = servletConfig.getServletContext();
        ServletContext servletContext2 = req.getServletContext();
        ServletContext servletContext3 = getServletContext();

        String encoding = servletContext1.getInitParameter("encoding");
        System.out.println("encoding=" +encoding);

        Enumeration<String> initParameterNames1 = servletContext1.getInitParameterNames();
        while (initParameterNames1.hasMoreElements()) {
            String pname1 = initParameterNames1.nextElement();
            System.out.println(pname1 + "=" + servletContext1.getInitParameter(pname1));
        }
    }


}
