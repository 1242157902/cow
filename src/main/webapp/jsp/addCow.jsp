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
    <form action="${pageContext.request.contextPath}/addCow.do" >
        <ul class="forminfo">
             <input name="cowid" type="hidden" class="dfinput" value="${cow.cowid}" />
        <li><label>品种名称：</label>
            <select name="cowcategory" class="select3">
                <c:forEach var="category" items="${categoryList}">
                    <option value="${category.id}"
                            <c:if test="${cow.cowcategory== category.id}">
                                selected="selected"
                            </c:if>
                            >${category.categoryname}</option>
                </c:forEach>

            </select>
        </li>
            <li>
                <label>性别：</label>
                <%--<input name="role" type="text" class="dfinput" value="${user.role}" />--%>
                <select name="sex" class="select3">
                    <option value="1"
                            <c:if test="${cow.sex==1}">
                                selected="selected"
                            </c:if>
                            >公</option>
                    <option value="2"
                            <c:if test="${cow.sex==2}">
                                selected="selected"
                            </c:if>
                            >母</option>


                </select>
            </li>

            <li>
                <label>牛舍：</label>
                <%--<input name="role" type="text" class="dfinput" value="${user.role}" />--%>
                <select name="houseid" class="select3">
                    <c:forEach var="house" items="${cowHouseList}">
                        <option value="${house.houseid}"
                                <c:if test="${cow.houseid== house.houseid}">
                                    selected="selected"
                                </c:if>
                                >${house.houseid}</option>
                    </c:forEach>

                </select>
            </li>

            <li>
                <label>出生日期：</label>
                <%--<input name="role" type="text" class="dfinput" value="${user.role}" />--%>
                <input name="birthday" type="text" class="dfinput" value="${cow.birthday}"  placeHolder="yyyy-MM-dd" />
            </li>
            <li>
                <label>入场日期：</label>
                <%--<input name="role" type="text" class="dfinput" value="${user.role}" />--%>
                <input name="indate" type="text" class="dfinput" value="${cow.indate}" placeHolder="yyyy-MM-dd" />
            </li>

            <li>
                <label>体重：</label>
                <%--<input name="role" type="text" class="dfinput" value="${user.role}" />--%>
                <input name="weight" type="text" class="dfinput" value="${cow.weight}"  />
            </li>
            <li>
                <label>入场体重：</label>
                <%--<input name="role" type="text" class="dfinput" value="${user.role}" />--%>
                <input name="inweight" type="text" class="dfinput" value="${cow.inweight}"  />
            </li>
            <li>
                <label>牛只状态：</label>
                <%--<input name="role" type="text" class="dfinput" value="${user.role}" />--%>
                <select name="state" class="select3">

                    <option value="1"
                            <c:if test="${cow.state==1}">
                                selected="selected"
                            </c:if>
                            >正常</option>
                    <option value="2"
                            <c:if test="${cow.state==2}">
                                selected="selected"
                            </c:if>
                            >离场</option>
                    <option value="3"
                            <c:if test="${cow.state==3}">
                                selected="selected"
                            </c:if>
                            >删除</option>
                </select>
            </li>
        <%--<li><label>是否审核</label><cite><input name="" type="radio" value="" checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="radio" value="" />否</cite></li>--%>
        <li><label>&nbsp;</label><input name="submit" type="submit" class="btn" value="确认保存"/></li>
        </ul>
    </form>
    
    </div>


</body>

</html>
