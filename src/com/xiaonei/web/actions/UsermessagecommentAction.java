package com.xiaonei.web.actions;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.mysql.cj.protocol.Message;
import com.xiaonei.domain.Usermessagecomment;
import com.xiaonei.domain.Users;
import com.xiaonei.service.imp.UsermessagecommentService;
import com.xiaonei.service.interfaces.MessageServiceInter;
import com.xiaonei.service.interfaces.UserServiceInter;
import com.xiaonei.service.interfaces.UsermessagecommentServiceInter;
import com.xiaonei.web.forms.UsermessagecommentForm;

public class UsermessagecommentAction extends DispatchAction {
	private MessageServiceInter messageService;
	private UserServiceInter userService;
	private UsermessagecommentServiceInter usermessagecommentService;
	
	

public MessageServiceInter getMessageService() {
		return messageService;
	}


	public void setMessageService(MessageServiceInter messageService) {
		this.messageService = messageService;
	}


	public UserServiceInter getUserService() {
		return userService;
	}


	public void setUserService(UserServiceInter userService) {
		this.userService = userService;
	}


public UsermessagecommentServiceInter getUsermessagecommentService() {
		return usermessagecommentService;
	}


	public void setUsermessagecommentService(UsermessagecommentServiceInter usermessagecommentService) {
		this.usermessagecommentService = usermessagecommentService;
	}


public ActionForward publishComment(ActionMapping mapping, ActionForm form, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
	Users user = (Users) request.getSession().getAttribute("user");
	if (user != null) {
		UsermessagecommentForm usermessageForm=(UsermessagecommentForm)form;
		int messageId=usermessageForm.getMessageId();
		System.out.println("messageId:"+messageId);
		int senderId=usermessageForm.getSenderId();
		System.out.println("senderId:"+senderId);
		int receiverId=usermessageForm.getReceiverId();
		System.out.println("receiverId:"+receiverId);
		String content=usermessageForm.getContent();
		System.out.println("content:"+content);
		Usermessagecomment usermessagecomment=new Usermessagecomment();
		usermessagecomment.setMessage((com.xiaonei.domain.Message)messageService.getObjectById(Message.class, messageId));
		
		usermessagecomment.setSender((Users)userService.getObjectById(Users.class, senderId));
		usermessagecomment.setReceiver((Users)userService.getObjectById(Users.class, receiverId));
		usermessagecomment.setContent(content);
		usermessagecomment.setPublishDate(new java.util.Date());
		try
		{
			usermessagecommentService.save(usermessagecomment);
			request.setAttribute("message10", "回复成功!!");
			return mapping.findForward("message");
			
		}catch(Exception e)
		{
			request.setAttribute("message10", "回复失败!!");
			e.printStackTrace();
			
			return mapping.findForward("message");
			
		}
		
		

	}

	request.setAttribute("message2", "您的登录已失效!!");
	return mapping.findForward("message");
}
}
