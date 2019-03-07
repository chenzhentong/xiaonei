<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>基本信息</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/publicJs.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/baseInfo.css"
	type="text/css" />

<link rel="stylesheet" href="${pageContext.request.contextPath }/css/commonInfo.css"
	type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/head2.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/foot.css" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.3.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/myAJAX/ajax_verifyCode.js"></script>
<script type="text/javascript">
<!--
    //当页面加载时，根据性别来选择单选框的值
    $().ready(function(){
    	var sex="${user.getSex() }";
    	if(sex=="男")
    	{
    		$("input[type='radio']").get(0).checked=true;
    		
    	}
    	else if(sex=="女")
    	{
    		$("input[type='radio']").get(1).checked=true;
    		
    	}
    });
	
	  function checkVerifyCode()
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
				//swindow.alert(responseText);

				if (responseText.trim()=="true") {
					
					$("#sp2").html("验证成功");	
					commonChange('sp2', 'ok0');	
				}
				else
				{
					$("#ok0").css("width","0");
					$("#ok0").css("height","0");
					$("#sp2").html("验证错误");
					
				}
				
				
				
			}
		}
	}
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
			var req="/xiaoneinew/verifyCode";
			//window.alert(req);
			xmlrequest.open("get",req,true);
			//指定处理结果的函数
			xmlrequest.onreadystatechange = getVerifyCode;
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
				
				$("[id='img1']").attr("src","/xiaoneinew/verifyCode");
				
				
				console.log(1);
			}
		}
	}
	function checkForm()
	{
		
		var width=$("#ok0").width();
		if(width==0)
		{
			$("#sp2").html("请输入正确的验证码!!");
			return false;
		}
	
		
		return true;
	}

	-->
</script>

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
			<div class="modifyBaseInfo">
				<div class="privateSetup">
					你可以通过<a href="#">隐私设置</a>控制谁可以看见以下内容
				</div>
				<div class="baseInfoForm">
					<form action="${pageContext.request.contextPath }/modify.do?flag=modifyBaseInfo" method="post" onsubmit="return checkForm()">
					

					<table >
						<tr>
							<td class="td1"><span class="font3">*姓名:</span></td>
							<td class="td2"><input type="text" name="name"
								value="${user.getName() }" /></td>
							<td>可在中文姓名后添加英文名称</td>
						</tr>
						<tr>
							<td class="td1"><span class="font3">*性别:</span></td>
							<td class="td2">
							
							<input type="radio" name="sex" value="男"  id="nan">男<input
								type="radio" name="sex" value="女" id="nv">女</td>
							<td></td>
						</tr>
						<tr>
							<td class="td1"><span class="font3">*家乡:</span></td>
							<td class="td2"><select name="homePro">
									<option value="${user.homePro.name }">${user.homePro.name }</option>
							</select> <select name="homeCity">
									<option value="${user.homeCity.name }">${user.homeCity.name }</option>
							</select></td>
							<td></td>
						</tr>
						<tr>
							<td class="td1"><span class="font3">*生日:</span></td>
							<td class="td2"><input type="text" name="birthday"
								value="${user.getBirthday() }"></td>
							<td></td>
						</tr>
						<tr>
							<td class="td1"><span class="font3" >*验证码:</span></td>

									<td class="td2"><input type="text" value=""
										onblur="checkVerifyCode()" id="verifyCode">
							</td>
							<td ><span id="sp1" >  <img alt="" src="/xiaoneinew/verifyCode" id="img1">
										</span>
										<a href="javascript:void(0)" onclick="setVerifyCode(this)">看不清,换一张</a>
										
										</td>
							<td><span id="sp2"></span><img alt=""
							src="/xiaoneinew/images/front/fzcg_dh.gif" width="0" height="0"
							id="ok0"></td>
							

						</tr>

						<tr>
							<td class="td1"></td>
							<td class="td2">
							<input type="submit" value="修改">
							<input type="reset" value="取消"></td>
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