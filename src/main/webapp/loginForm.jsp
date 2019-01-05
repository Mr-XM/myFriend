<%--
  Created by IntelliJ IDEA.
  User: zhangyinghao
  Date: 2018/12/9
  Time: 下午9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="untils.TimeUntils" %>
<html>
<head>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes"/>
    <title>登录页面</title>
</head>
<h1>我的好友录</h1>
<hr>
<h4>用户登录：</h4>
<%
    Cookie[] cookies = request.getCookies();
    String userName = "";
    String userPassword = "";
    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("userName")) {
                userName = cookies[i].getValue();
            }
            if (cookies[i].getName().equals("userPassword")) {
                userPassword = cookies[i].getValue();
            }
        }
    }
%>
<form name="loginForm" action="/LoginServlet" method="post" onsubmit="return checkForm()">
    <table align="center" border="0">
        <tr>
            <td align="right">用户名称：</td>
            <td align="left"><input type="text" name="userName" value="<%=userName%>"></td>
        </tr>
        <tr>
            <td align="right">用户密码：</td>
            <td align="left"><input type="password" name="userPassword" value="<%=userPassword%>"></td>
        </tr>
        <tr>
            <td align="right"><input type="checkbox" name="mySelect" value="自动记录名称" checked="checked"></td>
            <td align="left">自动记录名称</td>
        </tr>
        <tr>
            <td align="right"><input type="checkbox" name="mySelect" value="自动记录密码" checked="checked"></td>
            <td align="left">自动记录密码</td>
        </tr>
        <tr>
            <td align="right"><input type="submit" value="登录"/></td>
            <td align="left"><input type="reset" value="重置"/>&nbsp;<a href="registerForm.jsp">注册</a></td>
        </tr>
    </table>
    <hr>
    <h4 align="center">当前时间：<%=TimeUntils.getNowTime()%>
    </h4>
</form>
</body>
<script language="JavaScript">
    function checkForm() {
        if (document.loginForm.userName.value == "") {
            alert("账号不能为空！");
            return false;
        }
        if (document.loginForm.userPassword.value == "") {
            alert("密码不能为空！");
            return false;
        }
        return true;
    }
</script>
</html>

