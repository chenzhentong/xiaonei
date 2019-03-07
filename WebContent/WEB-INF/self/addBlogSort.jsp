<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/addBlogSort.css"
	type="text/css" />

<link rel="stylesheet" href="${pageContext.request.contextPath }/css/head2.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/foot.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css" type="text/css" />
<title>添加日志类别</title>

</head>
<body>
	<jsp:include page="/WEB-INF/public/head2.jsp"></jsp:include>
	<div class="main">
		<div class="blog">
			<div class="title">
				<img alt="" src="${pageContext.request.contextPath }/images/front/blog.gif"><span
					class="font2">添加日志类别</span>
			</div>

			<div class="publish_blog">
				<form action="${pageContext.request.contextPath }/blogsort.do?flag=addBlogSort" method="post">
				<table>

					<tr class="tr1">
						<td><span>类别:</span><br>
						<input type="text" name="sort" /></td>
					</tr>
					
					<tr>
					<td>
							<input type="submit" value="添加类别">
						
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