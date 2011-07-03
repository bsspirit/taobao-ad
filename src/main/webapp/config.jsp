<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ page import="org.conan.taobao.ad.model.*" %>

<%
	ConfigDTO configDTO = (ConfigDTO)request.getAttribute("config");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">

<head>
	<title>第一步 设置参数</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="theme/css/main.css">
</head>
<body>
	<div id="main">
		<jsp:include page="layout/header.jsp"/>
		<jsp:include page="layout/sideleft.jsp"/>
		
		<div id="content">
			<form action="config" method="POST">
				<p>
				<span class="label">店铺类型:</span>
				<span class="col1"><input name="shop_type" type="radio" value="0" <%if(configDTO.getShoptype()==0){out.println("checked");}%>/>普店或旺铺</span>
				<span class="col1"><input name="shop_type" type="radio" value="1" <%if(configDTO.getShoptype()==1){out.println("checked");}%>/>商城</span>
				</p>
				
				<p>
				<span class="label">设置页面宽度:</span>
				<span class='col1'><input name='width' type='radio' value='750' <%if(configDTO.getWidth()==750){out.println("checked");}%>/>750</span>
				<span class='col1'><input name='width' type='radio' value='950' <%if(configDTO.getWidth()==950){out.println("checked");}%>/>950</span>
				</p>
				
				<p>
				<span class="label">是否显示商品名称:</span>
				<span class="col1"><input name="item_title" type="radio" value="1" <%if(configDTO.getTitle_show()==1){out.println("checked");}%>/>显示</span>
				<span class="col1"><input name="item_title" type="radio" value="0" <%if(configDTO.getTitle_show()==0){out.println("checked");}%>/>不显示</span>
				</p>
				
				<p>
				<span class="label">"逛逛本店"按钮:</span>
				<span class="col1"><input name="enter_show" type="radio" value="1" <%if(configDTO.getEnter_show()==1){out.println("checked");}%>/>显示</span>
				<span class="col1"><input name="enter_show" type="radio" value="0" <%if(configDTO.getEnter_show()==0){out.println("checked");}%>/>不显示</span>
				</p>
				
				<p>
				<span class="label">"收藏本店"按钮:</span>
				<span class='col1'><input name="favor_show" type="radio" value="1" <%if(configDTO.getFavor_show()==1){out.println("checked");}%>/>显示</span>
				<span class='col1'><input name="favor_show" type="radio" value="0" <%if(configDTO.getFavor_show()==0){out.println("checked");}%>/>不显示</span>
				</p>
				
				<p>
				<span class="label">热门搜索关键字:</span>
				<span class='col1'><input name="search_btn" type="radio" value="1" checked/>显示</span>
				<span class='col1'><input name="search_btn" type="radio" value="0" disabled/>不显示</span>
				</p>
		
				<p>
				<span class="label">输入关键字:</span>
				<input name="search_word" type="text" style="width:200px;"></input>&nbsp;&nbsp;&nbsp;&nbsp;多个关键字请用"|"分隔
				</p>
				
				<p>
				<span class="label">商品图片大小:</span>
				<span class='col1'><input name='pic_size' type='radio' value='120' <%if(configDTO.getPic_size()==120){out.println("checked");}%>/>120*120</span>
				<span class='col1'><input name='pic_size' type='radio' value='160' <%if(configDTO.getPic_size()==160){out.println("checked");}%>/>160*160</span>
				<span class='col1'><input name='pic_size' type='radio' value='200' <%if(configDTO.getPic_size()==200){out.println("checked");}%>/>200*200</span>
				</p>
		
				<p>
				<span class="label">价格显示方式:</span>
				<span class='col1'><input name="price_way" type="radio" value="0" checked/>原价/促销价</span>
				<span class='col1'><input name="price_way" type="radio" value="1"/>一口价</span>
				</p>
				
				<p>
				<span class="label">促销价格样式:</span>
				<select name="price_style">
					<option selected value="0">市场价/折扣价</option>
					<option value="1">市场价/淘宝价</option>
					<option value="2">市场价/抢购价</option>
					<option value="3">淘宝价/促销价</option>
					<option value="4">淘宝价/今日价</option>
					<option value="5">淘宝价/秒杀价</option>
					<option value="6">原价/促销价</option>
					<option value="7">原价/包邮价</option>
					<option value="8">原价/物价</option>
				</select>
				</p>
				
				<p>
				原价 = 宝贝现价 × <input name="price_ratio" type="text" value="120"></input> %  输入100到800之间整数，不输入则按一口价方式显示
				</p>
		
				<p/><p>
				<input type="submit" value="保存设置"/>
				</p>
			</form>
		</div>
		<div class="clear"></div>
	
		<jsp:include page="layout/footer.jsp"/>
	</div>
</body>
</html>