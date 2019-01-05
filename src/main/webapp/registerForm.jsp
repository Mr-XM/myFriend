<%@ page import="javax.xml.crypto.Data" %><%--
  Created by IntelliJ IDEA.
  User: zhangyinghao
  Date: 2018/12/10
  Time: 上午1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="untils.TimeUntils" %>
<html>
<head>
    <title>注册界面</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes"/>
</head>
<body>
<h1>我的好友录</h1>
<hr>
<h4>用户注册</h4>
<form name="registerForm" action="/RegisterServlet" method="post" onsubmit="checkRegister()">
    <table align="center">
        <tr>
            <td align="right">登录名称：</td>
            <td align="left"><input type="text" name="loginName"></td>
        </tr>
        <tr>
            <td align="right">登录密码：</td>
            <td align="left"><input type="password" name="loginPassword"></td>
        </tr>
        <tr>
            <td align="right">密码确认：</td>
            <td align="left"><input type="password" name="passwordConfirm"></td>
        </tr>
        <tr>
            <td align="right"><input type="submit" value="注册"></td>
            <td align="left"><input type="reset" value="重置"></td>
        </tr>
    </table>
    <hr>
    <h4 align="center">当前时间：<%=TimeUntils.getNowTime()%>
    </h4>
</form>
</body>
<script language="JavaScript">
    function checkRegister() {
        if (document.registerForm.loginName.value == null) {
            alert("请输入用户名！");
            return false;
        }
        if (document.registerForm.loginPassword.value == null) {
            alert("请输入密码！");
            return false;
        }
        if (document.registerForm.passwordConfirm.value != document.registerForm.loginPassword.value) {
            alert("两次密码不一致！");
            return false;
        }
        return true;
    }
</script>
</html>
