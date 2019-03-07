<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/friendsSearchResult.css"
	type="text/css" />

<link rel="stylesheet" href="${pageContext.request.contextPath }/css/head2.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/foot.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css" type="text/css" />
<title>搜索到的朋友</title>

</head>
<body>
	<jsp:include page="/WEB-INF/public/head2.jsp"></jsp:include>
	<div class="main">
		<div class="searchFriends">
			<div class="title">
				<table class="table2">
					<tr>
						<td></td>
						<td class="td3"><a href="${pageContext.request.contextPath }/search.do?flag=goSearchFriends">返回搜索</a></td>
					</tr>
					<tr>
						<td><span> 搜索到<font class="font8">${rowCount }</font>个结果
						</span></td>
						<td class="td3"><span>第${pageNow }页&nbsp;共${pageCount }页&nbsp;</span>
						
						<c:if test="${pageNow!=1 }">
						<a href="${pageContext.request.contextPath }/search.do?flag=searchAllFriends&pageNow=1">第一页</a>&nbsp;
						</c:if>
						<c:if test="${pageNow==1 }">
						<span>第一页</span>
						</c:if>
						<c:if test="${pageNow>1 }">
						<a href="${pageContext.request.contextPath }/search.do?flag=searchAllFriends&pageNow=${pageNow-1 }">上一页</a>&nbsp;
						</c:if>
						<c:if test="${pageNow<=1 }">
						<span>上一页</span>
						</c:if>
						<c:if test="${pageNow<pageCount }">
						<a href="${pageContext.request.contextPath }/search.do?flag=searchAllFriends&pageNow=${pageNow+1 }">下一页</a>&nbsp;
						</c:if>
						<c:if test="${pageNow>=pageCount }">
						<span>下一页</span>
						</c:if>
						<c:if test="${pageNow!=pageCount }">
						<a href="${pageContext.request.contextPath }/search.do?flag=searchAllFriends&pageNow=${pageCount }">最后一页</a>&nbsp;
						</c:if>
						<c:if test="${pageNow>=pageCount }">
						<span>最后一页</span>
						</c:if>
						
						</td>
					</tr>

				</table>



			</div>

			<div class="table1">
				<table border="1"
					style="border-collapse: separate; border-spacing: 10px;">
					
					<c:forEach items="${list }" var="user">
						<tr class="tr1">
						<td class="td1"><div class="userHead">
								<img alt=""
									src="${pageContext.request.contextPath }/images/userhead2/${user.getPhoto2() }"
									class="img1">
							</div></td>
						<td class="td2"><div class="userInfo">
								<span class="font3">姓名:<a href="">${user.getName() }</a></span><br> <span
									class="font3">网络:<a href="#">首都医科大学</a></span>
							</div></td>
						<td class="td3"><div class="makeFriends">

								<span class="right"><a href="#">打个招呼</a></span><br> <span
									class="right"><a href="#">发站内信</a></span><br> <span
									class="right"><a href="${pageContext.request.contextPath }/friend.do?flag=addFriends&userId2=${user.getId() }">加为好友</a></span><br> <span
									class="right"><a href="#">查看好友</a></span>
							</div></td>
					</tr>
					
					</c:forEach>

				</table>
			</div>
		</div>
		<div class="friends_right">
			<img alt="" src="${pageContext.request.contextPath }/images/front/friendright.jpg">
		</div>

	</div>
	<jsp:include page="/WEB-INF/public/foot.jsp"></jsp:include>
</body>
</html>