<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>联系方式</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/publicJs.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/commonInfo.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/contractInfo.css" type="text/css" />
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
			<div class="modifyContractInfo">
				<div class="privateSetup">
					你可以通过<a href="#">隐私设置</a>控制谁可以看见以下内容
				</div>
				<div class="contractInfoForm">
					<form
						action="${pageContext.request.contextPath }/modify.do?flag=modifyContractInfo"
						method="post">
						<table>
							<tr>
								<td><span class="font3">*电话:</span></td>
								<td><input type="text" name="tel" value="${user.getTel() }"/></td>
								<td></td>
							</tr>
							<tr>
								<td><span class="font3">*手机:</span></td>
								<td><input type="text" name="mobile" value="${user.getMobile() }"/></td>
								<td></td>
							</tr>
							<tr>
								<td><span class="font3">*邮箱:</span></td>
								<td><input type="text" name="email" value="${user.getEmail() }"/></td>
								<td></td>
							</tr>
							<tr>
								<td><span class="font3">*oicq:</span></td>
								<td><input type="text" name="oicq" value="${user.getOicq() }"/></td>
								<td></td>
							</tr>
							<tr>
								<td><span class="font3">*MSN:</span></td>
								<td><input type="text" name="msn" value="${user.getMsn() }"></td>
								<td></td>
							</tr>
							<tr>
								<td><span class="font3">*网站:</span></td>
								<td><input type="text" name="website" value="${user.getWebsite() }"></td>
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