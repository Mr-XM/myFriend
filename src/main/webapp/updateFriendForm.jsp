<%@ page import="untils.Friend" %>
<%@ page import="untils.SqlHelper" %><%--
  Created by IntelliJ IDEA.
  User: zhangyinghao
  Date: 2018/12/13
  Time: 上午9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes"/>
    <title>更新朋友信息</title>
</head>
<body>
<%
    String userName = request.getParameter("userName");
    String change = request.getParameter("change");
    Friend friend = SqlHelper.getFriend(Integer.parseInt(change));
%>
<h3 align="center">请重新编辑好友信息</h3>
<hr>
<br>
<br>
<br>
<form action="/UpdateFriendServlet" method="post">
    <input type="hidden" name="userid" value="<%=friend.getUserid()%>">
    <input type="hidden" name="id" value="<%=friend.getId()%>">
    <input type="hidden" name="userName" value="<%=userName%>">
    <table align="center" width="100%">
        <tr>
            <td align="right">姓名：</td>
            <td align="left"><input type="text" name="name" value="<%=friend.getName()%>"></td>
        </tr>
        <tr>
            <td align="right">性别：</td>
            <td align="left"><%
                if ("M".equals(friend.getSex())) {
            %>
                <input type="radio" value="M" checked="checked" name="sex"/>男&nbsp;
                <input type="radio" value="F" name="sex"/>女&nbsp;
                <%
                } else {%>
                <input type="radio" value="M" name="sex"/>男&nbsp;
                <input type="radio" value="F" checked="checked" name="sex"/>女&nbsp;
                <%
                    }
                %>
            </td>
        </tr>
        <tr>
            <td align="right">年龄：</td>
            <td align="left"><input type="text" name="age" value="<%=friend.getAge()%>"></td>
        </tr>
        <tr>
            <td align="right">QQ：</td>
            <td align="left"><input type="text" name="qq" value="<%=friend.getQq()%>"></td>
        </tr>
        <tr>
            <td align="right">电话：</td>
            <td align="left"><input type="text" name="telephone" value="<%=friend.getTelephone()%>"></td>
        </tr>
        <tr>
            <td align="right">EMail：</td>
            <td align="left"><input type="text" name="email" value="<%=friend.getEmail()%>"></td>
        </tr>
        <tr>
            <td align="right">地址：</td>
            <td align="left"><input type="text" name="address" value="<%=friend.getAddress()%>"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="确定"></td>
        </tr>
    </table>
</form>

</body>
</html>
