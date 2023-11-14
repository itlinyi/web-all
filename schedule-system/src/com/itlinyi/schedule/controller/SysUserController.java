package com.itlinyi.schedule.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itlinyi.schedule.common.Result;
import com.itlinyi.schedule.common.ResultCodeEnum;
import com.itlinyi.schedule.pojo.SysUser;
import com.itlinyi.schedule.service.SysUserService;
import com.itlinyi.schedule.service.impl.SysUserServiceImp;
import com.itlinyi.schedule.util.MD5Util;
import com.itlinyi.schedule.util.WebUtil;
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
@WebServlet("/user/*")
public class SysUserController extends BaseController {
    private SysUserService userService = new SysUserServiceImp();

    /**
     * 接收用户注册的用户名，并判断用户名是否存在的业务处理方法
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        SysUser sysUser = userService.findByUsername(username);
        Result result = Result.ok(null);
        if (null != sysUser) {
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }

        //将result对象转换为JSON串响应给客户端
        WebUtil.writeJson(resp, result);
    }

    /**
     * 接收用户注册请求的业务处理方法(业务接口 不是java中的interface)
     *
     * @param req
     * @param resp
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //接收客户端提交的参数
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        //调用服务层的方法
        SysUser sysUser = new SysUser(null, username, userPwd);
        int rows = userService.regist(sysUser);
        //根据注册结果做页面跳转
        if (rows > 0) {
            resp.sendRedirect("/registSuccess.html");
        } else {
            resp.sendRedirect("/registFail.html");
        }
    }

    /**
     * 接受用户登录的业务请求处理，完成登录的业务接口
     *
     * @param req
     * @param resp
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        SysUser loginUser = userService.findByUsername(username);
        if (null == loginUser) {
            resp.sendRedirect("/loginUsernameError.html");
        } else if (!MD5Util.encrypt(userPwd).equals(loginUser.getUserPwd())) {
            resp.sendRedirect("/loginUserPwdError.html");
        } else {
            //登录成功以后将登录的用户信息放入session
            HttpSession session = req.getSession();
            session.setAttribute("sysUser", loginUser);
        }
        resp.sendRedirect("/showSchedule.html");
    }
}
