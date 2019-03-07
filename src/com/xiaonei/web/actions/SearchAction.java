package com.xiaonei.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.xiaonei.domain.Users;
import com.xiaonei.service.interfaces.UserServiceInter;
import com.xiaonei.web.forms.UserForm;

public class SearchAction extends DispatchAction {
	private UserServiceInter userService;
	
	public UserServiceInter getUserService() {
		return userService;
	}
	public void setUserService(UserServiceInter userService) {
		this.userService = userService;
	}
	public ActionForward goSearchFriends(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return mapping.findForward("searchFriends");
	}
	public ActionForward searchAllFriends(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm=(UserForm)form;
		System.out.println(userForm);
		String name=userForm.getName();
		int pageNow=1;
		int pageSize=3;
		String hql="from Users as u where u.name like '%"+name+"%' ";
		int pageCount=userService.getPageCount(hql, pageSize);
		int rowCount=userService.getRowCount(hql, pageSize);
		String strPageNow=request.getParameter("pageNow");
		if(strPageNow!=null)
		{
			pageNow=Integer.parseInt(strPageNow);
		}
		//String name="Αυ";
	
	   // 
		List<Users> list=userService.executeQueryByPage(hql,null, pageNow, pageSize);
		/*for(Users u:list)
		{
			System.out.println(u.getName());
		}*/
		request.setAttribute("list", list);
		request.setAttribute("pageNow", pageNow);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("rowCount", rowCount);
		
		
		return mapping.findForward("friendsSearchResult");
	}
}
