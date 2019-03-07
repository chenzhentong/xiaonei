<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/specialFriends.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/commonFriends.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/head2.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/foot.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css" type="text/css" />
<title>特别好友</title>

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
						<td><span class="span1"><a href="${pageContext.request.contextPath }/friend.do?flag=specialFriends">特别好友</a></span></td>
						<td><a href="${pageContext.request.contextPath }/friend.do?flag=onlineFriends">在线好友</a></td>
						<td><a href="${pageContext.request.contextPath }/friend.do?flag=possibleFriends">你可能认识的人</a></td>
						<td><a href="${pageContext.request.contextPath }/friend.do?flag=inviteFriends">邀请朋友加入</a></td>
					</tr>
				</table>
			</div>
			<div class="display_friend" style="padding:10px;">
				<div class="description" style="padding-bottom:10px;">
				    <span class="font3">你的特别好友将会显示到你的页面上。<br>
				       描述你的特殊好友，让大家认识他们。<br></span>
				
				
				   
			    </div>
				有${friendList.size() }个好友&nbsp;<span>第${pageNow }页/共${pageCount }页
				</span>
				<br>
				<table border="1">
					<c:if test="${friendList.size()>0 }"></c:if>

					<c:forEach items="${friendList }" var="friend">
						<c:if test="${sessionScope.user.id!=friend.user1.id }">
							<tr>
								<td><img alt=""
									src="${pageContext.request.contextPath }/images/userhead2/${friend.user1.getPhoto2() }"
									style="width: 50px; height: 50px;"></td>
								<td>${friend.user1.getName() }</td>
								<td><a href="${pageContext.request.contextPath }/profile.do?flag=goHomePage&id=${friend.user1.id }">去看看</a></td>
								<td> <form action="${pageContext.request.contextPath }/specialfriend.do?flag=describeFriend" method="post">
				                         <input type="hidden" value="${friend.user1.id }" name="userId2">
				                         <input type="text" name="description" placeholder="说一说你对好友的印象">
				                         <input type="submit" value="更新">
				    
				    
				                    </form>
				                </td>
							</tr>

						</c:if>
						<c:if test="${sessionScope.user.id!=friend.user2.id }">
							<tr>
								<td><img alt=""
									src="${pageContext.request.contextPath }/images/userhead2/${friend.user2.getPhoto2() }"
									style="width: 50px; height: 50px;"></td>
								<td>${friend.user2.getName() }</td>
								<td><a href="${pageContext.request.contextPath }/profile.do?flag=goHomePage&id=${friend.user2.id }">去看看</a></td>
							    <td> <form action="${pageContext.request.contextPath }/specialfriend.do?flag=describeFriend" method="post">
				                         <input type="hidden" value="${friend.user2.id }" name="userId2">
				                         <input type="text" name="description" placeholder="说一说你对好友的印象">
				                         <input type="submit" value="更新">
				    
				    
				                    </form>
				                </td>
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
				
				
			</div>
		</div>
		<div class="friends_right">
			<img alt="" src="${pageContext.request.contextPath }/images/front/friendright.jpg">
		</div>
	
	</div>
	 <jsp:include  page="/WEB-INF/public/foot.jsp"></jsp:include >
</body>
</html>