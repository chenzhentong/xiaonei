package com.xiaonei.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.xiaonei.domain.Mail;
import com.xiaonei.domain.Users;
import com.xiaonei.service.interfaces.MailServiceInter;
import com.xiaonei.service.interfaces.UserServiceInter;
import com.xiaonei.web.forms.MailForm;

public class MailAction extends DispatchAction {
	private UserServiceInter userService;
	private MailServiceInter mailService;
	

	public UserServiceInter getUserService() {
		return userService;
	}


	public void setUserService(UserServiceInter userService) {
		this.userService = userService;
	}


	public MailServiceInter getMailService() {
		return mailService;
	}


	public void setMailService(MailServiceInter mailService) {
		this.mailService = mailService;
	}
	public ActionForward goSendMail(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {
			
			List<Users> userList=userService.executeQuery("from Users", null);
			request.setAttribute("userList", userList);
			return mapping.findForward("sendMail");

		}
		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");
	}


	public ActionForward sendMail(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {
			MailForm mailForm=(MailForm)form;
			String content=mailForm.getContent();
			int receiverId=mailForm.getReceiverId();
			Mail mail=new Mail();
			mail.setContent(content);
			mail.setSendDate(new java.util.Date());
			mail.setReceiver((Users) userService.getObjectById(Users.class, receiverId));
			mail.setSender((Users) userService.getObjectById(Users.class,user.getId()));
			try
			{
				mailService.save(mail);
				request.setAttribute("message3", "发送成功!!");
				return mapping.findForward("message");
				
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
				request.setAttribute("message3", "发送失败!!");
				return mapping.findForward("message");
			}
			
			

		}
		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");

	}
}
