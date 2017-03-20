<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>员工管理</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">员工管理</a></li>
    <li><a href="#">基本内容</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    <%--	<ul class="toolbar">
        <li class="click"><span><img src="images/t01.png" /></span>添加</li>
        <li class="click"><span><img src="images/t02.png" /></span>修改</li>
        <li><span><img src="images/t03.png" /></span>删除</li>
        <li><span><img src="images/t04.png" /></span>统计</li>
        </ul>--%>

        <form action="${pageContext.request.contextPath}/getUserList.do">

            <ul class="toolbar">

                <li><label>用户名：</label></li><input name="name" type="text" class="scinput1" />
                <input name="submit" type="submit" class="scbtn" value="查询"/>

            </ul>
        </form>
        
        
        <ul class="toolbar1">
        <li><span><img src="images/t05.png" /></span>设置</li>
        </ul>
    
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>员工编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>员工姓名</th>
        <th>员工角色</th>
        <th>登录名</th>
        <th>注册时间</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="user">
            <tr>
            <td><input name="" type="checkbox" value="" /></td>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>
                <c:if test="${user.role==1}">
                    管理员
                </c:if>
                <c:if test="${user.role==2}">
                    饲养员
                </c:if>
                <c:if test="${user.role==3}">
                    兽医
                </c:if>
            </td>
            <td>${user.loginname}</td>
            <td>${user.time}</td>

            <td><a href="${pageContext.request.contextPath}/jsp/addUser.jsp" class="tablelink">新增</a>   <a href="${pageContext.request.contextPath}/updateUser.do?userId=${user.id}" class="tablelink">修改</a>  <a href="${pageContext.request.contextPath}/deleteUser.do?userId=${user.id}" class="tablelink">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    
   
    <div class="pagin">
        <c:if test="${page!=null}">
            <div class="message">共<i class="blue">${pageInfo.total}</i>条记录，当前显示第&nbsp;<i class="blue">${pageInfo.pageNum}&nbsp;</i>页</div>
            <ul class="paginList">
            <c:if test="${pageInfo.hasPreviousPage}">
                <li class="paginItem"><a href="${pageContext.request.contextPath}/getUserList.do?page=${pageInfo.prePage}&rows=${pageInfo.pageSize}"><span class="pagepre"></span></a></li>
            </c:if>
           <c:choose>
               <c:when test="${fn:length(pageInfo.navigatepageNums)<10}">
                   <c:forEach items="${pageInfo.navigatepageNums}" var="nav">
                       <c:if test="${nav == pageInfo.pageNum}">
                           <li class="paginItem" style="font-weight: bold;"><a href="javascript:;">${nav}</a></li>
                       </c:if>
                       <c:if test="${nav != pageInfo.pageNum}">
                           <li class="paginItem"><a href="${pageContext.request.contextPath}/getUserList.do?page=${nav}&rows=${pageInfo.pageSize}">${nav}</a></li>
                       </c:if>
                   </c:forEach>
               </c:when>
               <c:otherwise>
                   <c:forEach items="10" var="nav">
                       <c:if test="${nav == pageInfo.pageNum}">
                           <li class="paginItem" style="font-weight: bold;"><a href="javascript:;">${nav}</a></li>
                       </c:if>
                       <c:if test="${nav != pageInfo.pageNum}">
                           <li class="paginItem"><a href="${pageContext.request.contextPath}/getUserList.do?page=${nav}&rows=${pageInfo.pageSize}">${nav}</a></li>
                       </c:if>
                   </c:forEach>
               </c:otherwise>
           </c:choose>



            <c:if test="${pageInfo.hasNextPage}">
                 <li class="paginItem"><a href="${pageContext.request.contextPath}/getUserList.do?page=${pageInfo.nextPage}&rows=${pageInfo.pageSize}"><span class="pagenxt"></span></a></li>
            </c:if>
            </ul>
        </c:if>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
            <div class="tipright">
            <p>是否确认对信息的修改 ？</p>
            <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
            </div>
      </div>
      <div class="tipbtn">
            <input name="" type="button"  class="sure" value="确定" />&nbsp;
            <input name="" type="button"  class="cancel" value="取消" />
      </div>
    
    </div>

 <%--       <div class="tip">
            <div class="tiptop"><span>提示信息</span><a></a></div>

            <div class="tipinfo">
                <span><img src="images/ticon.png" /></span>
                <div class="tipright">
                    <p>是否确认对信息的修改 ？</p>
                    <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
                </div>
            </div>

            <div class="tipbtn">
                <input name="" type="button"  class="sure" value="确定" />&nbsp;
                <input name="" type="button"  class="cancel" value="取消" />
            </div>

        </div>--%>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
