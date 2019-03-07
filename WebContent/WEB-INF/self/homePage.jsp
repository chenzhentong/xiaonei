<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人主页</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/common.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/homePage.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/head2.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/foot.css" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.3.1.js"></script>
<script type="text/javascript">
<!--
	function show(obj) {
		$(obj).css("display", "block");
	}
 
   function  hide(obj) {
		$(obj).css("display", "none");
	}

	-->
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/public/head2.jsp"></jsp:include>

	<div class="homePage">
		<div class="left">
			<div class="photo">
				<c:if test="${param.id!=null }">
					<img alt=""
						src="${pageContext.request.contextPath }/images/userhead2/${user1.getPhoto2() }" />

				</c:if>
				<c:if test="${param.id==null }">
					<img alt=""
						src="${pageContext.request.contextPath }/images/userhead2/${user.getPhoto2() }" />

				</c:if>


			</div>
			<div class="edit">

				<li><a
					href="${pageContext.request.contextPath }/modify.do?flag=goUploadPhoto">更改我的头像</a></li>
				<li><a href="#">编辑我的主页</a></li>
				<li><a href="#">装扮主页</a></li>
			</div>
			<div class="info">
				<li><span class="font3">所在网络:</span>&nbsp;</li>
				<li><span class="font3">生日:</span>&nbsp;${sessionScope.user.birthday }</li>
				<li><span class="font3">家乡:</span>&nbsp;${sessionScope.user.homePro.name }&nbsp;${sessionScope.user.homeCity.name }</li>
			</div>
			<div class="share">
				<div class="title">


					<span>分享</span> <font style="float: right"><a href="">查看全部</a></font>
				</div>
				<div class="share_content">
					<li><img alt=""
						src="${pageContext.request.contextPath }/images/front/photo.gif" /><a>星座配对表</a></li>
					<li><font class="right">10月03日 10:03</font></li>
					<li><br> <img alt=""
						src="${pageContext.request.contextPath }/images/front/blog.gif"><a>你可能不知道的100件事</a><font
						class="right">10月03日 10:03</font></li>
					<li><br> <img alt=""
						src="${pageContext.request.contextPath }/images/front/blog.gif"><a>你可能不知道的100件事</a><font
						class="right">10月03日 10:03</font></li>
				</div>
			</div>
			<div class="vote">
				<div class="title">


					<span>投票</span> <font style="float: right"><a href="">查看全部</a></font>
				</div>
				<div class="vote_join">
					<table>
						<tr>
							<td>你参与的投票</td>
						</tr>
						<tr>
							<td><img alt=""
								src="${pageContext.request.contextPath }/images/front/toupiao.gif">【投票】选出您心目中最喜欢的NBA明星
							</td>
						</tr>
						<tr>
							<td><img alt=""
								src="${pageContext.request.contextPath }/images/front/toupiao.gif">【投票】选出您心目中最喜欢的NBA明星
							</td>
						</tr>
						<tr>
							<td><img alt=""
								src="${pageContext.request.contextPath }/images/front/toupiao.gif">【投票】选出您心目中最喜欢的NBA明星
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="gift">
				<div class="title">


					<span>礼物</span><font style="float: right"><a href="">更多</a></font><font
						style="float: right"><a href="">送她礼物&nbsp;</a> </font>
				</div>
				<div class="goodfriends">
					<table>
						<tr>
							<td><img alt=""
								src="${pageContext.request.contextPath }/images/userhead/admin.jpg"
								class="img1">送你一朵<a href="#">鲜花</a></td>
							<td></td>
						</tr>


					</table>

				</div>
			</div>



		</div>
		<div class="center_info">
			<div class="visited">
				<span class="font2">${sessionScope.user.name }</span>&nbsp;&nbsp;<img
					alt=""
					src="${pageContext.request.contextPath }/images/front/star.gif"><span
					class="font3">&nbsp;有(4)人看过，什么也没做</span> <a href="#">&nbsp;编辑</a>

			</div>
			<div class="func_btn">
				<button class="btn1">个人主页</button>
				<button class="btn"
					onclick="location.href='${pageContext.request.contextPath }/modify.do?flag=goModifyBaseInfo'">资料</button>
				<button class="btn"
					onclick="location.href='${pageContext.request.contextPath }/blog.do?flag=goManageBlog'">日志</button>
				<button class="btn"
					onclick="location.href='${pageContext.request.contextPath }/album.do?flag=myPhoto'">相册</button>
				<button class="btn">应用</button>
			</div>
			<div class="photo2">
				<span class="font5">相册</span><a
					href="${pageContext.request.contextPath }/album.do?flag=myPhoto">(${albumList1.size() })</a><font
					class="right"><a
					href="${pageContext.request.contextPath }/album.do?flag=myPhoto">查看全部相册</a></font><br>
				<table>
					<tr>
						<c:if test="${albumList.size()!=0 }">
							<c:forEach items="${albumList }" var="album">

								<td><img alt=""
									src="${pageContext.request.contextPath }/images/photos/${album.getPhoto2() }"
									class="t4" /></td>

							</c:forEach>

						</c:if>


					</tr>
					<tr>

						<c:if test="${albumList.size()!=0 }">
							<c:forEach items="${albumList }" var="album">

								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${album.getTitle() }</td>

							</c:forEach>

						</c:if>
					</tr>
					<tr>

						<c:if test="${albumList.size()!=0 }">
							<c:forEach items="${albumList }" var="album">

								<td><span class="font3">更新于${album.getPublihDate() }</span></td>

							</c:forEach>

						</c:if>
					</tr>

				</table>
			</div>
			<div class="blog">
				<span class="font5">日志</span><a
					href="${pageContext.request.contextPath }/blog.do?flag=goManageBlog">(${blogList.size() })</a><font
					class="right"><a
					href="${pageContext.request.contextPath }/blog.do?flag=goManageBlog">查看全部日志</a></font><br>
				<c:if test="${blogList.size()==0 }">
					<li>您还未发表任何日志</li>
					<hr>
				</c:if>

				<c:if test="${blogList.size()<3&&blogList.size()>0 }">
					<c:forEach begin="0" end="${blogList.size() }" var="i">
						<li><img alt=""
							src="${pageContext.request.contextPath }/images/front/blog.gif">&nbsp;&nbsp;&nbsp;<span><a
								href="#">${blogList.get(i).getContent() }</a></span><font class="right"><span
								class="font3">${blogList.get(i).getPublishDate() }</span></font></li>
						<hr>
					</c:forEach>

				</c:if>
				<c:if test="${blogList.size()>=3 }">
					<c:forEach begin="0" end="2" var="i">
						<li><img alt=""
							src="${pageContext.request.contextPath }/images/front/blog.gif">&nbsp;&nbsp;&nbsp;<span><a
								href="#">${blogList.get(i).getContent() }</a></span><font class="right"><span
								class="font3">${blogList.get(i).getPublishDate() }</span></font></li>
						<hr>
					</c:forEach>
				</c:if>








			</div>
			<div class="messageBoard">
				<span class="font5">留言板</span><br> <br>
				<c:if test="${param.id!=null }">

					<c:set var="id" value="${param.id }"></c:set>
				</c:if>
				<c:if test="${param.id==null }">

					<c:set var="id" value="${sessionScope.user.id }"></c:set>
				</c:if>
				<form
					action="${pageContext.request.contextPath }/message.do?flag=publishMessage&id=${id }"
					method="post">
					<div class="textarea">
						<input type="text" name="content">

					</div>
					<div class="submit_input">

						<input type="submit" value="留言" class="btn" /> <span
							class="font3">(每条最多<span class="font6">200字</span>)
						</span>
					</div>
				</form>

			</div>
			<div class="comment">
				

				<table class="table">
					<c:forEach items="${messageList }" var="message">


						<tr class="tr1">
							<td class="td1"><img alt=""
								src="${pageContext.request.contextPath }/images/userhead2/${message.getUser().getPhoto2() }"
								class="img1"></td>
							<td class="td2"><a>${message.user.name }</a>&nbsp;<span
								class="font6">${message.messageDate }</span><br>${message.content }</td>
							<td class="td3"><a href="javascript:void(0)"
								onclick="show('.${message.id }')">回复</a>&nbsp;
								<a href="javascript:void(0)"
								onclick="hide('.${message.id }')">收起回复</a>
								
							<!--  查看回复(${message.usermessagecomments.size() })--></td>
						</tr>
						
						<tr>

							<td colspan="3"  >
								<div>

									<table>
									


										<c:forEach items="${message.usermessagecomments }"
											 var="comments">
											

											<tr>
												<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<img alt=""
													src="${pageContext.request.contextPath }/images/userhead2/${comments.sender.getPhoto2() }"
													style="width: 20px; height: 20px;">
													


													${comments.content }&nbsp; <span class="font6">${comments.publishDate }</span>
												</td>
											</tr>
										</c:forEach>
									</table>


								</div>
							</td>

						</tr>
						
						
						<tr>

							<td colspan="3">
								<div>

									<form
										action="${pageContext.request.contextPath }/usermessagecomment.do?flag=publishComment"
										method="post" style="display: none;" class="${message.id }">

										<input type="text" name="content" value="${message.id }">
										<input type="hidden" name="messageId" value="${message.id }">
										<input type="hidden" name="senderId"
											value="${sessionScope.user.id }"> <input
											type="hidden" name="receiverId" value="${message.user.id }">
										<input type="submit" value="提交">
									</form>

								</div>
							</td>

						</tr>
					</c:forEach>


				</table>

			</div>


		</div>
		<div class="contract">
			<div class="special_friend">
				<span class="font5">特别好友</span>(${specialfriendList1.size() })<font
					class="right"><a
					href="${pageContext.request.contextPath }/friend.do?flag=myFriends">编辑</a></font><br>
				<table>
					<c:if test="${specialfriendList.size()>0 }">
						<tr>
							<c:forEach items="${specialfriendList }" var="friend">
								<td><img alt=""
									src="${pageContext.request.contextPath }/images/userhead2/${friend.user2.photo2 }" /></td>
							</c:forEach>
						</tr>

					</c:if>

					<tr class="center">
						<c:if test="${specialfriendList.size()>0 }">

							<c:forEach items="${specialfriendList }" var="friend">
								<td>${friend.user2.name }</td>
							</c:forEach>
						</c:if>
					</tr>

				</table>
			</div>
			<div class="recent_visited">
				<span class="font5">最近来访</span>(${uservisitedList1.size() })<br>
				<table>
					<tr>
						<c:if test="${uservisitedList.size()>0 }">
							<c:forEach items="${uservisitedList }" var="uservisited">
								<td><img alt=""
									src="${pageContext.request.contextPath }/images/userhead2/${uservisited.visitor.photo2 }" /></td>

							</c:forEach>


						</c:if>
					</tr>



					<c:if test="${uservisitedList.size()>0 }">
						<c:forEach items="${uservisitedList }" var="uservisited">
							<td>${uservisited.visitor.name }<br>${uservisited.visitedDate }</td>

						</c:forEach>


					</c:if>


				</table>

			</div>
			<div class="friend">
				<span class="font5">好友(${friendList1.size() })</span><br>
				<table>
					<c:if test="${friendList.size()>0 }">
						<tr>
							<c:forEach items="${friendList }" var="friend">


								<c:if test="${friend.user1.id!=sessionScope.user.id }">

									<td><img alt=""
										src="${pageContext.request.contextPath }/images/userhead2/${friend.user1.photo2 }" /></td>



								</c:if>
								<c:if test="${friend.user2.id!=sessionScope.user.id }">

									<td><img alt=""
										src="${pageContext.request.contextPath }/images/userhead2/${friend.user2.photo2 }" /></td>
								</c:if>


							</c:forEach>
						</tr>

					</c:if>

					<tr class="center">
						<c:if test="${friendList.size()>0 }">
							<tr>
								<c:forEach items="${friendList }" var="friend">


									<c:if test="${friend.user1.id!=sessionScope.user.id }">

										<td>${friend.user1.name }</td>



									</c:if>
									<c:if test="${friend.user2.id!=sessionScope.user.id }">

										<td>${friend.user2.name }</td>



									</c:if>


								</c:forEach>
							</tr>

						</c:if>
					</tr>

				</table>
			</div>

		</div>


	</div>

	<jsp:include page="/WEB-INF/public/foot.jsp"></jsp:include>

</body>
</html>