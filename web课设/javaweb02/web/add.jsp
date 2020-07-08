<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/12/11
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>发布文章页面</title>
    <link href="css/article.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <!-- 头部 -->
    <div class="head">
        <div class="navleft">
            <span class="tit">博客管理</span>
            <a href="ArticleServlet" class="select">主页</a>
            <a href="#" class="select">文章管理</a>
        </div>
    </div>
    <div class="content">

        <form class="content" action="AddServlet" method="post">
        <table>
            <tr>
                <td class="menu">文章标题：</td>
                <td><input type="text" name="title"/><br></td>
            </tr>
            <tr>
                <td class="menu">作者：</td>
                <td><input type="text" name="author"/><br></td>
            </tr>
            <tr>
                <td class="menu">内容：</td>
                <td><textarea name="context" rows="5" cols="50"></textarea></td>
            </tr>
            <tr>
                <td colspan="2"> <input type="submit" value="添加"> </td>
            </tr>
        </table>

        </form>
    </div>
</body>
</html>
