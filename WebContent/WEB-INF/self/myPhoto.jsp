<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的相册</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/publicJs.js"></script>


<link rel="stylesheet" href="${pageContext.request.contextPath }/css/myPhoto.css"
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
					class="font2"> 我的相册 - <c:if test="${albumList.size()==1 }">${albumList.get(0).getSort().sort }</c:if></span>


			</div>
			<div class="photoPageHead">

				<span>第${pageNow }张/共${pageCount }张 </span> 
				<span class="right">
				

						<c:if test="${pageNow>1 }">
							<a
								href="${pageContext.request.contextPath }/album.do?flag=myPhoto&pageNow=${pageNow-1 }">上一张</a>&nbsp;
						</c:if>
						<c:if test="${pageNow<=1 }">
						上一张
						</c:if>
						<c:if test="${pageNow<pageCount }">
							<a
								href="${pageContext.request.contextPath }/album.do?flag=myPhoto&pageNow=${pageNow+1 }">下一张</a>&nbsp;
						</c:if>
						<c:if test="${pageNow>=pageCount }">
						下一张
						</c:if>
				</span>
					
					


			</div>
			<div class="photo">
				<c:if test="${albumList.size()==0 }">
					
				您还未上传照片<a href="${pageContext.request.contextPath }/album.do?flag=goAddAlbum">去传照片</a>
				
				</c:if>
				<c:if test="${albumList.size()==1 }">
					
				<img alt="${albumList.get(0).getTitle() }"
					src="${pageContext.request.contextPath }/images/photos/${albumList.get(0).getPhoto2() }"
					class="img" title="${albumList.get(0).getTitle() }"/>
					

				
				</c:if>
				

			</div>
			<div class="description">
				<table>
					<tr>
						<td class="td3"></td>
						<td class="td4"><c:if test="${albumList.size()==1 }"><span>来自于&nbsp;${albumList.get(0).getSort().sort }</span></c:if></td>
					</tr>
					<tr>
						<td class="td3">
						<c:if test="${albumList.size()==1 }">
						${albumList.get(0).getPublihDate() }
						</c:if>
						
						</td>
						<td class="td4"><span class="font3">浏览(0)&nbsp;评论(0)</span></td>
					</tr>

				</table>

			</div>
			<div class="photoPageTail">
				<span class="right" class="font3">第一页/共0页</span>
			</div>
			<div class="comment">
				<form>
					<table>
						<tr>
							<td><div class="comment1">
									<input type="text" class="input1">
							</div>
						    </td>
						</tr>
						<tr>
							<td><input type="submit" value="发表评论"></td>
						</tr>

					</table>
				</form>
			</div>

		</div>

		<div class="rightAdvice">
			<img alt="" src="${pageContext.request.contextPath }/images/front/photoright.jpg">
		</div>

	</div>

	<jsp:include page="/WEB-INF/public/foot.jsp"></jsp:include>
</body>
</html>