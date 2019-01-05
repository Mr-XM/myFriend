package servlet;

import untils.SqlHelper;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset = UTF-8");
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String[] mySelectValue = request.getParameterValues("mySelect");
        HttpSession session=request.getSession();
        if (SqlHelper.isValid(userName, userPassword)) {
            if (mySelectValue != null) {
                for (int i = 0; i < mySelectValue.length; i++) {
                    if (mySelectValue.length == 2) {
                        if (mySelectValue[i].equals("自动记录名称")) {
                            Cookie cookie = new Cookie("userName", userName);
                            cookie.setMaxAge(60 * 60);
                            response.addCookie(cookie);
                        }
                        if (mySelectValue[i].equals("自动记录密码")) {
                            Cookie cookie = new Cookie("userPassword", userPassword);
                            cookie.setMaxAge(60 * 60);
                            response.addCookie(cookie);
                        }
                    }
                    if (mySelectValue.length == 1) {
                        Cookie[] cookies = request.getCookies();
                        for (int j = 0; j < cookies.length; j++) {
                            cookies[j].setMaxAge(0);
                            response.addCookie(cookies[j]);
                        }
                        if (mySelectValue[i].equals("自动记录名称")) {
                            Cookie cookie = new Cookie("userName", userName);
                            cookie.setMaxAge(60 * 60);
                            response.addCookie(cookie);
                        }
                        if (mySelectValue[i].equals("自动记录密码")) {
                            Cookie cookie = new Cookie("userPassword", userPassword);
                            cookie.setMaxAge(60 * 60);
                            response.addCookie(cookie);
                        }
                    }
                }
                session.setAttribute("userName", userName);
                session.setMaxInactiveInterval(60 * 30);
            } else {
                Cookie[] cookies = request.getCookies();
                for (int i = 0; i < cookies.length; i++) {
                    cookies[i].setMaxAge(0);
                    response.addCookie(cookies[i]);
                }
            }
            response.sendRedirect("index.jsp?userName=" + userName);
            return;
        } else {
            out.print("账号或密码错误，请重新登录");
            response.sendRedirect("loginForm.jsp");
            return;
        }
    }
}
