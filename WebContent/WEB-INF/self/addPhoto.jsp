<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的相册</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/publicJs.js"></script>


<link rel="stylesheet" href="${pageContext.request.contextPath }/css/addPhoto.css"
	type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/head2.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/foot.css" type="text/css" />
</head>
<body>
	<jsp:include page="/WEB-INF/public/head2.jsp"></jsp:include>
	<div class="main">
		<div class="editAlbum">
			<div class="title">
				<img alt="" src="${pageContext.request.contextPath }/images/front/photo.gif"><span
					class="font2"> 编辑相册 - ${albumsort.getSort() }</span>
				<div class="choice">
                   
					<table>
						<tr>
							<td class="td1"><a href="#" class="aStyle"
								style="color: white">上传新照片</a></td>
							<td class="td1"><a href="#">编辑相册信息</a></td>
							<td class="td1"><a href="#">删除相册</a></td>
							<td class="td1"><a href="${pageContext.request.contextPath }/album.do?flag=myPhoto">返回相册</a></td>
						</tr>

					</table>

				</div>
				<div class="message">
					<span class="font3">您可以上传JPG、JPEG、GIF、PNG或BMP文件</span>

				</div>
				<div class="addPhoto">
					<form action="${pageContext.request.contextPath }/album.do?flag=addPhoto" method="post" enctype="multipart/form-data">
                        

						<table>
								
								
							   
							
								<tr>
								<td><span class="font3">标题:</span><input type="text" name="title"><input type="file" name="photo">
								<input type="hidden" value="${albumsort.getId() }" name="sort">
								
								</td>
								
							    </tr>
							
							
							
							
							<tr>
								<td><input type="submit"  value="上传照片"><input type="reset" value="取消"></td>
							</tr>
							<tr>
								<td><span class="font3">每次上传限制15MB,如果上传不了,请试试更小的图片</span></td>
							</tr>

						</table>
					</form>

				</div>
			</div>




		</div>
		<div class="rightAdvice">
			<img alt="" src="/xiaoneinew/images/front/photoright.jpg">
		</div>

	</div>

	<jsp:include page="/WEB-INF/public/foot.jsp"></jsp:include>
</body>
</html>