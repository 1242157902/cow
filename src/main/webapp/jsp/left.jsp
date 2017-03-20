<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson .header").click(function(){
		var $parent = $(this).parent();
		$(".menuson>li.active").not($parent).removeClass("active open").find('.sub-menus').hide();
		
		$parent.addClass("active");
		if(!!$(this).next('.sub-menus').size()){
			if($parent.hasClass("open")){
				$parent.removeClass("open").find('.sub-menus').hide();
			}else{
				$parent.addClass("open").find('.sub-menus').show();	
			}
			
			
		}
	});
	
	// 三级菜单点击
	$('.sub-menus li').click(function(e) {
        $(".sub-menus li.active").removeClass("active")
		$(this).addClass("active");
    });
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('.menuson').slideUp();
		if($ul.is(':visible')){
			$(this).next('.menuson').slideUp();
		}else{
			$(this).next('.menuson').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#fff3e1;">
	<div class="lefttop"><span></span>导航栏</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>牛场管理
    </div>
    	<ul class="menuson">
        
        <li>
            <div class="header">
            <cite></cite>
            <a href="/getCategoryList.do" target="rightFrame">品种管理</a>
            <i></i>
            </div>
            <!--<ul class="sub-menus">
            <li><a href="javascript:;">文件管理</a></li>
            <li><a href="javascript:;">模型信息配置</a></li>
            <li><a href="javascript:;">基本内容</a></li>
            <li><a href="javascript:;">自定义</a></li>
            </ul>-->
        </li>
        
        <li>
            <div class="header">
            <cite></cite>
            <a href="/getHouseList.do" target="rightFrame">牛舍管理</a>
            <i></i>
            </div>                
           <!-- <ul class="sub-menus">
            <li><a href="javascript:;">文件数据</a></li>
            <li><a href="javascript:;">学生数据列表</a></li>
            <li><a href="javascript:;">我的数据列表</a></li>
            <li><a href="javascript:;">自定义</a></li>
            </ul>-->
        </li>
        
        <li class="active"><cite></cite><a href="/getUserList.do" target="rightFrame">员工管理</a><i></i></li>
        <li><cite></cite><a href="/getCowList.do" target="rightFrame">牛只管理</a><i></i></li>
        <li><cite></cite><a href="form.html" target="rightFrame">场内移动</a><i></i></li>

        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="images/leftico02.png" /></span>繁殖管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="/getRecordList.do" target="rightFrame">配种登记</a><i></i></li>
        <li><cite></cite><a href="/getRecordList.do" target="rightFrame">产犊登记</a><i></i></li>
        <li><cite></cite><a href="/getRecordList.do" target="rightFrame">流产登记</a><i></i></li>
        <!--<li><cite></cite><a href="tech.html" target="rightFrame">技术支持</a><i></i></li>-->
        </ul>     
    </dd>
    <dd>
        <div class="title">
            <span><img src="images/leftico02.png" /></span>饲料管理
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="flow.html" target="rightFrame">饲料入库</a><i></i></li>
            <li><cite></cite><a href="project.html" target="rightFrame">饲料出库</a><i></i></li>
            <li><cite></cite><a href="search.html" target="rightFrame">饲料库存明细</a><i></i></li>
            <li><cite></cite><a href="/getFeedCategoryList.do" target="rightFrame">饲料品牌管理</a><i></i></li>
        </ul>
    </dd>



        <dd><div class="title"><span><img src="images/leftico03.png" /></span>生长管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="#">个体月体重日记</a><i></i></li>
        <li><cite></cite><a href="#">栏舍饲养饲料配方</a><i></i></li>
        <li><cite></cite><a href="#">饲料转化效率</a><i></i></li>
        <li><cite></cite><a href="#">饲养明细查询</a><i></i></li>
		<li><cite></cite><a href="#">饲养信息统计</a><i></i></li>
        <li><cite></cite><a href="#">体重体尺测量登记</a><i></i></li>
        <li><cite></cite><a href="#">体重体尺查询</a><i></i></li>
    </ul>    
    </dd>  
    
    
    <dd><div class="title"><span><img src="images/leftico04.png" /></span>出栏管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="#">成本测定查询</a><i></i></li>
        <li><cite></cite><a href="#">超声波测定查询</a><i></i></li>
        <!--<li><cite></cite><a href="#">信息列表</a><i></i></li>
        <li><cite></cite><a href="#">其他</a><i></i></li>-->
    </ul>
    
    </dd>   
	
<%--	  <dd><div class="title"><span><img src="images/leftico04.png" /></span>饲料</div>
    <ul class="menuson">
        <li><cite></cite><a href="#">饲料入库管理</a><i></i></li>
        <li><cite></cite><a href="#">饲料出库管理</a><i></i></li>
        <li><cite></cite><a href="#">饲料信息</a><i></i></li>
        <li><cite></cite><a href="#">栏舍饲料耗量日记</a><i></i></li>
    </ul>
    
    </dd>  --%>
	
	  <dd><div class="title"><span><img src="images/leftico04.png" /></span>疫病防控</div>
    <ul class="menuson">
        <li><cite></cite><a href="#">帮虫日记</a><i></i></li>
        <li><cite></cite><a href="#">牛栏清毒</a><i></i></li>
        <li><cite></cite><a href="#">疫病分析</a><i></i></li>
        <li><cite></cite><a href="#">检疫分析</a><i></i></li>
		<li><cite></cite><a href="#">免疫分析</a><i></i></li>
        <li><cite></cite><a href="#">牛舍消毒查询</a><i></i></li>
    </ul>
    
    </dd>  
	
	
	  <dd><div class="title"><span><img src="images/leftico04.png" /></span>库存管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="#">基本信息维护</a><i></i></li>
        <li><cite></cite><a href="#">入库管理</a><i></i></li>
        <li><cite></cite><a href="#">出库管理</a><i></i></li>
        <li><cite></cite><a href="#">盘点管理</a><i></i></li>
		<li><cite></cite><a href="#">明细项目查询</a><i></i></li>
        <li><cite></cite><a href="#">物资月末填耗查询</a><i></i></li>
        <li><cite></cite><a href="#">物资消耗查询</a><i></i></li>
    </ul>
    
    </dd>  
	
	
	  <dd><div class="title"><span><img src="images/leftico04.png" /></span>我的面板</div>
    <ul class="menuson">
        <li><cite></cite><a href="#">我的信息</a><i></i></li>
        <li><cite></cite><a href="#">常用资料</a><i></i></li>
        <li><cite></cite><a href="#">信息列表</a><i></i></li>
        <li><cite></cite><a href="#">其他</a><i></i></li>
    </ul>
    
    </dd>  
    
    </dl>
    
</body>
</html>
