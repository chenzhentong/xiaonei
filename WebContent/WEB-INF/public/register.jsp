<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>用户注册</title>

<link rel="stylesheet" href="${pageContext.request.contextPath }/css/register.css"
	type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/publicJs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/myAJAX/ajax_uni.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/myAJAX/ajax_pro.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/myAJAX/ajax_city.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.3.1.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/head.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/foot.css" type="text/css" />

</head>
<body>


	<jsp:include page="/WEB-INF/public/head.jsp" />
	<div class="reg_main_frame">
		<div class="play_itmes">
			<img alt="" src="${pageContext.request.contextPath }/images/front/jiaru.jpg">
		</div>
		<div class="fast_reg">
			<span class="font2">简单一步,快速注册</span><br />
			<form action="${pageContext.request.contextPath }/register.do?flag=register" method="post" onsubmit="return checkRegisterForm()">
				<table class="reg_table1">
					<tr>
						<td class="tab_td1">真实姓名:</td>
						<td class="tab_td2"><input type="text" name="name" id="name"
							class="input1" onblur="check(this,'spanVal1','ok1')"
							onfocus="nameTip(this,'spanVal1','ok1')" /></td>
						<td><span class="spanVal1" id="spanVal1"></span><img alt=""
							src="${pageContext.request.contextPath }/images/front/fzcg_dh.gif" width="0" height="0"
							id="ok1"></td>
					</tr>
					<tr>
						<td class="tab_td1">性别:</td>
						<td class="tab_td2"><input type="radio" name="sex" value="男"  checked/>&nbsp;男&nbsp;
							<input type="radio" name="sex" value="女" />&nbsp;女</td>
						<td></td>
					</tr>
					<tr>
						<td class="tab_td1">身份:</td>
						<td class="tab_td2"><select size="4" onchange="changeStatus(this)" name="identity" id="identity">
								
								<option value="worker" >已经工作</option>
								<option value="graduate" >大学生</option>
								<option value="midstu" >中学生/中专技校</option>
								<option value="nothing" >以上都不是</option>
						</select></td>
						<td></td>
					</tr>

					<tr class="gra_spe" id="gra_type">
						<td class="tab_td1">类型:</td>
						<td><select  name="usersType">
								<option value="请选择类型">请选择类型</option>
								<option value="大学生" >大学生</option>
								<option value="硕士" >硕士</option>
								<option value="博士" >博士</option>
								<option value="校工" >校工</option>
								<option value="教师" >教师</option>

						</select></td>
						<td></td>
					</tr>
					<tr class="gra_spe" id="gra_uni">
						<td class="tab_td1">大学:</td>
						<td class="tab_td2">
						<input type="hidden" name="universityId" id="universityId" value="">
						<input type="text" name="university1"  class="input1" onclick="show('div_uni')"  id="university1" placeholder="请选择大学" readonly="readonly"/></td>
						<td class="tab_td3"><span >校内网现在对全球大学生开放</span></td>
					</tr>
					<tr class="midstu" id="gra_uni">
						<td class="tab_td1">中学/中专院校:</td>
						<td class="tab_td2">
						<input type="hidden" name="techSchId" id="techSchId" value="">
						<input type="text" name="techSch1"  class="input1" onclick="show()"  id="techSch1" placeholder="请选择学校" readonly="readonly"/></td>
						<td class="tab_td3"><span ></span></td>
					</tr>
					<tr class="worker_sep" id="worker_pro">
						<td class="tab_td1">居住地:</td>
						<td class="tab_td2"><select name="homePro" id="homePro">
						        <c:forEach items="${provinceList }" var="province">
						        	<option value="${province.getId()}" onclick="setProCity(this)" id="${province.getId()}">${province.getName()}</option>
						        </c:forEach>
								
				
						</select></td>
						<td></td>
					</tr>
					<tr class="worker_sep" id="worker_city">
						<td class="tab_td1"></td>
						<td class="tab_td2" ><select name="homeCity"   id="homeCity">
								 <c:forEach items="${cityList }" var="city">
						        	<option value="${city.getId()}" >${city.getName()}</option>
						        </c:forEach>
						</select></td>
						<td></td>
					</tr>
				

					<tr>
						<td class="tab_td1">电子邮箱:</td>
						<td class="tab_td2"><input type="text" name="email" id="email"
							class="input1" onblur="check(this,'spanVal4','ok4')"
							onfocus="nameTip(this,'spanVal4','ok4')"></td>
						<td><span id="spanVal4"></span><img alt=""
							src="${pageContext.request.contextPath }/images/front/fzcg_dh.gif" width="0" height="0"
							id="ok4"></td>
					</tr>
					<tr>
						<td class="tab_td1"></td>
						<td class="tab_td2"><img alt="" src="${pageContext.request.contextPath }/images/front/16_info.png">如果没有邮箱,请注册Hotmail邮箱。</td>
						<td></td>
					</tr>
					<tr>
						<td class="tab_td1">设置密码:</td>

						<td class="tab_td2"><input type="password" name="pwd"
							class="input1" onblur="check(this,'spanVal2','ok2')"
							onfocus="nameTip(this,'spanVal2','ok2')" maxlength="16" id="psd"></td>
						<td><span id="spanVal2"></span><img alt=""
							src="${pageContext.request.contextPath }/images/front/fzcg_dh.gif" width="0" height="0"
							id="ok2"></td>
					</tr>
					<tr>
						<td class="tab_td1">确认密码:</td>
						<td class="tab_td2"><input type="password" id="psd2"
							class="input1" onblur="check(this,'spanVal3','ok3')"
							onfocus="nameTip(this,'spanVal3','ok3')" maxlength="16"></td>

						<td><span id="spanVal3"></span><img alt=""
							src="${pageContext.request.contextPath }/images/front/fzcg_dh.gif" width="0" height="0"
							id="ok3"></td>
					</tr>
					<tr>
						<th class="tab_td1">验证码:</th>
						<td class="tab_td2">请输入一下验证码,看不清楚换一张</td>

						<td></td>
					</tr>
					<tr>

						<td class="tab_td1"></td>
						<td colspan="2"><input type="image" onclick=""
							src="${pageContext.request.contextPath }/images/front/regbtn.gif" ></td>
					</tr>
					<tr>

						<td class="tab_td1"></td>
						<td colspan="2"><input type="checkbox" name="obey" value="" >我已同意并遵守校内服务条款</td>
					</tr>



				</table>
			</form>


		</div>
	</div>
	<jsp:include page="/WEB-INF/public/foot.jsp" />
	<div class="div_uni" id="div_uni">

		<div class="country_div">
			<c:forEach items="${countryList }" var="country">

				<td><a href="javascript:void(0);" id="${country.id }"  onclick='setCouPro(this)'>${country.getName() }</a>&nbsp;|</td>
			</c:forEach>
		</div>
		<div class="province_div" id="province_div">
			<c:forEach items="${provinceList }" var="province">

				<td><a href="javascript:void(0);" id="${province.id }"
					name="${province.country.id }" onclick='setProUnis(this)'>${province.getName() }</a>&nbsp;&nbsp;</td>
			</c:forEach>
		</div>

		<div class="university_div" id="university_div">
			
			<table>
			
			<tr>
			<c:forEach begin="0" end="${universityList.size()-1 }" var="count">
				<td><li>
				<a href="javascript:void(0);" onclick="confirm(this)" id="${universityList.get(count).getId() }"> ${universityList.get(count).getName() }</a>&nbsp;&nbsp;
				<c:if test="${(count+1)%3==0 }">
						</tr><tr>
					</c:if>
				</li>
				</td>
				
			
			</c:forEach>
			
			</tr>
			
			</table>
			
		</div>
		<button onclick="hide('div_uni')" class="btn1">关闭窗口</button>

	</div>
</body>
</html>
