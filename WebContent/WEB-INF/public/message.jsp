<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
div {
	text-align: center;
}
</style>

</head>
<body>
	<div>
	
		<c:if test="${message!=null }">${message }<a href="${pageContext.request.contextPath }/register.do?flag=goToRegister">返回重新注册</a></c:if>
		
	
	</div>
	<div>
	
		<c:if test="${message2!=null }">${message2 }<a href="${pageContext.request.contextPath }">返回主页</a></c:if>
		
	
	</div>
	<div>
	
	<c:if test="${message3!=null }">${message3 }<a href="${pageContext.request.contextPath }/profile.do?flag=goHomePage">返回个人主页</a></c:if>
	</div>
	<div>
	
	<c:if test="${message4!=null }">${message4 }<a href="${pageContext.request.contextPath }/modify.do?flag=goUploadPhoto">返回重新上传照片</a></c:if>
	</div>
	<div>
	
	<c:if test="${message5!=null }">${message5 }<a href="${pageContext.request.contextPath }/album.do?flag=goAddAlbum">去上传照片</a></c:if>
	</div>
	<div>
	
	<c:if test="${message6!=null }">${message6 }<a href="${pageContext.request.contextPath }/modify.do?flag=goModifyBaseInfo">返回修改页面</a></c:if>
	</div>
	<div>
	<c:if test="${message7!=null }">${message7 }<a href="${pageContext.request.contextPath }/blog.do?flag=goPublishBlog">返回发表日志</a></c:if>
	</div>
	<div>
	<c:if test="${message8!=null }">${message8 }<a href="${pageContext.request.contextPath }/blog.do?flag=goPublishBlog">返回继续发表日志</a></c:if>
	</div>
	<div>
	<c:if test="${message9!=null }">${message9 }<a href="${pageContext.request.contextPath }/blog.do?flag=goManageBlog">返回日志列表</a></c:if>
	</div>
	<div>
	<c:if test="${message10!=null }">${message10 }<a href="${pageContext.request.contextPath }/profile.do?flag=goHomePage">返回个人主页</a></c:if>
	</div>
	<div>
	<c:if test="${message11!=null }">${message11 }<a href="${pageContext.request.contextPath }/album.do?flag=goAddAlbum">返回重新创建相册</a></c:if>
	</div>
	<div>
	<c:if test="${message12!=null }">${message12 }<a href="${pageContext.request.contextPath }/album.do?flag=myPhoto">返回我的相册</a></c:if>
	</div>
	<div>
	<c:if test="${message13!=null }">${message13 }<a href="${pageContext.request.contextPath }/search.do?flag=goSearchFriends">返回继续添加好友</a></c:if>
	</div>
	<div>
	<c:if test="${message14!=null }">${message14 }<a href="${pageContext.request.contextPath }/friend.do?flag=specialFriends">查看特别好友</a></c:if>
	</div>
</body>
</html>