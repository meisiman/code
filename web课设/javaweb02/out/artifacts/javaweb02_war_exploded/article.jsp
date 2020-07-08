<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/12/11
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>博客管理主页</title>
    <link href="css/article.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <!-- 头部 -->
    <div class="head">
        <div class="navleft">
            <span class="tit">博客管理</span>
            <a href="ArticleServlet" class="select">主页</a>
            <a href="CollectListServlet" class="select">文章收藏</a>
        </div>
    </div>
    <div class="content">
        <div class="list-news">
            <br class="list-news-inline">
            <div class="display-title">${article.title }</div>
            <br>作者：${article.author }<br><br>
            <tr>
                <td>${article.context }</td>
            </tr>
        </div>
    </div>
</body>
</html>
