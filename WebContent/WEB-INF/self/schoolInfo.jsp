<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学校信息</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/publicJs.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/schoolInfo.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/commonInfo.css" type="text/css" />
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
						<td ><button onclick="location.href='${pageContext.request.contextPath }/modify.do?flag=goModifyBaseInfo'">基本信息</button></td>
						<td><button onclick="location.href='${pageContext.request.contextPath }/modify.do?flag=goModifyContractInfo'">联系方式</button></td>
						<td><button onclick="location.href='${pageContext.request.contextPath }/modify.do?flag=goModifySelfInfo'">个人信息</button></td>
						<td><button onclick="location.href='${pageContext.request.contextPath }/modify.do?flag=goModifySchoolInfo'">学校信息</button></td>
						<td><button onclick="location.href='${pageContext.request.contextPath }/modify.do?flag=goModifyWorkInfo'">工作信息</button></td>
						<td><button onclick="location.href='${pageContext.request.contextPath }/modify.do?flag=goUploadPhoto'">上传头像</button></td>
					</tr>
				</table>
				
			</div>
			<div class="modifySchoolInfo">
				<div class="privateSetup">
					你可以通过<a href="#">隐私设置</a>控制谁可以看见以下内容
				</div>
				<div class="schoolInfoForm">
					<form
						action="${pageContext.request.contextPath }/modify.do?flag=modifyContractInfo"
						method="post">
						<table>
							<tr>
								<td><span class="font3">*小学:</span></td>
								<td><input type="text" name="primarySch" value="${user.getPrimarySch() }"/></td>
								<td>可在中文姓名后添加英文名称</td>
							</tr>
							<tr>
								<td><span class="font3">*初中:</span></td>
								<td><input type="text" name="junior" value=""/></td>
								<td></td>
							</tr>
							<tr>
								<td><span class="font3">*高中:</span></td>
								<td><input type="text" name="" value=""/></td>
								<td></td>
							</tr>
							<tr>
								<td><span class="font3">*大学:</span></td>
								<td><input type="text" name="university" value=""></td>
								<td></td>
							</tr>
							<tr>
								<td><span class="font3">*技校:</span></td>
								<td><input type="text" name="techSch" value=""></td>
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