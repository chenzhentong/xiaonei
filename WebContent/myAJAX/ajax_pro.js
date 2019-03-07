

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
function setCouPro(o)
{
	createXMLHttpRequest();
	if(xmlrequest)
	{
		//准备发送请求
		//获取省和国家的id
		var req="/xiaoneinew/ChangeInfo?flag=pro&countryId="+o.id;
	    //window.alert(req);
		xmlrequest.open("get",req,true);
		//指定处理结果的函数
		xmlrequest.onreadystatechange = getCouPro;
		//发送请求
		xmlrequest.send();
	}
}
function getCouPro()
{
	//完成
	if(xmlrequest.readyState==4)
	{
		
		//成功
		if(xmlrequest.status==200)
		{
			//获取unis,替换原来位置内容
			var pro=xmlrequest.responseXML.getElementsByTagName("pro");
			console.log(pro);
			var con="";
			for(var i=1;i<=pro.length;i++)
			{
				if(i==1)
				{
					var unis=xmlrequest.responseXML.getElementsByTagName("unis");
					var con2="<table><tr>";
					for(var i=1;i<=unis.length;i++)
					{
						con2+="<td><li>";
						con2+=" <a href='javascript:void(0);' onclick='confirm(this)' id='"+unis[i - 1].childNodes[0].childNodes[0].data+"'>"+unis[i - 1].childNodes[1].childNodes[0].data+"</a>&nbsp;&nbsp;";
						if(i%3==0)
						{
							con2+="</tr><tr>";
						}
						con2+="</li></td>";
					}
					con2+="</table></tr>";
					
					
					document.getElementById("university_div").innerHTML = con2;
				}
			

			
				con+=" <a href='javascript:void(0);' onclick='setProUnis(this)'  id="+pro[i - 1].childNodes[0].childNodes[0].data+" name="+pro[i - 1].childNodes[2].childNodes[0].data+">"+pro[i - 1].childNodes[1].childNodes[0].data+"</a>&nbsp;&nbsp;";
				
			}
		//	console.log(con);
			document.getElementById("province_div").innerHTML = con;
			if(pro.length==0)
			{
				document.getElementById("university_div").innerHTML = "信息待完善";
			}
			
			
			/*var unis=xmlrequest.responseXML.getElementsByTagName("unis");
			var con2="<table><tr>";
			for(var i=1;i<=unis.length;i++)
			{
				con2+="<td><li>";
				con2+=" <a href='javascript:void(0);' onclick='confirm(this)'>"+unis[i - 1].childNodes[1].childNodes[0].data+"</a>&nbsp;&nbsp;";
				if(i%3==0)
				{
					con2+="</tr><tr>";
				}
				con2+="</li></td>";
			}
			con2+="</table></tr>";
			
			
			document.getElementById("university_div").innerHTML = con2;*/
		
		}
	}
}