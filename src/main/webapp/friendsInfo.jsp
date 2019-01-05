<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="untils.Friend" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="untils.SqlHelper" %>
<html>
<head>
    <title>我的好友录</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes"/>
</head>
<body>
<%
    String userName = request.getParameter("userName");
    //List<Friend> list= SqlHelper.getAllFriend(1);
    ArrayList<Friend> list = (ArrayList) request.getAttribute("list");
%>
<h1>我的好友录</h1>
<a href="addFriend.jsp?userName=<%=userName%>">添加新好友</a>&nbsp;
<a href="#" onclick="updateFriend()">修改选中好友</a>&nbsp;
<a href="#" onclick="deleteFriend()">删除选中好友</a>&nbsp;
<a href="index.jsp?userName=<%=userName%>">返回主页</a>&nbsp;
<a href="loginForm.jsp">注销</a>
<hr>
<form name="friendInfoForm" method="post">
    <input type="hidden" name="userName" value="<%=userName%>">
    <table align="center" width="100%">
        <th>修改</th>
        <th>删除</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>QQ</th>
        <th>电话</th>
        <th>Email</th>
        <th>地址</th>
        <%
            for (int i = 0; i < list.size(); i++) {
        %>
        <tr>
            <td align="center"><input type="radio" name="change" value="<%=list.get(i).getId()%>"></td>
            <td align="center"><input type="checkbox" name="deleteFriend" value="<%=list.get(i).getId()%>"></td>
            <td align="center"><%=list.get(i).getName()%>
            </td>
            <td align="center"><%=list.get(i).getSex()%>
            </td>
            <td align="center"><%=list.get(i).getAge()%>
            </td>
            <td align="center"><%=list.get(i).getQq()%>
            </td>
            <td align="center"><%=list.get(i).getTelephone()%>
            </td>
            <td align="center"><%=list.get(i).getEmail()%>
            </td>
            <td align="center"><%=list.get(i).getAddress()%>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</form>
</body>
<script language="JavaScript">
    function updateFriend() {
        document.friendInfoForm.action = "updateFriendForm.jsp";
        var flag = false;
        var names = document.getElementsByName("change");
        for (var i = 0; i < names.length; i++) {
            if (names[i].checked) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            alert("请选择要修改的好友！");
        } else {
            document.friendInfoForm.submit();
        }
    }

    function deleteFriend() {
        document.friendInfoForm.action = "deleteFriendForm.jsp";
        var names = document.getElementsByName("deleteFriend");
        var flag = false;
        for (var i = 0; i < names.length; i++) {
            if (names[i].checked) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            alert("请选择要删除的好友！");
        } else {
            document.friendInfoForm.submit();
        }
    }
</script>
</html>
