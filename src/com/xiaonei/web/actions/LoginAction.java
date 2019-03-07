package com.xiaonei.web.actions;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.xiaonei.domain.Users;
import com.xiaonei.service.interfaces.UserServiceInter;
import com.xiaonei.web.forms.UserForm;

public class LoginAction extends DispatchAction {
	private UserServiceInter userService;
	public UserServiceInter getUserService() {
		return userService;
	}
	public void setUserService(UserServiceInter userService) {
		this.userService = userService;
	}
	public ActionForward goLogin(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Users user=(Users) request.getSession().getAttribute("user");
		if(user!=null)
		{
			System.out.println("session自动登录");
			request.setAttribute("user", user);
			
			//重定向到主页
			ActionForward actionForward=new ActionForward();
			actionForward.setPath("/profile.do?flag=goHome");
			return actionForward;
		}
		
		else
		{
			Cookie []cookies=request.getCookies();
			System.out.println(cookies);
			if(cookies!=null)
			{
				for(Cookie cookie:cookies)
				{
					System.out.println(cookie.getValue());
					if(cookie.getName().equals("user")&&!cookie.getValue().equals("-1"))
					{
						System.out.println("cookie自动登录"+cookie.getValue());
						Object []parameters= {Integer.parseInt(cookie.getValue())};
						user=(Users) userService.uniqueQuery("from Users where id=?", parameters);
						user.getHomeCity().getName();
						user.getHomePro().getName();
						HttpSession hs=request.getSession();
						hs.setAttribute("user", user);
						hs.setMaxInactiveInterval(60*60);
						request.setAttribute("user", user);
						return mapping.findForward("goHome");
					}
				}
				
			}
			
			
			request.setAttribute("message2", "您的登录已失效!!");
			return mapping.findForward("message");
		}
		
	}
	public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		UserForm userForm=(UserForm)form;
		String email=userForm.getEmail();
		String pwd=userForm.getPwd();
		String [] parameters= {email,pwd};
		
		Users user=(Users) userService.uniqueQuery("from Users where email=? and pwd=?", parameters);
		if(user!=null)
		{
			if(user.getHomeCity()!=null)
			{
				user.getHomeCity().getName();
			}
			if(user.getHomePro()!=null)
			{
				user.getHomePro().getName();
			}
		   
			//user.getHomePro().getName();
			Object []parameters1= {true,user.getId()};
			userService.executeUpdate("update Users set online=? where id=?", parameters1);
			String keep=userForm.getKeep();
			/*System.out.println("keep:"+keep);*/
			if(keep.equals("yes"))
			{
				Cookie cookie=new Cookie("user",user.getId()+"");
				cookie.setMaxAge(60*60);
				response.addCookie(cookie);
				System.out.println("设置cookie");
			}
			
		    
			ActionForward actionForward=new ActionForward();
			HttpSession hs=request.getSession();
			hs.setAttribute("user", user);
			hs.setMaxInactiveInterval(60*60);
			actionForward.setPath("/login.do?flag=goLogin");
			
			return actionForward;
		}
		request.setAttribute("message2", "用户名或密码错误!!");
		return mapping.findForward("message");
	}
	
	public ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Users user=(Users) request.getSession().getAttribute("user");
		if(user!=null)
		{
			Object []parameters1= {false,user.getId()};
			userService.executeUpdate("update Users set online=? where id=?", parameters1);
			request.getSession().removeAttribute("user");
		}
		Cookie []cookies=request.getCookies();
		for(Cookie cookie:cookies)
		{
			if(cookie.getName().equals("user"))
			{
			    cookie.setMaxAge(0);
				cookie.setValue("-1");
				response.addCookie(cookie);
				System.out.println(cookie);
				System.out.println(cookie.getName());
				System.out.println(cookie.getValue());
				System.out.println("移除cookie");
			}
			
		}
		
		return mapping.findForward("logout");
	}
}
