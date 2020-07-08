<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/12/13
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>注册界面</title>
    <link href="css/register.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="content">
    <div class="center">

        <h2>新用户注册</h2>
    </div>
    <div class="main">
        <form action="RegisterServlet" method="post">
    <table>
        <tr>
            <td>账号：</td>
            <td><input type="text" name="username"/><br></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"/><br></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="完成注册"/><br></td>
        </tr>
    </table>

        </form>

    </div>
</div>
</body>
</html>
