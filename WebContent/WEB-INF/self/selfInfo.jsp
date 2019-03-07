<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/publicJs.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/selfInfo.css"
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
						<td><button
								onclick="location.href='${pageContext.request.contextPath }/modify.do?flag=goModifyBaseInfo'">基本信息</button></td>
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
			<div class="modifySelfInfo">
				<div class="privateSetup">
					你可以通过<a href="#">隐私设置</a>控制谁可以看见以下内容
				</div>
				<div class="selfInfoForm">
					<form
						action="${pageContext.request.contextPath }/modify.do?flag=modifySelfInfo"
						method="post">
						<table>
							<tr>
								<td><span class="font3">*兴趣:</span></td>
								<td><input type="text" name="interset"
									value="${user.getInterset() }" /></td>
								<td></td>
							</tr>
							<tr>
								<td><span class="font3">*音乐:</span></td>
								<td><input type="text" name="music"
									value="${user.getMusic() }" /></td>
								<td></td>
							</tr>
							<tr>
								<td><span class="font3">*游戏:</span></td>
								<td><input type="text" name="game"
									value="${user.getGame() }" /></td>
								<td></td>
							</tr>
							<tr>
								<td><span class="font3">*卡通:</span></td>
								<td><input type="text" name="cartoon"
									value="${user.getCartoon() }"></td>
								<td></td>
							</tr>
							<tr>
								<td><span class="font3">*运动:</span></td>
								<td><input type="text" name="sport"
									value="${user.getSport() }"></td>
								<td></td>
							</tr>
							<tr>
								<td><span class="font3">*书籍:</span></td>
								<td><input type="text" name="book"
									value="${user.getBook() }"></td>
								<td></td>
							</tr>

							<tr>
								<td><span class="font3">*验证码:</span></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="submit" value="保存修改"><input
									type="reset" value="取消"></td>
								<td></td>
							</tr>

						</table>



					</form>
				</div>
			</div>


		</div>
		<div class="rightAdvice">
			<img alt="" src="${pageContext.request.contextPath }/images/front/selfright.jpg">
		</div>

	</div>



	<jsp:include page="/WEB-INF/public/foot.jsp"></jsp:include>
</body>
</html>