<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/possibleFriends.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/commonFriends.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/head2.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/foot.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css" type="text/css" />
<title>可能认识的人</title>

</head>
<body>
    <jsp:include page="/WEB-INF/public/head2.jsp"></jsp:include>
	<div class="main">
		
		<div class="myFriends">
			<div class="title">
				<img alt="" src="${pageContext.request.contextPath }/images/front/friends.gif"><span class="font2"> 我的好友》我的好友</span>
			</div>
			<div class="friend_table">
				<table border="1px">
					<tr>
						<td><a href="${pageContext.request.contextPath }/friend.do?flag=myFriends">我的好友</a></td>
						<td><a href="${pageContext.request.contextPath }/friend.do?flag=specialFriends">特别好友</a></td>
						<td><a href="${pageContext.request.contextPath }/friend.do?flag=onlineFriends">在线好友</a></td>
						<td><span class="span1"><a href="${pageContext.request.contextPath }/friend.do?flag=possibleFriends">你可能认识的人</a></span></td>
						<td><a href="${pageContext.request.contextPath }/friend.do?flag=inviteFriends">邀请朋友加入</a></td>
					</tr>
				</table>
			</div>
			<div class="display_friend">
				
			
			
			</div>
		</div>
		<div class="friends_right">
			<img alt="" src="${pageContext.request.contextPath }/images/front/friendright.jpg">
		</div>
	
	</div>
	 <jsp:include  page="/WEB-INF/public/foot.jsp"></jsp:include >
</body>
</html>