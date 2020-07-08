<%@ page import="domain.User" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/9
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>博客管理主页</title>
    <link href="css/index.css" rel="stylesheet" type="text/css" />
</head>

<body>
<!-- 头部 -->
<div class="head">
    <div class="navleft">
        <span class="tit">博客管理</span>
        <a href="ArticleServlet" class="select">主页</a>
        <a href="CollectListServlet" class="select">文章收藏</a>
        <a href="add.jsp" class="select">添加文章</a>
    </div>
    <form action="SearchServlet" method="post" class="navright">
        <input class="searchBtn" aria-label="请输入搜索内容" type="text" placeholder="文章标题" accesskey="s" name="title" >
        <input type="submit" value="搜索" class="searchBtn2">
    </form>
</div>
<div class="content">
    <div class="img">
        <img src="images/chat2.png" width="100%" height="300px">
    </div>
    <div class="id">
        <h2>登录成功，欢迎您！${user.username }</h2>
    </div>
    <div class="ifmation" >
        <table  width=100% cellspacing="0" cellpadding="0" height=600px class="tbody">
            <tr>
                <th colspan="4" class="green"> 系统统计</th>
            </tr>
            <tr align="center" class="search">
                <td>编号</td>
                <td>文章标题</td>
                <td>作者</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${list }" var="article">
                <tr align="center" class="bgGreen">
                    <td>${article.id }</td>
                    <td><a href="ShowServlet?id=${article.id }">${article.title }</a></td>
                    <td>${article.author }</td>
                    <td>
                        <a href="BeforeEditServlet?id=${article.id }">修改</a>
                        <a href="DeleteServlet?id=${article.id }">删除</a>
                        <a href="CollectServlet?id=${article.id }" onclick=alert("收藏成功")>收藏</a>
                    </td>
                </tr>
            </c:forEach>


            <tr align="center"><td colspan="4">有文章${number }篇</td></tr>
        </table>
    </div>
</div>
</body>
</html>
