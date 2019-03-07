package com.xiaonei.util;

import java.util.UUID;

public class RenameImagesTool {
	
	public  static String getNewName(String name)
	{
		String uuid=UUID.randomUUID().toString();
		//获取.的位置
		int beginIndex=name.lastIndexOf(".");
		//求文件后缀名
		String postfix=name.substring(beginIndex, name.length());
		
		return uuid+postfix;
		
	}
    public static void main(String []args)
    {
       System.out.println(getNewName("11.jpg")) ;
    }
}
