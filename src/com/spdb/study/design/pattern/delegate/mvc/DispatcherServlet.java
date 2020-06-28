package com.spdb.study.design.pattern.delegate.mvc;

import com.spdb.study.design.pattern.delegate.mvc.controllers.MemberController;
import com.spdb.study.design.pattern.delegate.mvc.controllers.OrderController;
import com.spdb.study.design.pattern.delegate.mvc.controllers.SystemController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 委派类(解决多任务统筹调度的问题)
 * @author Mr.Longyx
 * @date 2020年06月28日 16:11
 */
public class DispatcherServlet extends HttpServlet {
    /**
     * 完成任务调度
     * @author Mr.Longyx
     * @date 2020/6/28 16:23
     * @param req
     * @param resp
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req,resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uri = req.getRequestURI();
        String mid = req.getParameter("mid");

        if ("getMemberById".equals(uri)){
            new MemberController().getMemberById(mid);
        }else if("getOrderById".equals(uri)){
            new OrderController().getOrderById(mid);
        }else if("logout".equals(uri)){
            new SystemController().logout();
        }else{
            resp.getWriter().write("404, Not Found!");
        }
    }
}
