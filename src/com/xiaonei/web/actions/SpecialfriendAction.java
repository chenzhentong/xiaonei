package com.xiaonei.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.xiaonei.domain.Specialfriend;
import com.xiaonei.domain.Users;
import com.xiaonei.service.imp.UserService;
import com.xiaonei.service.interfaces.SpecialfriendServiceInter;
import com.xiaonei.service.interfaces.UserServiceInter;
import com.xiaonei.web.forms.SpecialfriendForm;

public class SpecialfriendAction extends DispatchAction {
	private SpecialfriendServiceInter specialfriendService;
	private UserServiceInter userService;
	
	
	public SpecialfriendServiceInter getSpecialfriendService() {
		return specialfriendService;
	}


	public void setSpecialfriendService(SpecialfriendServiceInter specialfriendService) {
		this.specialfriendService = specialfriendService;
	}


	public UserServiceInter getUserService() {
		return userService;
	}


	public void setUserService(UserServiceInter userService) {
		this.userService = userService;
	}


	public ActionForward describeFriend(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {
			SpecialfriendForm specialfriendForm=(SpecialfriendForm)form;
			String description=specialfriendForm.getDescription();
			int userId2=specialfriendForm.getUserId2();
			Specialfriend specialfriend=new Specialfriend();
			specialfriend.setDescription(description);
			Object []parameters= {description,user.getId(),userId2};
			System.out.println("description:"+description);
			System.out.println("duser.getId():"+user.getId());
			System.out.println("userId2:"+userId2);
			int flag=specialfriendService.executeUpdate("update Specialfriend set description =? where user1.id=? and user2.id=?", parameters);
            if(flag==1)
            {
            	request.setAttribute("message14", "更新成功!!");
        		return mapping.findForward("message");
            }
            request.setAttribute("message14", "更新失败!!");
    		return mapping.findForward("message");
		}
		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");
	}

}
