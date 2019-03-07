<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/common.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/home.css" type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/head2.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/foot.css" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.3.1.js"></script>
<script type="text/javascript">
<!--
	function showAndHidden(obj, obj2) {
		$(obj).css("display", "block");
		$(obj2).css("display", "none");
	}

	-->
</script>
</head>
<body>

	<jsp:include page="/WEB-INF/public/head2.jsp"></jsp:include>
	<div class="home">
		<div class="apply">
			<div class="table1">
				<table>


					<tr>
						<td colspan="3">应用</td>
					</tr>
					<tr>
						<td><img alt=""
							src="${pageContext.request.contextPath }/images/front/blog.gif"></td>
						<td><a
							href="${pageContext.request.contextPath }/blog.do?flag=goPublishBlog">日志</a></td>
						<td><a
							href="${pageContext.request.contextPath }/blog.do?flag=goPublishBlog"
							class="anavi">发表</a></td>
					</tr>
					<tr>
						<td><img alt=""
							src="${pageContext.request.contextPath }/images/front/photo.gif"></td>
						<td><a href="#">相册</a></td>
						<td><a
							href="${pageContext.request.contextPath }/album.do?flag=goAddAlbum"
							class="anavi">上传</a></td>
					</tr>
					<tr>
						<td><img alt=""
							src="${pageContext.request.contextPath }/images/front/group.gif"></td>
						<td><a href="#">群组</a></td>
						<td></td>
					</tr>

					<tr>
						<td><img alt=""
							src="${pageContext.request.contextPath }/images/front/share.gif"></td>
						<td><a href="#">分享</a></td>
						<td></td>
					</tr>
					<tr>
						<td><img alt=""
							src="${pageContext.request.contextPath }/images/front/gift.gif"></td>
						<td><a href="#">礼物</a></td>
						<td></td>
					</tr>
					<tr>

						<td><img alt=""
							src="${pageContext.request.contextPath }/images/front/toupiao.gif"></td>
						<td><a href="#">投票</a></td>
						<td></td>
					</tr>
				</table>

			</div>
			<div class="image_left">
				<img alt=""
					src="${pageContext.request.contextPath }/images/front/homeleft.jpg">
			</div>
		</div>
		<div class="per_info">
			<div class="edit_info">
				<div class="photo_info">
					<img alt=""
						src="${pageContext.request.contextPath }/images/userhead2/${sessionScope.user.getPhoto2() }"
						style="width: 100px; height: 100px;" />
				</div>
				<div class="right_info">
					<div class="show">
						<span class="font2">${sessionScope.user.getName() }</span><br>
						${sessionScope.user.getDoing() }&nbsp;${sessionScope.user.assh }&nbsp;&nbsp;&nbsp;<a
							href="javascript:void(0)"
							onclick="showAndHidden('.hidden','.show')">编辑</a>
					</div>
					<div class="hidden" style="display: none">
						<form
							action="${pageContext.request.contextPath }/modify.do?flag=modifyAssign"
							method="post">
							<input type="text" name="assh" value="${sessionScope.user.assh }">
							<br> <input type="submit" value="修改">
						</form>


					</div>

					<br> <input type="image"
						src="${pageContext.request.contextPath }/images/front/status.gif" />&nbsp;<a
						href="#">改状态</a> &nbsp;&nbsp; <input type="image"
						src="${pageContext.request.contextPath }/images/front/blog.gif" />&nbsp;<a
						href="${pageContext.request.contextPath }/blog.do?flag=goPublishBlog">写日志</a>&nbsp;&nbsp;
					<input type="image"
						src="${pageContext.request.contextPath }/images/front/photo.gif" />&nbsp;<a
						href="${pageContext.request.contextPath }/album.do?flag=goAddAlbum">传照片</a>&nbsp;&nbsp;
					<input type="image"
						src="${pageContext.request.contextPath }/images/front/share.gif" />&nbsp;<a
						href="#">分享</a>
				</div>
			</div>
			<div class="message">
				<table>
					
					<tr>
						<td>新留言及回复(${usermessagecommentList.size()+messageList.size() })</td>
						<td><a href="${pageContext.request.contextPath }/profile.do?flag=goHomePage">更多</a></td>
					</tr>
					<c:if test="${messageList.size()>0 }">
					
					
					
					    <tr>
						<td><img alt=""
							src="${pageContext.request.contextPath }/images/front/wall_post.gif" />${messageList.get(0).user.name }在你的留言板留言</td>
						<td></td>
					</c:if>
					
					<c:if test="${usermessagecommentList.size()>0 }">
					
					
					
					     <tr>
						<td><img alt=""
							src="${pageContext.request.contextPath }/images/front/wall_post.gif" />${usermessagecommentList.get(0).sender.name }在${usermessagecommentList.get(0).message.host.name }的留言板回复你</td>
						<td></td>
					    </tr>
					</c:if>
				
				
					

				</table>
			</div>
			<div class="news">
				<span class="font2"> 新鲜事情</span>
				<table>

					<tr>
						<td></td>
						<td>首都医科大学 人气之星<br> <img alt=""
							src="${pageContext.request.contextPath }/images/userhead/0000.gif"
							class="img4" /> <img alt=""
							src="${pageContext.request.contextPath }/images/userhead/0000.gif"
							class="img4" /> <img alt=""
							src="${pageContext.request.contextPath }/images/userhead/0000.gif"
							class="img4" />

						</td>
					</tr>
					<tr>
						<td></td>
						<td>首都医科大学 新人·<br> <img alt=""
							src="${pageContext.request.contextPath }/images/userhead/0000.gif"
							class="img4" /> <img alt=""
							src="${pageContext.request.contextPath }/images/userhead/0000.gif"
							class="img4" /> <img alt=""
							src="${pageContext.request.contextPath }/images/userhead/0000.gif"
							class="img4" />

						</td>
					</tr>

				</table>

			</div>


		</div>
		<div class="relative_info">
			<div class="table2">
				<table>

					<tr>
						<td colspan="2">最近来访(${uservisitedList.size() })</td>
						<td><a href="#">更多>></a></td>
					</tr>

					<c:if test="${uservisitedList.size()>0 }">
						<c:if test="${uservisitedList.size()>=3 }">
							<tr>
								<c:forEach begin="0" end="2" var="i">
									<td><img alt=""
										src="${pageContext.request.contextPath }/images/userhead2/${uservisitedList.get(i).visitor.photo2 }"
										class="img4"><br> <a href="#">三少爷</a><br>11月11日</td>

								</c:forEach>

							</tr>

						</c:if>
						<c:if test="${uservisitedList.size()<3 }">
							<tr>
								<c:forEach items="${uservisitedList }" var="uservisited">
									<td><img alt=""
										src="${pageContext.request.contextPath }/images/userhead2/${uservisited.visitor.photo2 }"
										class="img4"><br> <a href="#">三少爷</a><br>11月11日</td>

								</c:forEach>

							</tr>

						</c:if>




					</c:if>

					<tr>
				</table>

			</div>
			<div class="table3">
				<table>

					<tr>
						<td colspan="2">你可能认识的人(0)</td>
						<td><a href="#">更多>></a></td>
					</tr>
				
					
				</table>

			</div>
			<div class="table4">
				<table>

					<tr>
						<td colspan="2">好友生日(${allFriendList.size() })</td>
						<td><a href="${pageContext.request.contextPath }/friend.do?flag=myFriends">更多>></a></td>
					</tr>

					<c:if test="${allFriendList.size()>0 }">
					<tr>


						<c:if test="${allFriendList.size()>=3  }">
							
								<c:forEach begin="0" end="2" var="i">
									<c:if
										test="${allFriendList.get(i).user1.id!=sessionScope.user.id }">
										<td><img alt=""
											src="${pageContext.request.contextPath }/images/userhead2/${allFriendList.get(i).user1.photo2}"
											class="img4"><br> <img alt=""
											src="/xiaoneinew/images/front/online.gif" /><a href="#">${allFriendList.get(i).user1.name}</a><br>${allfriendList.get(i).user1.birthday }</td>
									</c:if>
									<c:if
										test="${allFriendList.get(i).user2.id!=sessionScope.user.id }">
										<td><img alt=""
											src="${pageContext.request.contextPath }/images/userhead2/${allFriendList.get(i).user2.photo2}"
											class="img4"><br> <img alt=""
											src="/xiaoneinew/images/front/online.gif" /><a href="#">${allFriendList.get(i).user2.name}</a><br>${allfriendList.get(i).user2.birthday }</td>
									</c:if>


								</c:forEach>
							
						</c:if>
						</tr>
						<tr>

						<c:if test="${allFriendList.size()<3  }">
						
							
								<c:forEach items="${allFriendList }" var="friend">
									<c:if test="${friend.user1.id!=sessionScope.user.id }">
										<td><img alt=""
											src="${pageContext.request.contextPath }/images/userhead2/${friend.user1.photo2 }"
											class="img4"> <br><img alt=""
											src="/xiaoneinew/images/front/online.gif" /><a href="#">${friend.user1.name }</a><br> ${friend.user1.birthday }</td>
									</c:if>
									<c:if test="${friend.user2.id!=sessionScope.user.id }">
										<td><img alt=""
											src="${pageContext.request.contextPath }/images/userhead2/${friend.user2.photo2 }"
											class="img4"><br> <img alt=""
											src="/xiaoneinew/images/front/online.gif" /><a href="#">${friend.user2.name }</a><br> ${friend.user2.birthday }</td>
									</c:if>


								</c:forEach>
							

						</c:if>
					    </tr>
				      
					</c:if>
					
					
				</table>

			</div>
			<div class="table5">
				<table>

					<tr>
						<td colspan="2">在线好友(${onlinefriendList.size() })</td>
						<td><a href="${pageContext.request.contextPath }/friend.do?flag=onlineFriends">更多>></a></td>
					</tr>
					<c:if test="${onlinefriendList.size()>0 }">

						<c:if test="${onlinefriendList.size()>3 }">
							<c:forEach begin="0" end="2" var="i">
								<c:if
									test="${onlinefriendList.get(i).user1.id!=sessionScope.user.id }">
									<td><img alt=""
										src="${pageContext.request.contextPath }/images/userhead2/${onlinefriendList.get(i).user1.photo2 }"
										class="img4"></td>

								</c:if>

								<c:if
									test="${onlinefriendList.get(i).user2.id!=sessionScope.user.id }">
									<td><img alt=""
										src="${pageContext.request.contextPath }/images/userhead2/${onlinefriendList.get(i).user2.photo2 }"
										class="img4"></td>
								</c:if>
							</c:forEach>
						</c:if>

						<c:if test="${onlinefriendList.size()<=3 }">
							<c:forEach items="${onlinefriendList }" var="onlinefriend">
								<c:if test="${onlinefriend.user1.id!=sessionScope.user.id }">
									<td><img alt=""
										src="${pageContext.request.contextPath }/images/userhead2/${onlinefriend.user1.photo2 }"
										class="img4"></td>

								</c:if>

								<c:if test="${onlinefriend.user2.id!=sessionScope.user.id }">
									<td><img alt=""
										src="${pageContext.request.contextPath }/images/userhead2/${onlinefriend.user2.photo2 }"
										class="img4"></td>
								</c:if>
							</c:forEach>
						</c:if>
					</c:if>

				</table>

			</div>
		</div>

	</div>
	<jsp:include page="/WEB-INF/public/foot.jsp"></jsp:include>
</body>
</html>