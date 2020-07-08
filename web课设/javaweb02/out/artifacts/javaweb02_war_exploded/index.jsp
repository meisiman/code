<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/30
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>admin</title>
  <link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<script>
  function check() {
    if(document.getElementById("login_id").value=="") {
      alert("没有输入用户名!");
      return false;
    } else if(document.getElementById("password").value=="") {
      alert("没有输入密码！");
      return false;
    } else if(document.getElementById("login_id").value!="admin"||document.getElementById("password").value!="admin"){
            alert("用户名或密码不正确");
            return false;
    }
    /*else if(document.getElementById("login_id").value=="admin"&&document.getElementById("password").value=="admin"){
      location.href = "LoginServlet";
      return true;
    }*/
  }
</script>
<body>
<div class="content">
  <div class="header">
    <p>博客管理系统</p>
  </div>
  <div class="Login">
    <div class="imgs" >
      <img src="images/chat.jpg" width="800px" height="600px">
    </div>
    <div class="login" >
      <form id="frmUserLogin" action="LoginServlet" method="post">
        <div class="divContent">
          <div class="account">
            <span class="text">账号</span>
            <input class="txt" name="username" id="login_id" type="text" placeholder="请输入用户名">
          </div>
          <div class="psd">
            <span class="text">密码</span>
            <input class="txt" name="password" id="password" type="password" placeholder="请输入密码">
          </div>
          <div class="buttons">
            <input type="submit" id="Login" value="登录" onclick="check(form);">
            <input type="submit" id="Login2" value="注册" onclick="window.open('register.jsp')"></input>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
