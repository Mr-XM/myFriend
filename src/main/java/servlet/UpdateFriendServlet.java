package servlet;

import untils.Friend;
import untils.SqlHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateFriendServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateFriendServlet() {
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
        String userid = request.getParameter("userid");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String qq = request.getParameter("qq");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String id = request.getParameter("id");
        String userName = request.getParameter("userName");
        Friend friend = new Friend();
        friend.setId(Integer.parseInt(id));
        friend.setAddress(address);
        friend.setAge(Integer.parseInt(age));
        friend.setName(name);
        friend.setEmail(email);
        friend.setQq(qq);
        friend.setUserid(Integer.parseInt(userid));
        friend.setTelephone(telephone);
        friend.setSex(sex);

        if (SqlHelper.updateFriendInformation(friend)) {
            out.print("<h4>更新成功</h4>");
            out.print("   <a href='index.jsp?userName=" + userName + "'>点击反回主页</a> ");
        } else {
            out.print("<h4>更新失败</h4>");
            out.print("   <a href='index.jsp?userName=" + userName + "'>点击反回主页</a> ");
        }

    }
}
