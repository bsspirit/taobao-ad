<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">

<head>
	<title>发广告登陆</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="theme/css/main.css">
</head>
<body>
	<div id="main">
		<jsp:include page="layout/header.jsp"/>
		
		<div id="content">
			<form action="login" method="POST">
				<p>
				<span class="label">用户名</span>
				<input name="username" type="text"/>
				</p>
				
				<p>
				<span class="label">密码</span>
				<span class="col1"><input name="password" type="password"/></span>
				</p>
				
				<p>
				<input type="submit" value="登陆"/>
				</p>
			</form>
		</div>
		<div class="clear"></div>
	
		<jsp:include page="layout/footer.jsp"/>
	</div>
</body>
</html>