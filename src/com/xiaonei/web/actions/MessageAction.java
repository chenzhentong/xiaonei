package com.xiaonei.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.xiaonei.domain.Message;
import com.xiaonei.domain.Users;
import com.xiaonei.service.interfaces.MessageServiceInter;
import com.xiaonei.service.interfaces.UserServiceInter;
import com.xiaonei.web.forms.MessageForm;

public class MessageAction extends DispatchAction {
	private MessageServiceInter messageService;
	private UserServiceInter userService;

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

	public ActionForward publishMessage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Users user=(Users) request.getSession().getAttribute("user");
		if(user!=null)
		{
			String strId=request.getParameter("id");
			MessageForm messageForm=(MessageForm)form;
			String content=messageForm.getContent();
			System.out.println("content:"+content);
            Message message=new Message();
            message.setContent(content);  
            message.setHost((Users)userService.getObjectById(Users.class, Integer.parseInt(strId)));
            message.setUser((Users)userService.getObjectById(Users.class, user.getId()));
            message.setMessageDate(new java.util.Date());
            try
            {
            	messageService.save(message);
            	return mapping.findForward("goHomePage");
            }
            catch(Exception e)
            {
            	e.printStackTrace();
            	request.setAttribute("message10", "ÁôÑÔÊ§°Ü!!");
        		return mapping.findForward("message");
            	
            }
		}
		request.setAttribute("message2", "ÄúµÄµÇÂ¼ÒÑÊ§Ð§!!");
		return mapping.findForward("message");

	}
	
}
