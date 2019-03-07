function changeStatus(obj) {
	if (obj.value == '请选择') {
		window.alert("请选择!");
	}

	if (obj.value == 'worker') {
		$(".midstu").css("display", "none");
		

		$(".gra_spe").css("display", "none");
		$(".worker_sep").css("display", "table-row");
		

		//$(".worker_sep").css("display", "block");

	} else if (obj.value == 'graduate') {
		$(".midstu").css("display", "none");
		

		$(".gra_spe").css("display", "table-row");
		//$(".gra_spe").css("display", "block");
		/*
		 * $(".gra_spe .tab_td1").css("position","relative"); $(".gra_spe
		 * .tab_td1").css("left","100px");
		 */
		$(".worker_sep").css("display", "none");

	} else if(obj.value =='midstu'){
		$(".gra_spe").css("display", "none");
		$(".worker_sep").css("display", "none");
		$(".midstu").css("display", "table-row");

	}else if(obj.value =='nothing'){
		$(".gra_spe").css("display", "none");
		$(".worker_sep").css("display", "none");
		$(".midstu").css("display", "none");
	}

}
function commonChange(obj1, obj2) {
	$("#" + obj1).html("");
	$("#" + obj1).css("border", "");
	$("#" + obj1).css("background-color", "");
	$("#" + obj1).css("width", "");
	$("#" + obj1).css("padding", "");
	$("#" + obj2).css("width", "17px");
	$("#" + obj2).css("height", "13px");
}
function check(obj, obj1, obj2) {
	// window.alert("请value="请输入真实姓名,方便朋友查找";输入姓名!");
	switch (obj1) {
	case "spanVal1":
		if (obj.value == null || obj.value == "") {
			nameTip(obj, obj1, obj2, "请输入真实姓名!!")
		} else {
			commonChange(obj1, obj2);
		}
		break;
	case "spanVal2":
		

		if (obj.value == null || obj.value == "") {
			nameTip(obj, obj1, obj2, "请输入密码!!");
		} else {
			if (obj.value.length < 6) {
				nameTip(obj, obj1, obj2, "请输入至少六位字符的密码!!");
			} else {
				commonChange(obj1, obj2);
			}
		}
		break;
	case "spanVal3":

		if (obj.value == null || obj.value == "") {
			nameTip(obj, obj1, obj2, "请输入确认密码!!");
		}
		else {
			if (obj.value.length < 6) {
				nameTip(obj, obj1, obj2, "请输入至少六位字符的密码!!");
			} else if ($("#psd").val() != $("#psd2").val()) {
				nameTip(obj, obj1, obj2, "两次密码不一致!!");
			}
			else
			{
				commonChange(obj1, obj2);
			}
		}
		break;
	case "spanVal4":
		if (obj.value == null || obj.value == "") {
			nameTip(obj, obj1, obj2, "请输入邮箱!!");
		} else {
			if($("#email").val().indexOf("@")!=-1)
			{
				commonChange(obj1, obj2);
			}
			else
			{
				nameTip(obj, obj1, obj2, "请输入合法的邮箱!!");
			}
		}
		break;

	default:
		break;
	}
}
function nameTip(obj, obj1, obj2, obj3) {
	// window.alert(obj3);
	if (obj3 != null) {
		$("#" + obj1).html(obj3);
	} else {
		if (obj1 == "spanVal1") {
			$("#" + obj1).html("请输入真实姓名,方便朋友查找!!");
		} else if (obj1 == "spanVal2") {
			$("#" + obj1).html("请输入6-16位密码!!");
		} else if (obj1 == "spanVal3") {
			$("#" + obj1).html("请输入确认密码!!");
		} else if (obj1 == "spanVal4") {
			$("#" + obj1).html("请输入邮箱!!");
		}
	}
	$("#" + obj1).css("border", "1px solid #EBC135");
	$("#" + obj1).css("background-color", "#FFFCCB");
	$("#" + obj1).css("width", "250px");
	$("#" + obj1).css("padding", "3px");
	$("#" + obj2).css("width", "0");
	$("#" + obj2).css("height", "0");
	/*
	 * $("#spanVal1").css("border","1px solid #EBC135");
	 * $("#spanVal1").css("background-color","#FFFCCB");
	 * $("#spanVal1").css("width","250px"); $("#spanVal1").css("padding","3px");
	 * $("#ok1").css("width","0"); $("#ok1").css("height","0");
	 */
}
function hide(obj1) {
	// window.alert("关闭");
	$("#" + obj1).css("display", "none");
}
function show(obj1) {
	// window.alert("关闭");
	$("#" + obj1).css("display", "block");
}
function confirm(obj) {
	// window.alert(obj.innerHTML+obj2);

	var obj2 = "university1";
	$("#universityId").val(obj.id);
	$("#" + obj2).val(obj.innerHTML);
	hide('div_uni');
}
function checkRegisterForm()
{
	if($("#name").val()=="")
	{
		window.alert("姓名不能为空!");
		return false;
	}
	if($("#identity").val()==null||$("#identity").val()=="")
	{
		window.alert("请选择身份!");
		return false;
	}
	if($("#email").val()=="")
	{
		window.alert("邮箱不能为空!");
		return false;
	}
	else if($("#email").val().indexOf("@")==-1)
	{
		window.alert("邮箱不合法!");
		return false;
		
	}
	if($("#psd").val()=="")
	{
		window.alert("密码不能为空!");
		return false;
	}
	if($("#psd2").val()=="")
	{
		window.alert("确认密码不能为空!");
		return false;
	}
	 if ($("#psd").val().length<6)
	{
		window.alert("密码应不少于6位!");
		return false;
	}
	 if ($("#psd2").val().length<6)
	{
		window.alert("确认密码应不少于6位!");
		return false;
	}
	if($("#psd").val()!=$("#psd2").val())
	{
		window.alert("两次密码不一致!");
		return false;
	}
	if($("#identity").val()=="nothing")
	{
		return true;
	}
	else if($("#identity").val()=="worker")
	{
		//window.alert("worker!");
		return true;
	}
	else if($("#identity").val()=="graduate")
	{
		//window.alert("graduate!");
		//return false;
	}
	else if($("#identity").val()=="midstu")
	{
		window.alert("midstu!");
		return false;
	}
	
	
}


	



