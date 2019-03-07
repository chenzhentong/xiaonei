<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="/xiaoneinew/css/publishBlog.css"
	type="text/css" />

<link rel="stylesheet" href="/xiaoneinew/css/head2.css" type="text/css" />
<link rel="stylesheet" href="/xiaoneinew/css/foot.css" type="text/css" />
<link rel="stylesheet" href="/xiaoneinew/css/common.css" type="text/css" />
<title>发表日志</title>

</head>
<body>
	<jsp:include page="/WEB-INF/public/head2.jsp"></jsp:include>
	<div class="main">
		<div class="blog">
			<div class="title">
				<img alt="" src="${pageContext.request.contextPath }/images/front/blog.gif"><span
					class="font2">发表新日志</span>
			</div>

			<div class="publish_blog">
				<form action="${pageContext.request.contextPath }/blog.do?flag=publishBlog" method="post">
				<table>

					<tr class="tr1">
						<td><span>标题:</span><br>
						<input type="text" name="title" /></td>
					</tr>
					<tr class="tr1">
						<td><span>分类</span><br> <select name="blogsort">
								
								<c:forEach items="${blogsortList }" var="blogsort">
									<option value="${blogsort.id }">${blogsort.sort }</option>
								
								</c:forEach>
								
						</select>&nbsp;<span><a href="${pageContext.request.contextPath }/blog.do?flag=goAddBlogSort">添加分类</a></span></td>
					</tr>
					<tr>
						<td>
						
						<div class="blog_content">
							<input type="text" name="content">
						</div>
						
						</td>
						
					</tr>
					<tr>
					<td>
							<input type="submit" value="发表日志">
						
						</td>
					</tr>

				</table>
				</form>




			</div>
		</div>
		<div class="blog_right">
			<img alt="" src="${pageContext.request.contextPath }/images/front/articleright.jpg">
		</div>

	</div>
	<jsp:include page="/WEB-INF/public/foot.jsp"></jsp:include>
</body>
</html>