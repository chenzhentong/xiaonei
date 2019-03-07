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
	function setHome(url)
	{
		if(document.all)
		{
			document.body.style.behavior='url(#default#homepage)';
			document.setHomePage(url);
		}
		else
		{
			alert("您好,您的浏览器不支持自动设置页面为首页功能,请您手动在浏览器里设置该页面为首页!");
		}
		
	}
	function AddFavorite(url,title)
	{
		
		
		url=encodeURI(url);
		try
		{
			window.external.addFavorite(url,title);
		}
		catch(e){
			try
			{
				window.sidebar.addPanel(title,url,"");
			}catch(e) { 
 
                alert("加入收藏失败，请使用Ctrl+D进行添加,或手动在浏览器里进行设置.");
 
            }  
		}
	}

	-->
</script>


	<div class="head">

		<img src="${pageContext.request.contextPath }/images/front/top1.gif" class="img1" /> <img
			src="${pageContext.request.contextPath }/images/front/top2.jpg" class="img2" /> <img
			src="${pageContext.request.contextPath }/images/front/xnw3.jpg" />
		<ul class="nav">



			<li onmouseover="changeBG(this)" onmouseout="changeBG2(this)"><a class="anavi"  href="${pageContext.request.contextPath }/register.do?flag=goToRegister" >注册</a></li>
			<li onmouseover="changeBG(this)" onmouseout="changeBG2(this)"><a class="anavi" href="javascript:void(0)" onclick="setHome('http://localhost/8080/${pageContext.request.contextPath}')">设为主页</a></li>
			
			
			<li onmouseover="changeBG(this)" onmouseout="changeBG2(this)"><a class="anavi" href="javascript:void(0)" onclick="AddFavorite('http://localhost/8080/${pageContext.request.contextPath}',document.title)">加入收藏</a></li>
			<li onmouseover="changeBG(this)" onmouseout="changeBG2(this)"><a class="anavi" href="">帮助</a></li>
		</ul>


	</div>

