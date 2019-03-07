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
function setProCity(o)
{
	createXMLHttpRequest();
	if(xmlrequest)
	{
		//准备发送请求
		//获取省和国家的id
		var req="/xiaoneinew/ChangeInfo?flag=city&cityId="+o.id;
		//window.alert(req);
		xmlrequest.open("get",req,true);
		//指定处理结果的函数
		xmlrequest.onreadystatechange = getProCity;
		//发送请求
		xmlrequest.send();
	}
}
function getProCity()
{
	console.log(0);
	//完成
	if(xmlrequest.readyState==4)
	{
		//console.log(1);
		//成功
		if(xmlrequest.status==200)
		{
			//console.log(2);
			//获取city,替换原来位置内容
			var city=xmlrequest.responseXML.getElementsByTagName("city");
			var con="<select name='homeCity'>";
			for(var i=1;i<=city.length;i++)
			{
				con+="<option value='"+city[i - 1].childNodes[0].childNodes[0].data+"'>";
				con+=city[i - 1].childNodes[1].childNodes[0].data;
				con+="</option>";
			}
			con+="</select>";
			
			
			document.getElementById("homeCity").innerHTML = con;
			console.log(con);
		}
	}
}