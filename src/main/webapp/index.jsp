<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2017/2/13
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>欢迎登录后台管理系统</title>
  <link href="/jsp/css/style.css" rel="stylesheet" type="text/css" />
  <script language="JavaScript" src="/jsp/js/jquery.js"></script>
  <script src="/jsp/js/cloud.js" type="text/javascript"></script>

  <script language="javascript">
    $(function(){
      $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
      $(window).resize(function(){
        $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
      })
    });
  </script>

</head>

<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



<div id="mainBody">
  <div id="cloud1" class="cloud"></div>
  <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
  <span>欢迎登录后台管理界面平台</span>
  <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
  </ul>
</div>

<div class="loginbody">

  <span class="systemlogo"></span>
<form action="/login.do">
  <div class="loginbox">

    <ul>
      <li><input name="loginName" type="text" class="loginuser" value="admin" onclick="JavaScript:this.value=''"/></li>
      <li><input name="password" type="password" class="loginpwd" value="123456" onclick="JavaScript:this.value=''"/></li>
      <li><input name="submit" type="submit" class="loginbtn" value="登录"     /><label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label></li>
    </ul>

  </div>
</form>

</div>



<div class="loginbm">版权所有  2017  <a href="http://www.uimaker.com"></a>  仅供学习交流，勿用于任何商业用途</div>


</body>

</html>
