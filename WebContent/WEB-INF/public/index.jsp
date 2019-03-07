<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.3.1.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/head.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/foot.css" type="text/css" />
<script type="text/javascript">
	<!--
	    function judge()
	    {
		    if ($("#checkbox-id").get(0).checked) { 
		    	$("#hiddenInput").val('yes');
           }
		    else  { 
		    	$("#hiddenInput").val('no');
           }
	    }
	-->
</script>
<title>用户登录</title>

</head>
<body>
    <jsp:include page="/WEB-INF/public/head.jsp"></jsp:include>
	<div class="main">
		<div class="reg_login">
			<div class="loginForm">
				
				
				<form action="${pageContext.request.contextPath }/login.do?flag=login" method="post" id="form">
					登录邮箱<br/>
					<input type="text" name="email" class="input"/>
					<br/>密码<br/>
					<input type="hidden" value="no" id="hiddenInput" name="keep">
					<input type="password"  name="pwd" class="input"/><br/>
					&nbsp;<input type="checkbox"  id="checkbox-id" onclick="judge()" >&nbsp;&nbsp;下次自动登录<br/>
					&nbsp;&nbsp;<input class="login_btn" type="submit" value="登录">&nbsp;<a href="#">找回密码</a>
				
				</form>
				<br>
			
			
			</div>
			<div class="reg"><b><a href=${pageContext.request.contextPath }/register.do?flag=goToRegister">注册</a></b><br/>
			校内网期待你的加入
			
			
			
			</div>
			<div class="mobile"><b><a href="#">手机登录</a></b><br/>
			请访问mi.xiaonei.com
			
			
			
			</div>
		</div>
		<div class="" >
		<img alt="" src="${pageContext.request.contextPath }/images/front/ay-0812-658-280.jpg">
		</div>
		<div class="instro">
			<p class="font2"><b>校内是一个真实社交网络,加入她你可以:</b></p>
		
			
				
				<li>联络朋友,了解他们的最新动态</li>
				<li>用照片和日志记录生活,展示自我</li>
				<li>找到老朋友并结识新朋友</li>	
				<li>和朋友分享照片、音乐或电影</li>
				<li>自由、安全地控制个人隐私</li>
			
		</div>
		<div class="reg2">
		    <br/>
			<span class="font2">因为真实,所以精彩</span>
			<br/>
			<p><span class="font3">校内存知己</span>
		    <br/>
			<input type="image" onclick="window.location.href='${pageContext.request.contextPath }/register.do?flag=goToRegister'" src="/xiaoneinew/images/front/register.jpg" >
			</p>
		
		</div>
		<div class="find_friend">
		<span class="font2">
		寻找你的朋友
		</span>
			<input type="text" name="sea_friend"/>
			<img alt="" src="${pageContext.request.contextPath }/images/front/sou.jpg"/>
			<br/>
		   * <span><font class="font3">校内网目前已开通</font><font class="font4">海外1500所大学、国内3000所大学、56000所中学及85000家公司</font></span>
			
			
		
		
		</div>
		<div class="advice">
			<span>我们每天都在快乐地进步着:</span><p class="right"><a href="#">我要提建议</a></p>
			<br/><span>10月16日 狗狗:全新界面登场</span><br/>
			<span>10月15日 相册预加载和FLASH版上传,浏览相册更快更爽</span><br/>
			<span>10月14日 留言板新增悄悄话功能</span><br/>
			
		
		</div>
	
	</div>
	 <jsp:include  page="/WEB-INF/public/foot.jsp"></jsp:include >
</body>
</html>