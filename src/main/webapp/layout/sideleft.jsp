<%@ page contentType="text/html;charset=utf-8" %>
<%
	String nick = (String)session.getAttribute("nick");
%>

<div id="sideleft">
	<div class="login">
		<ul>
			<li>您好:&nbsp;&nbsp;<%=nick%></li>
			<li>个人信息</li>
			<li>积分管理</li>
			<li>已发产品</li>
			<li>我要退出</li>
		</ul>
	</div>
	
	<div class="nav">
		<ul>
			<li><a href="item">设置广告商品</a></li>
			<li><a href="myitem">管理广告商品</a></li>
			<li><a href="config">设置广告参数</a></li>
			<li><a href="#">广告商品代码</a></li>
			<li><a href="preview" target="_blank">预览效果</a></li>
		</ul>
	</div>
</div>