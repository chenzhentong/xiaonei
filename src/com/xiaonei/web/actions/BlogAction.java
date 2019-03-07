package com.xiaonei.web.actions;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.xiaonei.domain.Blog;
import com.xiaonei.domain.Blogsort;
import com.xiaonei.domain.Users;
import com.xiaonei.service.interfaces.BlogServiceInter;
import com.xiaonei.service.interfaces.BlogsortServiceInter;
import com.xiaonei.service.interfaces.UserServiceInter;
import com.xiaonei.web.forms.BlogForm;
import com.xiaonei.web.forms.BlogsortForm;

public class BlogAction extends DispatchAction {
	private BlogServiceInter blogService;
	private BlogsortServiceInter blogsortService;
	private UserServiceInter userService;

	public BlogServiceInter getBlogService() {
		return blogService;
	}

	public void setBlogService(BlogServiceInter blogService) {
		this.blogService = blogService;
	}

	public BlogsortServiceInter getBlogsortService() {
		return blogsortService;
	}

	public void setBlogsortService(BlogsortServiceInter blogsortService) {
		this.blogsortService = blogsortService;
	}

	public UserServiceInter getUserService() {
		return userService;
	}

	public void setUserService(UserServiceInter userService) {
		this.userService = userService;
	}

	public ActionForward goPublishBlog(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Blogsort> blogsortList = blogsortService.executeQuery("from Blogsort", null);
		request.setAttribute("blogsortList", blogsortList);
		return mapping.findForward("publishBlog");
	}

	public ActionForward publishBlog(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {

			BlogForm blogForm = (BlogForm) form;
			String blogsort = blogForm.getBlogsort();
			System.out.println("blogsort:" + blogsort);
			String content = blogForm.getContent();
			System.out.println("content:" + content);
			String title = blogForm.getTitle();
			System.out.println("title:" + title);
			Users publisher = (Users) userService.getObjectById(Users.class, user.getId());
			System.out.println("user:" + user.getId());
			Blogsort blogsort1 = new Blogsort();

			blogsort1 = (Blogsort) blogService.getObjectById(Blogsort.class, Integer.parseInt(blogsort));
			System.out.println("blogsort1:" + blogsort1);

			Blog blog = new Blog();

			blog.setPublishDate(new java.util.Date());
			blog.setContent(content);
			blog.setPublisher(publisher);
			blog.setTitle(title);
			blog.setBlogsort(blogsort1);
			

			blogService.save(blog);
			System.out.println("发表成功");
			request.setAttribute("message8", "发表成功!!");
			return mapping.findForward("message");

		}
		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");

	}

	public ActionForward goAddBlogSort(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return mapping.findForward("addBlogSort");
	}
	public ActionForward goManageBlog(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {
			Object []parameters= {user.getId()};
			List<Blog> blogList=blogService.executeQuery("from Blog where publisher.id=? ", parameters);
			request.setAttribute("blogList", blogList);
			return mapping.findForward("manageBlog");


		}
		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");
		
		
	}
	public ActionForward deleteBlog(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
	    
	    int id=Integer.parseInt(request.getParameter("id"));
	    System.out.println("id:"+id);
	    try
	    {
	    	Object []parameters= {id};
	    	blogService.executeUpdate("delete from Blog where id=?", parameters);
	    	request.setAttribute("message9", "删除成功!!");
	    	return mapping.findForward("message");
	    	
	    }
	    catch(Exception e)
	    {
	    	request.setAttribute("message9", "删除失败!!");
	    	e.printStackTrace();
	    	
	    	return mapping.findForward("message");
	    }
	    
		
	}


}
