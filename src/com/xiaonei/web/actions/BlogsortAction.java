package com.xiaonei.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.xiaonei.domain.Blogsort;
import com.xiaonei.service.interfaces.BlogsortServiceInter;
import com.xiaonei.web.forms.BlogsortForm;

public class BlogsortAction extends DispatchAction {
	private BlogsortServiceInter blogsortService;
	
	public BlogsortServiceInter getBlogsortService() {
		return blogsortService;
	}

	public void setBlogsortService(BlogsortServiceInter blogsortService) {
		this.blogsortService = blogsortService;
	}

	public ActionForward addBlogSort(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BlogsortForm blogsortForm=(BlogsortForm)form;
		String sort=blogsortForm.getSort();
		System.out.println(sort);
		
		Blogsort blogsort=new Blogsort();
		blogsort.setSort(sort);
		try
		{
			blogsortService.save(blogsort);
			request.setAttribute("message7", "添加成功!!");
			return mapping.findForward("message");
		}
		catch(Exception e)
		{
			request.setAttribute("message7", "添加失败!!");
			return mapping.findForward("message");
		}
		
		
		
	}

}
