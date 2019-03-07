<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/searchFriends.css"
	type="text/css" />

<link rel="stylesheet" href="${pageContext.request.contextPath }/css/head2.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/foot.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css" type="text/css" />
<title>搜索</title>

</head>
<body>
	<jsp:include page="/WEB-INF/public/head2.jsp"></jsp:include>
	<div class="main">
		<div class="searchFriends">
			<div class="title">
				<img alt="" src="${pageContext.request.contextPath }/images/front/friends.gif"><span
					class="font2"> 高级搜索</span>
			</div>
			<div class="table1">
				<form action="${pageContext.request.contextPath }/search.do?flag=searchAllFriends" method="post">
				
				<table>
					<tr>
						<td class="td1"><span class="font3">姓名:</span></td>
						<td class="td2"><input type="text" name="name"></td>
					</tr>
					<tr>
						<td class="td1"><span class="font3">大学:</span></td>
						<td><input type="text" name="">
						&nbsp;
						<select>
						<option>入学年份</option>
						</select></td>
					</tr>
					<tr>
						<td class="td1"><span class="font3">院系:</span></td>
						<td><input type="text" name=""></td>
					</tr>
					<tr>
						<td class="td1"><span class="font3">宿舍:</span></td>
						<td><input type="text" name=""></td>
					</tr>
					<tr>
						<td class="td1"><span class="font3">高中:</span></td>
						<td><input type="text" name=""></td>
					</tr>
					<tr>
						<td class="td1"><span class="font3">班级:</span></td>
						<td>
					
						<select>
						<option>请选择年级</option>
						</select>
						&nbsp;
						<select>
						<option>请选择班级</option>
						</select>
						&nbsp;
						<select>
						<option>入学年份</option>
						</select>
						
						</td>
					</tr>
					<tr>
						<td class="td1"><span class="font3">初中:</span></td>
						<td><input type="text" name="">&nbsp;
						<select>
						<option>入学年份</option>
						</select></td>
					</tr>
					<tr>
						<td class="td1"><span class="font3">小学:</span></td>
						<td><input type="text" name="">&nbsp;
						<select>
						<option>入学年份</option>
						</select></td>
					</tr>
					<tr>
						<td class="td1"><span class="font3">性别:</span></td>
						<td><input type="text" name=""></td>
					</tr>
					<tr>
						<td class="td1"><span class="font3">生日:</span></td>
						<td><input type="text" name=""></td>
					</tr>
					<tr>
						<td class="td1"><span class="font3">家乡:</span></td>
						<td>
						<select>
						<option>选择省份</option>
						</select>
						&nbsp;
						<select>
						<option>选择城市</option>
						</select>
						
						
						</td>
					</tr>
					<tr>
						<td class="td1"><span class="font3">星座:</span></td>
						<td><select>
						<option>选择星座</option>
						</select></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="搜索"  class="searchBtn"></td>
						
					</tr>
					

				</table>
				</form>
				
			</div>
		</div>
		<div class="friends_right">
			<img alt="" src="${pageContext.request.contextPath }/images/front/friendright.jpg">
		</div>

	</div>
	<jsp:include page="/WEB-INF/public/foot.jsp"></jsp:include>
</body>
</html>