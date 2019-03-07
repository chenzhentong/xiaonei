

//响应abc函数
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
function setProUnis(o)
{
	createXMLHttpRequest();
	if(xmlrequest)
	{
		//准备发送请求
		//获取省和国家的id
		var req="/xiaoneinew/ChangeInfo?flag=uni&proId="+o.id+"&countryId="+o.name;
		//window.alert(req);
		xmlrequest.open("get",req,true);
		//指定处理结果的函数
		xmlrequest.onreadystatechange = getProUnis;
		//发送请求
		xmlrequest.send();
	}
}
function getProUnis()
{
	//完成
	if(xmlrequest.readyState==4)
	{
		//成功
		if(xmlrequest.status==200)
		{
			//获取unis,替换原来位置内容
			var unis=xmlrequest.responseXML.getElementsByTagName("unis");
			var con="<table><tr>";
			for(var i=1;i<=unis.length;i++)
			{
				con+="<td><li>";
				con+=" <a href='javascript:void(0);' onclick='confirm(this)' id='"+unis[i - 1].childNodes[0].childNodes[0].data+"'>"+unis[i - 1].childNodes[1].childNodes[0].data+"</a>&nbsp;&nbsp;";
				if(i%3==0)
				{
					con+="</tr><tr>";
				}
				con+="</li></td>";
			}
			con+="</table></tr>";
			
			
			document.getElementById("university_div").innerHTML = con;
		}
	}
}
