package com.xiaonei.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.el.core.OutTag;

import com.mysql.cj.util.Base64Decoder;




@WebServlet("/verifyCode2")
public class VerifyCode2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyCode2() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应类型
		response.setContentType("image/JPEG");
		//定义图片宽高
		int width=80;
		int height=50;
		//创建一个缓冲区图片
		BufferedImage img=new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		//使用缓冲区图片创建，图像对象用于绘制验证码
		Graphics g=img.getGraphics();
		//设置画笔颜色，后续画矩阵，相当于设置图形背景颜色为黄色
		g.setColor(new Color(255,255,0));
		//设置图片填充位置
		g.fillRect(0, 0, width, height);
		//设置字体样式
		g.setFont(new Font("微软雅黑",Font.ITALIC,18));
		String srand="";
		Random random=new Random();
		for(int i=0;i<4;i++)
		{
			int y=10+random.nextInt(40);
			String rand=String.valueOf(random.nextInt(10));
			srand+=rand;
			System.out.println(rand);
			//随机变换颜色
			g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
			//将随机数画入图形
			g.drawString(rand, 5+i*width/4, y);
		}
		System.out.println("1:"+srand);
		produceLine(g,random,width,height);
		try
		{
			//释放图形资源
			g.dispose();
			
			 //保存到session中
	        HttpSession session = request.getSession();
	        session.setAttribute("verifyCode",srand);
	       
	        
	        System.out.println("verifyCode:"+session.getAttribute("verifyCode"));
			ServletOutputStream sos = response.getOutputStream();
	        ImageIO.write(img,"jpg",sos);
	       
	        
	        //禁止图像缓存。
	        response.setHeader("Pragma", "no-cache");
	        response.setHeader("Cache-Control", "no-cache");
	        response.setDateHeader("Expires", 0);
	       
	        //关闭输入流
	        sos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//随机生成30条线条
	protected void  produceLine(Graphics g,Random random,int width,int height)
	{
		int x=random.nextInt(width);
		int y=random.nextInt(height);
		int x1=random.nextInt(10);
		int y1=random.nextInt(10);
		g.drawLine(x, y, x1, y1);
	}
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
