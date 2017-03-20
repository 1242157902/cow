<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>牛只信息</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">牛只信息</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    <form action="${pageContext.request.contextPath}/addRecord.do" >
        <ul class="forminfo">
             <input name="id" type="hidden" class="dfinput" value="${record.id}" />
        <li><label>牛只编号：</label>
            <select name="cowid" class="select3">
                <c:forEach var="cow1" items="${cowList}">
                    <option value="${cow1.cowid}"
                            <c:if test="${cow1.cowid== record.cowid}">
                                selected="selected"
                            </c:if>
                            >${cow1.cowid}</option>
                </c:forEach>

            </select>

            <li>
                <label>登记日期：</label>
                <%--<input name="role" type="text" class="dfinput" value="${user.role}" />--%>
                <input name="time" type="text" class="dfinput" value="${record.time}"  placeHolder="yyyy-MM-dd" />
            </li>

            <li>
                <label>牛只状态：</label>
                <%--<input name="role" type="text" class="dfinput" value="${user.role}" />--%>
                <select name="state" class="select3">

                    <option value="1"
                            <c:if test="${record.state==1}">
                                selected="selected"
                            </c:if>
                            >配种</option>
                    <option value="2"
                            <c:if test="${record.state==2}">
                                selected="selected"
                            </c:if>
                            >产犊</option>
                    <option value="3"
                            <c:if test="${record.state==3}">
                                selected="selected"
                            </c:if>
                            >流产</option>
                </select>
            </li>
        <%--<li><label>是否审核</label><cite><input name="" type="radio" value="" checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="radio" value="" />否</cite></li>--%>
        <li><label>&nbsp;</label><input name="submit" type="submit" class="btn" value="确认保存"/></li>
        </ul>
    </form>
    
    </div>


</body>

</html>
