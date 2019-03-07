<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/myFriends.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/commonFriends.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/head2.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/foot.css" type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/common.css"
	type="text/css" />
<title>我的好友</title>

</head>
<body>
	<jsp:include page="/WEB-INF/public/head2.jsp"></jsp:include>
	<div class="main">
		<div class="myFriends">
			<div class="title">
				<img alt=""
					src="${pageContext.request.contextPath }/images/front/friends.gif"><span
					class="font2"> 我的好友》我的好友</span>
			</div>
			<div class="friend_table">
				<table border="1px">
					<tr>
						<td><span class="span1"><a
								href="${pageContext.request.contextPath }/friend.do?flag=myFriends">我的好友</a></span></td>
						<td><a
							href="${pageContext.request.contextPath }/friend.do?flag=specialFriends">特别好友</a></td>
						<td><a
							href="${pageContext.request.contextPath }/friend.do?flag=onlineFriends">在线好友</a></td>
						<td><a
							href="${pageContext.request.contextPath }/friend.do?flag=possibleFriends">你可能认识的人</a></td>
						<td><a
							href="${pageContext.request.contextPath }/friend.do?flag=inviteFriends">邀请朋友加入</a></td>
					</tr>
				</table>
			</div>
			<div class="display_friend">

				<select>
					<option>所有网络</option>

				</select>&nbsp;&nbsp;有${friendList.size() }个好友&nbsp;<span>第${pageNow }页/共${pageCount }页
				</span>
				<table border="1">
					<c:if test="${friendList.size()>0 }"></c:if>
					

					<c:forEach items="${friendList }" var="friend">
						<c:if test="${sessionScope.user.id!=friend.user1.id }">
							<tr>
								<td><img alt=""
									src="${pageContext.request.contextPath }/images/userhead2/${friend.user1.getPhoto2() }"
									style="width: 50px; height: 50px;"></td>
								<td><span class="font3">昵称:</span>${friend.user1.getName() }
								<c:if test="${friend.user1.birthday!=null }">
								<br>
								
								<span class="font3">生日:</span>${friend.user1.birthday }
								
								
								</c:if></td>
								<td><a href="${pageContext.request.contextPath }/profile.do?flag=goHomePage&id=${friend.user1.id }">去看看</a></td>
								<td><a href="${pageContext.request.contextPath }/friend.do?flag=addSpecialfriend&friendId=${friend.user1.id }">设为特殊好友</a></td>
							</tr>

						</c:if>
						<c:if test="${sessionScope.user.id!=friend.user2.id }">
							<tr>
								<td><img alt=""
									src="${pageContext.request.contextPath }/images/userhead2/${friend.user2.getPhoto2() }"
									style="width: 50px; height: 50px;"></td>
								<td><span class="font3">昵称:</span>${friend.user2.getName() }
								<c:if test="${friend.user2.birthday!=null}">
								<br>
								
								<span class="font3">生日:</span>${friend.user2.birthday}
								
								
								</c:if>
								
								
								</td>
								<td><a href="${pageContext.request.contextPath }/profile.do?flag=goHomePage&id=${friend.user2.id }">去看看</a></td>
							    <td><a href="${pageContext.request.contextPath }/friend.do?flag=addSpecialfriend&friendId=${friend.user2.id }">设为特殊好友</a></td>
							</tr>

						</c:if>

						



					</c:forEach>
				</table>
				<c:if test="${pageNow>1 }">
							<a
								href="${pageContext.request.contextPath }/friend.do?flag=myFriends&pageNow=${pageNow-1 }">上一页</a>&nbsp;
						</c:if>
						<c:if test="${pageNow<=1 }">
						上一页
						</c:if>

						<c:if test="${pageNow<pageCount }">
							<a
								href="${pageContext.request.contextPath }/friend.do?flag=myFriends&pageNow=${pageNow+1 }">下一页</a>&nbsp;
						</c:if>

						<c:if test="${pageNow>=pageCount }">
						下一页
						</c:if>
				
				<div class="page">
					<input type="text" placeholder="搜索你的好友" /><br> <br>
				</div>

			</div>
		</div>
		<div class="friends_right">
			<img alt=""
				src="${pageContext.request.contextPath }/images/front/friendright.jpg">
		</div>

	</div>
	<jsp:include page="/WEB-INF/public/foot.jsp"></jsp:include>
</body>
</html>