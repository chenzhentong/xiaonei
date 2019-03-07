<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="/xiaoneinew/css/manageBlog.css"
	type="text/css" />

<link rel="stylesheet" href="/xiaoneinew/css/head2.css" type="text/css" />
<link rel="stylesheet" href="/xiaoneinew/css/foot.css" type="text/css" />
<link rel="stylesheet" href="/xiaoneinew/css/common.css" type="text/css" />
<title>我的日志</title>

</head>
<body>
	<jsp:include page="/WEB-INF/public/head2.jsp"></jsp:include>
	<div class="main">
		<div class="blog">
			<div class="title">
				<img alt="" src="${pageContext.request.contextPath }/images/front/blog.gif"><span
					class="font2">我的日志</span>
			</div>

			<div class="publish_blog">
				<c:if test="${blogList.size()>0 }">
					<c:forEach items="${blogList }" var="blog"  >
					<div class="table">
					<table>
							<tr class="tr1">
								<td><h2>${blog.getTitle() }</h2>分类:${blog.getBlogsort().getSort() }</td>
							</tr>
							
							<tr class="tr1">
								<td><span class="font9">${blog.getContent() }</span></td>
							</tr>
							<tr class="tr1">
								<td>${blog.getPublishDate() }&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/blog.do?flag=deleteBlog&id=${blog.id }">删除日志</a></td>
							</tr>
							
					
					</table>
					</div>
				
				
				</c:forEach>
				
				
				</c:if>
				<c:if test="${blogList.size()==0 }">
				您还未发表过日志
				<a href="${pageContext.request.contextPath }/blog.do?flag=goPublishBlog">去发表日志</a>
				</c:if>
				
				
				
				



			</div>
		</div>
		<div class="blog_right">
			<img alt="" src="${pageContext.request.contextPath }/images/front/articleright.jpg">
		</div>

	</div>
	<jsp:include page="/WEB-INF/public/foot.jsp"></jsp:include>
</body>
</html>