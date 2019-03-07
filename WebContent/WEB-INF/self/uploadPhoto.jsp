<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传头像</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/publicJs.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/uploadPhoto.css"
	type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/commonInfo.css"
	type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/head2.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/foot.css" type="text/css" />
</head>
<body>
	<jsp:include page="/WEB-INF/public/head2.jsp"></jsp:include>
	<div class="modifyInfo">
		<div class="choice">
			<div class="table">
				<table border="1px">
					<tr>
						<td><button	onclick="location.href='${pageContext.request.contextPath }/modify.do?flag=goModifyBaseInfo'">基本信息</button></td>
						<td><button
								onclick="location.href='${pageContext.request.contextPath }/modify.do?flag=goModifyContractInfo'">联系方式</button></td>
						<td><button
								onclick="location.href='${pageContext.request.contextPath }/modify.do?flag=goModifySelfInfo'">个人信息</button></td>
						<td><button
								onclick="location.href='${pageContext.request.contextPath }/modify.do?flag=goModifySchoolInfo'">学校信息</button></td>
						<td><button
								onclick="location.href='${pageContext.request.contextPath }/modify.do?flag=goModifyWorkInfo'">工作信息</button></td>
						<td><button
								onclick="location.href='${pageContext.request.contextPath }/modify.do?flag=goUploadPhoto'">上传头像</button></td>
					</tr>
				</table>

			</div>
			<div class="nowPhoto">
				<span class="font2">当前头像</span><br> <span class="font3">你可以到你的<a>头像相册</a>里选择照片设置为当前头像
				</span> <img alt="" src="${pageContext.request.contextPath }/images/userhead2/${user.getPhoto2() }">

			</div>
			<div class="uploadPhoto">
				<span class="font2">上传头像</span><br> <span class="font3">上传真实头像，成为<a>星级用户</a>,即可拥有无限相册空间
				</span><br> <span class="font3">支持JPG、JPEG、GIF、BMP和PNG文件格式，最大1M。头像高度超出宽度的1.5的部分会被切除</span><br>
				<form
					action="${pageContext.request.contextPath }/modify.do?flag=uploadPhoto"
					method="post" enctype="multipart/form-data">
					<!--<input type="text">  -->
					<input type="file" name="photo"><br> <input
						type="submit" value="上传头像">
				</form>
			</div>
		</div>
		<div class="rightAdvice">
			<img alt="" src="${pageContext.request.contextPath }/images/front/selfright.jpg">
		</div>

	</div>

	<jsp:include page="/WEB-INF/public/foot.jsp"></jsp:include>
</body>
</html>