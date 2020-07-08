<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/12/15
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>收藏界面</title>
    <link href="css/collect.css" rel="stylesheet" type="text/css" />
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
    <form action="" method="post">
        <table width="600" border="1">
            <tr align="center">
                <td>编号</td>
                <td>标题</td>
                <td>作者</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${list }" var="article">
                <tr align="center">
                    <td>${article.id }</td>
                    <td><a href="ShowServlet?id=${article.id }">${article.title }</a></td>
                    <td>${article.author }</td>
                    <td><a href="DeleteCollectServlet?id=${article.id }">取消收藏</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>
    </div>
</body>
</html>
