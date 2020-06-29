package com.spdb.study.design.pattern.delegate.mvc;

import com.spdb.study.design.pattern.delegate.mvc.controllers.MemberController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 委派类(解决多任务统筹调度的问题)
 * @author Mr.Longyx
 * @date 2020年06月28日 16:11
 */
public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = -3945578897544588174L;

    private List<Handler> handlerMapping = new ArrayList<>();


    @Override
    public void init() throws ServletException {
        try {
            Class<?> memberControllerClass = MemberController.class;
            handlerMapping.add(new Handler().setController(memberControllerClass.newInstance())
                    .setMethod(memberControllerClass.getMethod("getMemberById",new Class[]{String.class}))
                    .setUrl("/web/getMemberById.do"));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

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

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) {
        String uri = req.getRequestURI();
        Handler handler = null;
        for (Handler h : handlerMapping) {
            if (uri.equals(h.getUrl())){
                handler = h;
                break;
            }
        }
        try {
            Object obj = handler.getMethod().invoke(handler.getController(),req.getParameter("mid"));
            resp.getWriter().write(obj.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 待优化(此处不符合开闭原则)
     * @author Mr.Longyx
     * @date 2020/6/29 14:34
     * private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
     *         String uri = req.getRequestURI();
     *         String mid = req.getParameter("mid");
     *          if ("getMemberById".equals(uri)){
     *             new MemberController().getMemberById(mid);
     *         }else if("getOrderById".equals(uri)){
     *             new OrderController().getOrderById(mid);
     *         }else if("logout".equals(uri)){
     *             new SystemController().logout();
     *         }else{
     *             resp.getWriter().write("404, Not Found!");
     *         }
     *     }
     */

    /**
     * 内部类
     * @author Mr.Longyx
     * @date 2020/6/29 14:38
     */
    class Handler{
        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }

}
