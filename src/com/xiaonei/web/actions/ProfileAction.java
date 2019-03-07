package com.xiaonei.web.actions;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.xiaonei.domain.Album;
import com.xiaonei.domain.Blog;
import com.xiaonei.domain.Friend;
import com.xiaonei.domain.Message;
import com.xiaonei.domain.Usermessagecomment;
import com.xiaonei.domain.Users;
import com.xiaonei.domain.Uservisited;
import com.xiaonei.service.interfaces.AlbumServiceInter;
import com.xiaonei.service.interfaces.BlogServiceInter;
import com.xiaonei.service.interfaces.BlogsortServiceInter;
import com.xiaonei.service.interfaces.FriendServiceInter;
import com.xiaonei.service.interfaces.MessageServiceInter;
import com.xiaonei.service.interfaces.SpecialfriendServiceInter;
import com.xiaonei.service.interfaces.UserServiceInter;
import com.xiaonei.service.interfaces.UsermessagecommentServiceInter;
import com.xiaonei.service.interfaces.UservisitedServiceInter;

public class ProfileAction extends DispatchAction {
	private BlogServiceInter blogService;
	private BlogsortServiceInter blogsortService;
	private UserServiceInter userService;
	private MessageServiceInter messageService;
	private UsermessagecommentServiceInter usermessagecommentService;
	private AlbumServiceInter albumService;
	private UservisitedServiceInter uservisitedService;
	private FriendServiceInter friendService;
    private SpecialfriendServiceInter specialfriendService;
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

	public MessageServiceInter getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageServiceInter messageService) {
		this.messageService = messageService;
	}

	public void setUserService(UserServiceInter userService) {
		this.userService = userService;
	}

	public AlbumServiceInter getAlbumService() {
		return albumService;
	}

	public void setAlbumService(AlbumServiceInter albumService) {
		this.albumService = albumService;
	}

	public UservisitedServiceInter getUservisitedService() {
		return uservisitedService;
	}

	public void setUservisitedService(UservisitedServiceInter uservisitedService) {
		this.uservisitedService = uservisitedService;
	}

	public FriendServiceInter getFriendService() {
		return friendService;
	}

	public void setFriendService(FriendServiceInter friendService) {
		this.friendService = friendService;
	}

	public SpecialfriendServiceInter getSpecialfriendService() {
		return specialfriendService;
	}

	public void setSpecialfriendService(SpecialfriendServiceInter specialfriendService) {
		this.specialfriendService = specialfriendService;
	}

	

	public UsermessagecommentServiceInter getUsermessagecommentService() {
		return usermessagecommentService;
	}

	public void setUsermessagecommentService(UsermessagecommentServiceInter usermessagecommentService) {
		this.usermessagecommentService = usermessagecommentService;
	}

	public ActionForward goHomePage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {

			String strId = request.getParameter("id");
			System.out.println("被访问者:" + strId);
			System.out.println("访问者:" + user.getId());
			if (strId != null) {
				int id = Integer.parseInt(strId);
				Object[] parameters = { id };

				List<Blog> blogList = blogService.executeQuery("from Blog where publisher.id=?", parameters);
				Users user1 = (Users) userService.uniqueQuery("from Users where id=" + id, null);

				List<Message> messageList = messageService
						.executeQuery("from Message as message where message.host.id=?", parameters);

				List<Album> albumList = albumService.executeQueryByPage("from Album  where publisher.id=" + id, null, 1,
						3);
				List<Album> albumList1 = albumService.executeQuery("from Album  where publisher.id=" + id, null);
				List<Uservisited> uservisitedList = uservisitedService
						.executeQueryByPage("from Uservisited where interviewee.id=" + user.getId(), null, 1, 3);
				List<Uservisited> uservisitedList1 = uservisitedService
						.executeQuery("from Uservisited where interviewee.id=" + user.getId(), null);
			
				List<Friend> friendList = friendService.executeQueryByPage("from Friend  where user1.id="+id+"or user2.id="+id, null, 1, 2);
				List<Friend> friendList1 = friendService.executeQuery("from Friend  where user1.id="+id+"or user2.id="+id, null);
				
				List<Friend> specialfriendList = friendService.executeQueryByPage("from Specialfriend  where user1.id="+id, null, 1, 2);
				List<Friend> specialfriendList1 = friendService.executeQuery("from Specialfriend  where user1.id="+id, null);
				
				
				Uservisited uservisited = new Uservisited();
				uservisited.setVisitor((Users) userService.getObjectById(Users.class, user.getId()));
				uservisited.setInterviewee((Users) userService.getObjectById(Users.class, id));
				uservisited.setVisitedDate(new java.util.Date());
				try {
					uservisitedService.save(uservisited);
					System.out.println("访问已保存");

				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("message2", "404!!");
					return mapping.findForward("message");

				}
				System.out.println("访问次数:" + uservisitedList.size());
				request.setAttribute("friendList", friendList);
				request.setAttribute("friendList1", friendList1);
				request.setAttribute("specialfriendList", specialfriendList);
				request.setAttribute("specialfriendList1", specialfriendList1);
				request.setAttribute("uservisitedList", uservisitedList);
				request.setAttribute("uservisitedList1", uservisitedList1);
				request.setAttribute("user1", user1);
				request.setAttribute("albumList1", albumList1);
				request.setAttribute("albumList", albumList);
				request.setAttribute("messageList", messageList);
				request.setAttribute("blogList", blogList);

				return mapping.findForward("goHomePage");

			} else {

				Object[] parameters = { user.getId() };

				List<Blog> blogList = blogService.executeQuery("from Blog where publisher.id=?", parameters);

				List<Message> messageList = messageService
						.executeQuery("from Message as message where message.host.id=?", parameters);

				List<Album> albumList = albumService
						.executeQueryByPage("from Album  where publisher.id=" + user.getId(), null, 1, 3);
				List<Album> albumList1 = albumService.executeQuery("from Album  where publisher.id=" + user.getId(),
						null);
				List<Uservisited> uservisitedList = uservisitedService
						.executeQueryByPage("from Uservisited where interviewee.id=" + user.getId(), null, 1, 3);
				List<Uservisited> uservisitedList1 = uservisitedService
						.executeQuery("from Uservisited where interviewee.id=" + user.getId(), null);
				List<Friend> friendList = friendService.executeQueryByPage("from Friend  where user1.id="+user.getId()+"or user2.id="+user.getId(), null, 1, 3);
				List<Friend> friendList1 = friendService.executeQuery("from Friend  where user1.id="+user.getId()+"or user2.id="+user.getId(), null);
				
				List<Friend> specialfriendList = friendService.executeQueryByPage("from Specialfriend  where user1.id="+user.getId(), null, 1, 3);
				List<Friend> specialfriendList1 = friendService.executeQuery("from Specialfriend  where user1.id="+user.getId(), null);
			
				System.out.println("访问次数:" + uservisitedList.size());
				request.setAttribute("specialfriendList", specialfriendList);
				request.setAttribute("specialfriendList1", specialfriendList1);
				request.setAttribute("friendList", friendList);
		     	request.setAttribute("friendList1", friendList1);
		     	request.setAttribute("uservisitedList1", uservisitedList1);
				request.setAttribute("uservisitedList", uservisitedList);
				request.setAttribute("albumList1", albumList1);
				request.setAttribute("albumList", albumList);
				request.setAttribute("messageList", messageList);
				request.setAttribute("blogList", blogList);
				return mapping.findForward("goHomePage");
			}

		}

		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");

	}

	public ActionForward goHome(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {
			List<Uservisited> uservisitedList = uservisitedService.executeQuery("from Uservisited where interviewee.id=" + user.getId(), null);
			
			Object []parameters= {user.getId(),true,user.getId(),true};
			List<Friend> onlinefriendList=friendService.executeQuery("from Friend where (user1.id=? and user2.online=?)or (user2.id=? and user1.online=?)", parameters);
			
			List<Friend> allFriendList=friendService.executeQuery("from Friend where (user1.id="+user.getId()+" and user2.birthday!=null) or (user2.id="+user.getId()+" and user1.birthday!=null)", null);
			System.out.println("好友数量"+allFriendList.size());
			List<Message> messageList=messageService.executeQuery("from Message where host.id="+user.getId(), null);
		    List<Usermessagecomment> usermessagecommentList=usermessagecommentService.executeQuery("from Usermessagecomment where receiver.id="+user.getId(), null);
		    
			request.setAttribute("messageList", messageList);
			request.setAttribute("usermessagecommentList", usermessagecommentList);
			request.setAttribute("uservisitedList", uservisitedList);
			request.setAttribute("onlinefriendList", onlinefriendList);
			request.setAttribute("allFriendList", allFriendList);
			return mapping.findForward("goHome");
		}
		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");

	}

	public ActionForward goMyApplication(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {
			return mapping.findForward("goMyApplication");
		}
		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");

	}
}
