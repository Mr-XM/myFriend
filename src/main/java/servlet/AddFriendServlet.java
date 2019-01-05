package servlet;

import untils.Friend;
import untils.SqlHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddFriendServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddFriendServlet() {
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
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String qq = request.getParameter("qq");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String userName = request.getParameter("userName");
        int userid = SqlHelper.getUserId(userName);

        Friend friend = new Friend();
        friend.setAddress(address);
        friend.setAge(Integer.parseInt(age));
        friend.setName(name);
        friend.setEmail(email);
        friend.setQq(qq);
        friend.setUserid(userid);
        friend.setTelephone(telephone);
        friend.setSex(sex);

        if (SqlHelper.addFriend(friend)) {
            out.print("<h4>添加成功</h4>");
            out.print("   <a href='index.jsp?userName=" + userName + "'>点击反回主页</a> ");
            return;
        } else {
            out.print("<h4>删除失败</h4>");
            out.print("   <a href='index.jsp?userName=" + userName + "'>点击反回主页</a> ");
            return;
        }
    }


}
