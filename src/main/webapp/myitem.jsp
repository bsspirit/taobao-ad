<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ page import="org.conan.taobao.base.dao.*" %>
<%@ page import="org.conan.taobao.base.util.*" %>
<%@ page import="com.taobao.api.domain.*" %>
<%@ page import="org.conan.taobao.web.form.*" %>

<%
	PageOutObject<ItemForm> pageOut = (PageOutObject<ItemForm>)request.getAttribute("items");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">

<head>
	<title>第二步选择商品</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="theme/css/main.css">
</head>
<body>
	
	<div id="main">
		<jsp:include page="layout/header.jsp"/>
		<jsp:include page="layout/sideleft.jsp"/>
		
		<div id="content">
			<form class="items">
				<ul class="list">
					<li>
						<ul class="detail">
							<li class="box">序号</li>
							<li class="pic">图片</li>
							<li class="title">商品名 </li>
							<li class="price">价格</li>
							<li class="dtime">到期时间</li>
							<li class="ad">广告推荐</li>
						</ul>
						<div class="clear"></div>
					</li>
					
					<%
					List<ItemForm> list = pageOut.getList();
					for(int i=0;i<list.size();i++){
						ItemForm item = list.get(i);
					%>	
					<li>
						<ul class="detail">
							<li class="box"><%=i+1%></li>		
							<li class="pic"><img width="50px" align="absmiddle" src="<%=item.getPic_url()%>"/></li>
							<li class="title"><a href="<%=item.getDesc_url()%>" target="_blank"><%=item.getTitle()%></a></li>
							<li class="price"><%=item.getPrice()%></li>
							<li class="dtime"><%=item.getDtimeString()%></li>
							<li class="ad">
							<span class='red'>已加入</span>|<a href='myitem?op=del&id=<%=item.getId()%>'>取消</a>
							</li>
						</ul>
						<div class="clear"></div>
					</li>
					<%
						}
					%>
				</ul>
			</form>
		</div>
		<div class="clear"></div>
	
		<jsp:include page="layout/footer.jsp"/>
	</div>
</body>
</html>