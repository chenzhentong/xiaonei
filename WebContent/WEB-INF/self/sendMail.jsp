<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="/xiaoneinew/css/sendMail.css"
	type="text/css" />

<link rel="stylesheet" href="/xiaoneinew/css/head2.css" type="text/css" />
<link rel="stylesheet" href="/xiaoneinew/css/foot.css" type="text/css" />
<link rel="stylesheet" href="/xiaoneinew/css/common.css" type="text/css" />
<title>发表日志</title>

</head>
<body>
	<jsp:include page="/WEB-INF/public/head2.jsp"></jsp:include>
	<div class="main">
		<div class="mail">
			<div class="title">
				<img alt="" src="${pageContext.request.contextPath }/images/front/blog.gif"><span
					class="font2">发站内信</span>
			</div>

			<div class="publish_mail">
				<form action="${pageContext.request.contextPath }/mail.do?flag=sendMail" method="post">
				<table>

					
					<tr class="tr1">
						<td><br> <select name="receiverId">
								
								<c:forEach items="${userList }" var="user" >
									<option value="${user.id }">${user.name }</option>
								
								</c:forEach>
								
						</select>&nbsp;<span>选择好友</span></td>
					</tr>
					<tr>
						<td>
						
						<div class="mail_content">
							<input type="text" name="content">
						</div>
						
						</td>
						
					</tr>
					<tr>
					<td>
							<input type="submit" value="发送">
						
						</td>
					</tr>

				</table>
				</form>




			</div>
		</div>
		<div class="mail_right">
			<img alt="" src="${pageContext.request.contextPath }/images/front/articleright.jpg">
		</div>

	</div>
	<jsp:include page="/WEB-INF/public/foot.jsp"></jsp:include>
</body>
</html>