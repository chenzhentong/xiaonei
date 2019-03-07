<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/xiaoneinew/js/jquery-1.3.1.js"></script>
<script type="text/javascript">
	<!--

	//响应目标函数
	var xmlrequest;
	function createXMLHttpRequest()
	{
		if(window.ActiveXObject)
		{
			xmlrequest=new ActionXObject("Miscrosoft.XMLHTTP");
			
		}
		else
		{
			xmlrequest=new XMLHttpRequest();
			
		}

	}
	function setVerifyCode(o)
	{
		createXMLHttpRequest();
		if(xmlrequest)
		{
			var req="/xiaoneinew/verifyCode2";
		//	window.alert(req);
			xmlrequest.open("get",req,true);
			//指定处理结果的函数
			xmlrequest.onreadystatechange = getVerifyCode
			//发送请求
			xmlrequest.send();
		}
	}
	function getVerifyCode()
	{
		//window.alert("0");
		if(xmlrequest.readyState==4)
		{
			//window.alert("1");
			//成功
			if(xmlrequest.status==200)
			{
				var responseText=xmlrequest.responseText;
				console.log(responseText);
				//window.alert(responseText);
				//$("#sp1").val(responseText);
				//document.getElementById("sp1").innerHTML=responseText;
				
				//document.getElementById("img1").src="/xiaoneinew/verifyCode";
				$("[id='img1']").attr("src","/xiaoneinew/verifyCode2");
				$("#sp3").html("${sesseionScope.verifyCode }");
				
				console.log(1);
			}
		}
	}
	function getVerifyCodeValue()
	{
		
		var value="${sessionScope.verifyCode }";
		window.alert(value);
	}
	function check()
	{
		createXMLHttpRequest();
		if(xmlrequest)
		{
		    var verifyCode=$("#verifyCode").val();
		    var req="/xiaoneinew/checkVerifyCode?verifyCode="+verifyCode;
		   // window.alert(req);
		    xmlrequest.open("get",req,true);
			//指定处理结果的函数
			xmlrequest.onreadystatechange = getResult;
			//发送请求
			xmlrequest.send();
		    
		}
	}
	function getResult()
	{
		//window.alert("0");
		if(xmlrequest.readyState==4)
		{
			//window.alert("1");
			//成功
			if(xmlrequest.status==200)
			{
				var responseText=xmlrequest.responseText;
				
				window.alert(responseText);
				
			}
		}
	}
	
-->
</script>
</head>
<body>
	<div id="#div">
	
	<h1>验证码</h1>
	<a href="javascript:void(0)" onclick="setVerifyCode(this)">看不清,换一张</a>
	
    <img alt="" src=""id="img1">
    <span id="sp1">${sessionScope.verifyCode }</span>
    <button onclick="getVerifyCodeValue()">获取验证码值</button>
    <%=request.getSession().getAttribute("verifyCode") %>
    <input type="text" name="verifyCode" id="verifyCode">
    <button onclick="check()">检验</button>
    <span id="sp3"></span>
        <span id="sp4">${verifyCode }</span>
	
	</div>
    <%=request.getAttribute("verifyCode")%>
</body>
</html>