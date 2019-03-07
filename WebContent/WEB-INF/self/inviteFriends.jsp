<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/inviteFriends.css"
	type="text/css" />

<link rel="stylesheet" href="${pageContext.request.contextPath }/css/head2.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/foot.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css" type="text/css" />
<title>邀请好友</title>

</head>
<body>
	<jsp:include page="/WEB-INF/public/head2.jsp"></jsp:include>
	<div class="main">

		<div class="myFriends">
			<div class="title">
				<span class="font2"> 邀请朋友加入校内网</span>
			</div>
			<div class="invite_way">
				<div class="way1">
					<a href="#">导入邮箱的通讯录至邀请名单</a><br>支持123、126、163等多种邮箱
				</div>
				<div class="way2">
					<a href="#">通过链接邀请</a><br>用qq等聊天工具发送链接
				</div>
				<div class="way3"> 
					<a href="#">导入MSN联系人至邀请名单</a><br>可导入你的MSN上的联系人名单
				</div>
				<div class="way4">
					<a href="#">直接发送Email邀请</a><br>向对方的邮箱发送邀请邮件
				</div>


				<div class="way5">
					<a href="#">导入Foxmail等地址簿至邀请名单</a><br>支持邮件客户端的地址薄导入
				</div>
				<div class="way6">
					<a href="#">直接发送短信邀请</a><br>邀请好友手机注册校内网
				</div>
			</div>

		</div>
		<div class="friends_right">
		<img alt="" src="${pageContext.request.contextPath }/images/front/inviteright.jpg">
	</div>

	</div>
	

	
	<jsp:include page="/WEB-INF/public/foot.jsp"></jsp:include>
</body>
</html>