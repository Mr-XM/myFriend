<%--
  Created by IntelliJ IDEA.
  User: zhangyinghao
  Date: 2018/12/13
  Time: 下午1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加朋友</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes"/>
</head>
<body>
<h1 align="center">请输入朋友的信息</h1>
<%
    String userName=request.getParameter("userName");
%>
<form name="addForm" action="/AddFriendServlet" method="post" onsubmit="return checkAddForm()">
    <table align="center" width="100%">
        <input type="hidden" name="userName" value="<%=userName%>">
        <table align="center" width="100%">
            <tr>
                <td align="right">姓名：</td>
                <td align="left"><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td align="right">性别：</td>
                <td align="left"><input type="radio" value="M" name="sex"/>男&nbsp;
                    <input type="radio" value="F" name="sex"/>女&nbsp;</td>
            </tr>
            <tr>
                <td align="right">年龄：</td>
                <td align="left"><input type="text" name="age"/></td>
            </tr>
            <tr>
                <td align="right">QQ：</td>
                <td align="left"><input type="text" name="qq"/></td>
            </tr>
            <tr>
                <td align="right">电话：</td>
                <td align="left"><input type="text"  name="telephone" /></td>
            </tr>
            <tr>
                <td align="right">EMail：</td>
                <td align="left"><input type="text" name="email" /></td>
            </tr>
            <tr>
                <td align="right">地址：</td>
                <td align="left"><input type="text" name="address"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="确定"></td>
            </tr>
        </table>
    </table>
</form>
<script language="JavaScript">
    function checkAddForm() {
        if(document.addForm.name.value==""){
            alert("请输入名子！") ;
            return false;
        }
        if(document.addForm.sex.value==""){
            alert("请选择性别！") ;
            return false;
        }
        if(document.addForm.age.value==""){
            alert("请输入年龄！") ;
            return false;
        }
        var getNumber =/^\d+$/;
        if(!getNumber.test(document.age.number.value)){
            alert("年龄是数值型");
            return false;
        }
        if(document.addForm.address.value==""){
            alert("请输入地址！") ;
            return false;
        }
        if(document.addForm.qq.value==""){
            alert("请输入qq！") ;
            return false;
        }
        if(document.addForm.email.value==""){
            alert("请输入email！") ;
            return false;
        }
        if(document.addForm.telephone.value==""){
            alert("请输入电话号码！") ;
            return false;
        }
        return true;
    }
</script>
</body>
</html>
