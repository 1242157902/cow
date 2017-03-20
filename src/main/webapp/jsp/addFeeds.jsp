<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>入库信息</title>
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
    <form action="${pageContext.request.contextPath}/addFeeds.do" >
        <ul class="forminfo">
             <input name="id" type="hidden" class="dfinput" value="${feeds.cowid}" />
        <li><label>饲料品牌：</label>
            <select name="feedid" class="select3">
                <c:forEach var="fc" items="${feedCategoryList}">
                    <option value="${fc.feedid}"
                            <c:if test="${feeds.feedid== fc.feedid}">
                                selected="selected"
                            </c:if>
                            >${fc.feedname}</option>
                </c:forEach>

            </select>
        </li>
            <li>
                <label>数量：</label>
                <input name="num" type="text" class="dfinput" value="${user.role}" />
            </li>

            <li>
                <label>单位：</label>
                <input name="unit" type="text" class="dfinput" value="公斤" placeholder="公斤" />
            </li>

            <li>
                <label>价格：</label>
                <%--<input name="role" type="text" class="dfinput" value="${user.role}" />--%>
                <input name="price" type="text" class="dfinput" value="${cow.birthday}"    />
            </li>
            <li>
                <label>生产厂商：</label>
                <%--<input name="role" type="text" class="dfinput" value="${user.role}" />--%>
                <input name="manufacturer" type="text" class="dfinput" value="${cow.inweight}"  />
            </li>
            <li>
                <label>状态：</label>
                <%--<input name="role" type="text" class="dfinput" value="${user.role}" />--%>
                <select name="state" class="select3">

                    <option value="1"
                            <c:if test="${cow.state==1}">
                                selected="selected"
                            </c:if>
                            >入库</option>
                    <option value="2"
                            <c:if test="${cow.state==2}">
                                selected="selected"
                            </c:if>
                            >出库</option>
                </select>
            </li>
        <%--<li><label>是否审核</label><cite><input name="" type="radio" value="" checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="radio" value="" />否</cite></li>--%>
        <li><label>&nbsp;</label><input name="submit" type="submit" class="btn" value="确认保存"/></li>
        </ul>
    </form>
    
    </div>


</body>

</html>
