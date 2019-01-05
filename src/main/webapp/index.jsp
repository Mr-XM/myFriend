<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="untils.TimeUntils" %>
<html>
<meta name="viewport"
      content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes"/>
<title>主页</title>
<body>
<h1>我的好友录</h1>
<%
    String userName = request.getParameter("userName");
%>
<hr>
<a href="QueryFriendServlet?userName=<%=userName%>">查询全部好友信息</a>
<br>
<a href="queryByName.jsp?userName=<%=userName%>">按姓名查询好友信息</a>
<hr>
<h4 align="center">当前时间：<%=TimeUntils.getNowTime()%>
</h4>
</body>
</html>
