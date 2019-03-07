<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传照片</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/addAlbum.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/common.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/head2.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/foot.css" type="text/css">

</head>
<body>
	<jsp:include page="/WEB-INF/public/head2.jsp"></jsp:include>
	<div class="album">
		<div class="album_func">
			<div class="title1">
				<img alt=""
					src="${pageContext.request.contextPath }/images/front/photo.gif" /><span
					class="font5">上传新照片</span><br>
			</div>
			<div class="addAlbum">
				<div class="title2">
					<img alt=""
						src="${pageContext.request.contextPath }/images/front/photo.gif" /><span
						class="font5">创建相册</span>
				</div>
				<div class="addAlbum_form">

					<form
						action="${pageContext.request.contextPath }/albumsort.do?flag=addAlbum"
						method="post">

						<table>
							<tr>
								<td><span class="font3">类型</span></td>
								<td><input type="text" name="sort" /></td>

							</tr>

							<tr>
								<td><span class="font3">谁能浏览</span></td>
								<td><select>
										<option>仅自己</option>
										<option>我的好友</option>
										<option>我的好友及所有同网络的人</option>
										<option>所有人</option>

								</select></td>

							</tr>
							<tr>
								<td></td>
								<td><input type="submit" value="创建相册"> <input
									type="reset" value="取消"></td>

							</tr>
						</table>

					</form>


				</div>


			</div>
			<div class="choose_album">
				<div class="title3">
					<img alt=""
						src="${pageContext.request.contextPath }/images/front/photo.gif" /><span
						class="font5">选择相册</span>
				</div>
				<div class="chooseAlbum_form">

					<form action="${pageContext.request.contextPath }/albumsort.do?flag=goAddPhoto" method="post">

						<table>
							<tr>
								<td>选择相册</td>
								<td><select name="sort">
									<c:forEach items="${albumsortList }" var="albumsort" >
										<option value="${albumsort.id }" >${albumsort.sort }</option>
									
									
									</c:forEach>


										
								</select></td>


							</tr>
							<tr>
								<td></td>
								<td><input type="submit" value="确定"> <input
									type="reset" value="取消"></td>


							</tr>

						</table>
					</form>
				</div>


			</div>




		</div>
		<div class="right_adv">
			<img alt=""
				src="${pageContext.request.contextPath }/images/front/albumright.jpg">


		</div>







	</div>

	<jsp:include page="/WEB-INF/public/foot.jsp"></jsp:include>

</body>
</html>