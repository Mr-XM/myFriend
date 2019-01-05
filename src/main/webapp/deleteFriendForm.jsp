<%@ page import="untils.Friend" %>
<%@ page import="untils.SqlHelper" %>

<%--
  Created by IntelliJ IDEA.
  User: zhangyinghao
  Date: 2018/12/13
  Time: 上午9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除好友</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes"/>
</head>
</head>
<body>
<%
    String userName = request.getParameter("userName");
    String[] deleteFriend = request.getParameterValues("deleteFriend");
%>
<h1 align="center">您将要删除一下好友信息</h1>
<form action="/DeleteFriendServlet" method="post">
    <input type="hidden" name="userName" value="<%=userName%>">
    <table align="center" width="100%">
        <th>删除</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>QQ</th>
        <th>电话</th>
        <th>Email</th>
        <th>地址</th>
        <%
            if (!(deleteFriend == null && (deleteFriend != null && deleteFriend.length == 0))) {
                for (int i = 0; i < deleteFriend.length; i++) {
                    Friend friend = SqlHelper.getFriend(Integer.parseInt(deleteFriend[i]));
        %>
        <tr>
            <td align="center"><input type="checkbox" checked="checked" onclick="return false;" name="deleteFriend"
                                      value="<%=friend.getId()%>"></td>
            <td align="center"><%=friend.getName()%>
            </td>
            <td align="center"><%=friend.getSex()%>
            </td>
            <td align="center"><%=friend.getAge()%>
            </td>
            <td align="center"><%=friend.getQq()%>
            </td>
            <td align="center"><%=friend.getTelephone()%>
            </td>
            <td align="center"><%=friend.getEmail()%>
            </td>
            <td align="center"><%=friend.getAddress()%>
            </td>
        </tr>
        <%
                }
            }%>
        <tr>
            <td colspan="8" align="center"><input type="submit" value="确认删除"></td>
        </tr>
    </table>
</form>

</body>
</html>
