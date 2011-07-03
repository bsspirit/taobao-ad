<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ page import="org.conan.taobao.ad.model.*" %>
<%@ page import="org.conan.taobao.web.form.*" %>

<%
	ConfigDTO configDTO = (ConfigDTO)request.getAttribute("config");
	List<ItemForm> items = (List<ItemForm>)request.getAttribute("items");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">

<head>
	<title>广告预览</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<style>
		*{margin:0;padding:0;}
		a:link {color:#3366CC;text-decoration:none;}
		a:hover {color: #FF3300;text-decoration:underline;}
		a:visited {color:#3366CC;text-decoration:none;}
		hr{margin:5px 0 30px;}
	
		<%
		if(configDTO.getWidth()==750){
			out.println(".ad{width:740px;}");
			if(configDTO.getPic_size()==200){
				out.println(".ad-list img{width:200px;height:200px;}");
				out.println(".ad-list li{width:240px;}");
			} else if(configDTO.getPic_size()==160){
				out.println(".ad-list img{width:160px;height:160px;}");
				out.println(".ad-list li{width:177px;}");
			} else if(configDTO.getPic_size()==120){
				out.println(".ad-list img{width:120px;height:120px;}");
				out.println(".ad-list li{width:140px;}");
			}
			
		} else if(configDTO.getWidth()==950){
			out.println(".ad{width:940px;}");
			if(configDTO.getPic_size()==200){
				out.println(".ad-list img{width:200px;height:200px;}");
				out.println(".ad-list li{width:225px;}");
			} else if(configDTO.getPic_size()==160){
				out.println(".ad-list img{width:160px;height:160px;}");
				out.println(".ad-list li{width:180px;}");
			} else if(configDTO.getPic_size()==120){
				out.println(".ad-list img{width:120px;height:120px;}");
				out.println(".ad-list li{width:127px;}");
			}
		}
		%>
		
		/*	
		.ad{width:940px;}
		.ad-list img{width:200px;height:200px;}
		.ad-list li{width:225px;}
			
		.ad{width:740px;}
		.ad-list img{width:200px;height:200px;}
		.ad-list li{width:240px;}
		
		.ad{width:940px;}
		.ad-list img{width:160px;height:160px;}
		.ad-list li{width:180px;}
		
		.ad{width:740px;}
		.ad-list img{width:160px;height:160px;}
		.ad-list li{width:177px;}
		
		.ad{width:940px;}
		.ad-list img{width:120px;height:120px;}
		.ad-list li{width:127px;}

		.ad{width:740px;}
		.ad-list img{width:120px;height:120px;}
		.ad-list li{width:140px;}
		*/
	</style>
	
	<p>提示：以下表格的宽度为：740px，适合宽屏模式。</p>
	<hr/>
	
	<div class="ad" style="border: 1px solid #DADADA;text-align: center;margin:10px auto;font: normal 12px 'Trebuchet MS', Tahoma, sans-serif;">
		<div style="height:25px;font-size:13px;">
			<div style="float:left;width:60%;text-align:left;margin:0 10px;line-height:25px;">
				<strong>快捷搜索：</strong>
				<a href="<%=request.getAttribute("searchAddr")%>" target="_blank">安吉白茶</a>&nbsp;&nbsp;
			</div>
			<div style="float:right;width:25%;text-align:right;margin:0 15px 0 0;line-height:25px;">
				<%
				if(configDTO.getEnter_show()==1){
					out.println("<strong><a href='"+request.getAttribute("shopAddr")+"' target='_blank'>逛逛</a></strong>&nbsp;&nbsp;");
				}
				if(configDTO.getFavor_show()==1){
					out.println("<strong><a href='"+request.getAttribute("favoriteAddr")+"' target='_blank'>收藏</a></strong>&nbsp;&nbsp;");
				}
				%>
				<!--
				<strong><a href="#" target="_blank">关注</a></strong>&nbsp;&nbsp;
				<strong><a href="#" target="_blank">分享</a></strong>&nbsp;&nbsp;
				-->
			</div>
		</div>
		<ul class="ad-list" style="list-style: none outside none;margin:5px 0;">
			<%	
				for(int i=0;i<items.size();i++){
				ItemDTO item = items.get(i);
			%>
			<li style="float:left;margin:0 0 20px 6px;">
				<div style="text-align:center;">
					<div class="pic">
						<a href="<%=item.getDesc_url()%>" target="_blank">
							<img src="<%=item.getPic_url()%>" title="<%=item.getTitle()%>" alt="<%=item.getTitle()%>" style="border: 1px solid #DADADA;padding:2px;background:#FAFAFA;" />
						</a>
					</div>
					<%if(configDTO.getTitle_show()==1){%>
					<div style="height:50px;line-height:1.2;overflow:hidden;padding-top:5px;">
						<a href="<%=item.getDesc_url()%>" target="_blank">
							<%=item.getTitle()%>
						</a>
					</div>
					<%}%>
					<div style="font-size:14px;font-weight:bold;line-height:20px;">
						<div style="color:black;">
							<span>市场价</span>
							<strong style="text-decoration:line-through;"><%=item.getPrice()%></strong>
						</div>
						<div style="color:red;">
							<span>一口价</span>
							<strong><%=item.getPrice()%></strong>
						</div>
					</div>
				</div>
			</li>
			<%}%>
		</ul>
		<div style="clear:both;"></div>
	</div>
</body>
</html>