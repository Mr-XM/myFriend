<%--
  Created by IntelliJ IDEA.
  User: zhangyinghao
  Date: 2018/12/12
  Time: 下午3:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="untils.TimeUntils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes"/>
    <title>按姓名查询好友信息</title>
</head>
<body>
<h1>我的好友录</h1>
<hr>
<%
    String userName = request.getParameter("userName");
%>
<form action="/QueryFriendServlet" method="post">
    <input type="hidden" name="userName" value="<%=userName%>"/>
    <div align="center"><input type="text" name="queryText"/><input type="submit" value="查询">&nbsp;&nbsp;
        <a href="index.jsp?userId=<%=userName%>">返回主页</a>&nbsp;&nbsp;<a href="loginForm.jsp">注销</a></div>
</form>
<br>
<br>
<hr>
<h4 align="center">当前时间：<%=TimeUntils.getNowTime()%>
</h4>
</body>
</html>
