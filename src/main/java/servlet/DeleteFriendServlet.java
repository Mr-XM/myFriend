package servlet;

import untils.SqlHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteFriendServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteFriendServlet() {
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
        String[] deleteFriend = request.getParameterValues("deleteFriend");
        if (!(deleteFriend == null && (deleteFriend != null && deleteFriend.length == 0))) {
            for (int i = 0; i < deleteFriend.length; i++) {
                if (SqlHelper.deleteFriend(Integer.parseInt(deleteFriend[i])) == false) {
                    out.print("<h4>操作失败</h4>");
                    out.print("   <a href='index.jsp?userName=" + userName + "'>点击反回主页</a> ");
                    return;
                }
            }
            out.print("<h4>删除成功</h4>");
            out.print("   <a href='index.jsp?userName=" + userName + "'>点击反回主页</a> ");
            return;
        } else {
            out.print("<h4>未选择删除好友，不能执行该操作</h4>");
            out.print("   <a href='index.jsp?userName=" + userName + "'>点击反回主页</a> ");
            return;
        }


    }
}
