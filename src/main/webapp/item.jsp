<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ page import="org.conan.taobao.base.dao.*" %>
<%@ page import="org.conan.taobao.web.util.*" %>
<%@ page import="com.taobao.api.domain.*" %>

<%@ page import="org.conan.taobao.web.form.*" %>

<%
	PageOut<ItemForm> pageOut = (PageOut<ItemForm>)request.getAttribute("items");
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
				<div class="page-top">
					<%
						StringBuilder sb = new StringBuilder();
						if(pageOut.getPageNow()>1){
							sb.append("&nbsp;&nbsp;<a href='item?p="+pageOut.getFirstPage()+"'>首页</a>");
							sb.append("&nbsp;&nbsp;<a href='item?p="+pageOut.getPreviousPage()+"'>上一页</a>");
							sb.append("&nbsp;&nbsp;");
						}
						
						sb.append("第&nbsp;"+pageOut.getItemBegin() +"&nbsp;-&nbsp;"+pageOut.getItemEnd()+"&nbsp;个" );
						
						if(pageOut.getPageNow()<pageOut.getPageCount()){
							sb.append("&nbsp;&nbsp;<a href='item?p="+pageOut.getNextPage()+"'>下一页</a>");
							sb.append("&nbsp;&nbsp;<a href='item?p="+pageOut.getLastPage()+"'>末页</a>");
						}
						sb.append("&nbsp;&nbsp;共"+pageOut.getPageCount()+"页");
						sb.append(pageOut.getCount()+"个商品");
						out.println(sb.toString());
					%>
				</div>  
			
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
							<li class="box"><%=i+pageOut.getItemBegin()%></li>		
							<li class="pic"><img width="50px" align="absmiddle" src="<%=item.getPic_url()%>" /></li>
							<li class="title"><a href="<%=item.getDesc_url()%>" target="_blank"><%=item.getTitle()%></a></li>
							<li class="price"><%=item.getPrice()%></li>
							<li class="dtime"><%=item.getDtimeString()%></li>
							<li class="ad">
							<%
								if(item.isStatus()){
									out.println("<span class='red'>已加入</span>|<a href='item?op=del&p="+pageOut.getPageNo()+"&id="+item.getId()+"'>取消</a>");
								}else{
									out.println("<a href='item?op=save&p="+pageOut.getPageNo()+"&item="+item.getItemid()+"'><span class='blue'>加入</span></a>");
								}
							%>
							</li>
						</ul>
						<div class="clear"></div>
					</li>
					<%
						}
					%>
				</ul>
				<div class="page-bom">
					<%=sb.toString()%>
				</div> 
			</form>
		</div>
		<div class="clear"></div>
	
		<jsp:include page="layout/footer.jsp"/>
	</div>
</body>
</html>