<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">信息用户</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    <form action="${pageContext.request.contextPath}/addUser.do" >
        <ul class="forminfo">
             <input name="id" type="hidden" class="dfinput" value="${user.id}" />
        <li><label>员工姓名</label><input name="name" type="text" class="dfinput" value="${user.name}" /></li>
        <li>
            <label>员工角色</label>
            <%--<input name="role" type="text" class="dfinput" value="${user.role}" />--%>
            <select name="role" class="select3">

                <option value="1"
                        <c:if test="${user.role==1}">
                        selected="selected"
                              </c:if>
                                >管理员</option>
                <option value="2"
                        <c:if test="${user.role==2}">
                            selected="selected"
                        </c:if>
                        >饲养员</option>
                <option value="3"
                        <c:if test="${user.role==3}">
                            selected="selected"
                        </c:if>
                        >兽医</option>
            </select>
        </li>
        <%--<li><label>是否审核</label><cite><input name="" type="radio" value="" checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="radio" value="" />否</cite></li>--%>
        <li><label>登陆名</label><input name="loginname" type="text" class="dfinput" value="${user.loginname}" /></li>
        <li><label>登陆密码</label><input name="password" type="text" class="dfinput" value="${user.password}" /></li>
        <%--<li><label>登陆密码</label><textarea name="" cols="" rows="" class="textinput"></textarea></li>--%>
        <li><label>&nbsp;</label><input name="submit" type="submit" class="btn" value="确认保存"/></li>
        </ul>
    </form>
    
    </div>


</body>

</html>
