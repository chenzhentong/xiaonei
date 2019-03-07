<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的相册</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/publicJs.js"></script>


<link rel="stylesheet" href="${pageContext.request.contextPath }/css/myApplication.css"
	type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/head2.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/foot.css" type="text/css" />
</head>
<body>
	<jsp:include page="/WEB-INF/public/head2.jsp"></jsp:include>
	<div class="main">
		<div class="application">
			<div class="title">
				<img alt="" src="${pageContext.request.contextPath }/images/front/photo.gif"><span
					class="font2"> 我的应用</span>


			</div>
			<div class="allApplication">
				暂无应用上线,敬请期待!!

				
				
					
					


			</div>

		</div>

		<div class="rightAdvice">
			<img alt="" src="${pageContext.request.contextPath }/images/front/photoright.jpg">
		</div>

	</div>

	<jsp:include page="/WEB-INF/public/foot.jsp"></jsp:include>
</body>
</html>