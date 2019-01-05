package servlet;

import untils.Friend;
import untils.SqlHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class QueryFriendServlet extends HttpServlet {
    public QueryFriendServlet() {
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
        String name = request.getParameter("queryText");
        int userId = SqlHelper.getUserId(userName);
        if (name == null) {
            List<Friend> list = SqlHelper.getAllFriend(userId);
            request.setAttribute("list", list);
            request.getRequestDispatcher("/friendsInfo.jsp?userName=" + userName).forward(request, response);
            return;
        } else {
            List<Friend> list = SqlHelper.getPartFriend(userId, name);
            request.setAttribute("list", list);
            request.getRequestDispatcher("/friendsInfo.jsp?userName=" + userName).forward(request, response);
            return;
        }
    }
}
