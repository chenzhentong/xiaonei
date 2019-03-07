<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script type="text/javascript">
<!--
	function changeBG(o) {
		o.style.backgroundColor = "#5c7daa";
	}
	function changeBG2(o) {
		o.style.backgroundColor = "";
	}

	-->
</script>


	<div class="head2">

		<img src="${pageContext.request.contextPath }/images/front/top1.gif" class="img1" /> <img
			src="${pageContext.request.contextPath }/images/front/top2.jpg" class="img2" /> <img
			src="${pageContext.request.contextPath }/images/front/xnw3.jpg" />
		<ul class="nav">
	     	<li ><a  href="${pageContext.request.contextPath }/profile.do?flag=goHome" class="anavi2">首页</a></li>
	     	<li ><a  href="${pageContext.request.contextPath }/profile.do?flag=goHomePage" class="anavi2">个人主页</a></li>
	     	<li ><a  href="${pageContext.request.contextPath }/modify.do?flag=goModifyBaseInfo" class="anavi2">修改</a></li>
	     	<li ><a  href="${pageContext.request.contextPath }/friend.do?flag=myFriends" class="anavi2">好友</a></li>
	     	<li ><a  href="${pageContext.request.contextPath }/profile.do?flag=goMyApplication" class="anavi2" >应用</a></li>
	     	<li ><a  href="${pageContext.request.contextPath }/friend.do?flag=inviteFriends" class="anavi2">邀请</a></li>
	     	<li ><a  href="#" class="anavi2">班级</a></li>
	     	<li ><a  href="${pageContext.request.contextPath }/mail.do?flag=goSendMail" class="anavi2">站内信</a></li>
	     	<li ><a  href="${pageContext.request.contextPath }/search.do?flag=goSearchFriends" class="anavi2">搜索</a></li>
	     	<li style="width:180px;"><input type="text" /><input type="image" src="${pageContext.request.contextPath }/images/front/sou.jpg" class="img3"/></li>
			<li onmouseover="changeBG(this)" onmouseout="changeBG2(this)"><a class="anavi"  href="#">账号</a></li>
			<li onmouseover="changeBG(this)" onmouseout="changeBG2(this)"><a class="anavi" href="#">隐私</a></li>
			<li onmouseover="changeBG(this)" onmouseout="changeBG2(this)"><a class="anavi" href="${pageContext.request.contextPath }/login.do?flag=logout">退出</a></li>
				
		</ul>


	</div>

