package com.xiaonei.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts.upload.FormFile;

public class UploadPhotoTool {
	public static void  uploadFile(FormFile photo,String allPath)
	{
		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = photo.getInputStream();
			os = new FileOutputStream(allPath);
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = is.read(buffer)) > 0) {
				os.write(buffer, 0, len);

			}
			System.out.println("Êä³ö³É¹¦");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
