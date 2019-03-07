package com.xiaonei.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.xiaonei.domain.Friend;
import com.xiaonei.domain.Specialfriend;
import com.xiaonei.domain.Users;
import com.xiaonei.service.interfaces.FriendServiceInter;
import com.xiaonei.service.interfaces.SpecialfriendServiceInter;
import com.xiaonei.service.interfaces.UserServiceInter;
import com.xiaonei.web.forms.FriendForm;

public class FriendAction extends DispatchAction {
	private FriendServiceInter friendService;
	private UserServiceInter userService;
	private SpecialfriendServiceInter specialfriendService;

	public FriendServiceInter getFriendService() {
		return friendService;
	}

	public void setFriendService(FriendServiceInter friendService) {
		this.friendService = friendService;
	}

	public UserServiceInter getUserService() {
		return userService;
	}

	public void setUserService(UserServiceInter userService) {
		this.userService = userService;
	}

	public SpecialfriendServiceInter getSpecialfriendService() {
		return specialfriendService;
	}

	public void setSpecialfriendService(SpecialfriendServiceInter specialfriendService) {
		this.specialfriendService = specialfriendService;
	}

	public ActionForward myFriends(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {
			int pageNow = 1;
			int pageSize = 3;
			String strPageNow = request.getParameter("pageNow");
			if (strPageNow != null) {
				pageNow = Integer.parseInt(strPageNow);
			}
			String hql = "from Friend as friend where friend.user1.id=" + user.getId() + " or friend.user2.id="
					+ user.getId();
			int pageCount = friendService.getPageCount(hql, pageSize);

			Object[] parameters = { user.getId(), user.getId() };
			List<Friend> friendList = friendService.executeQueryByPage(hql, null, pageNow, pageSize);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNow", pageNow);
			request.setAttribute("friendList", friendList);
			return mapping.findForward("myFriends");
		}
		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");

	}

	public ActionForward onlineFriends(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {
			int pageNow = 1;
			int pageSize = 3;
			String strPageNow = request.getParameter("pageNow");
			if (strPageNow != null) {
				pageNow = Integer.parseInt(strPageNow);
			}

			String hql = "from Friend where (user1.id=" + user.getId() + " and user2.online=" + true + ")or (user2.id="
					+ user.getId() + " and user1.online=" + true + ")";
			int pageCount = friendService.getPageCount(hql, pageSize);

			List<Friend> friendList = friendService.executeQueryByPage(hql, null, pageNow, pageSize);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNow", pageNow);
			request.setAttribute("friendList", friendList);
			return mapping.findForward("onlineFriends");
		}
		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");

	}

	public ActionForward specialFriends(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {
			int pageNow = 1;
			int pageSize = 3;
			String strPageNow = request.getParameter("pageNow");
			if (strPageNow != null) {
				pageNow = Integer.parseInt(strPageNow);
			}

			String hql = "from Specialfriend  where user1.id=" + user.getId();
			int pageCount = friendService.getPageCount(hql, pageSize);

			List<Friend> friendList = friendService.executeQueryByPage(hql, null, pageNow, pageSize);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNow", pageNow);
			request.setAttribute("friendList", friendList);
			return mapping.findForward("specialFriends");
		}
		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");

	}

	public ActionForward possibleFriends(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return mapping.findForward("possibleFriends");
	}

	public ActionForward inviteFriends(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return mapping.findForward("inviteFriends");
	}

	public ActionForward addFriends(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {
			FriendForm friendForm = (FriendForm) form;
			int userId1 = user.getId();
			int userId2 = Integer.parseInt(request.getParameter("userId2"));
			System.out.println(userId2);
			Friend friend = new Friend();
			friend.setUser1((Users) userService.getObjectById(Users.class, userId1));
			friend.setUser2((Users) userService.getObjectById(Users.class, userId2));

			// 防止好友重复添加
			Object[] parameters = { userId1, userId2, userId2, userId1 };
			Friend friend1 = (Friend) friendService.uniqueQuery(
					"from Friend as friend where (friend.user1.id=? and friend.user2.id=?) or  (friend.user2.id=? and friend.user1.id=?)",
					parameters);
			if (friend1 == null) {
				try {

					friendService.save(friend);
					request.setAttribute("message13", "添加成功!!");
					return mapping.findForward("message");
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("message13", "添加失败!!");
					return mapping.findForward("message");
				}

			} else {
				request.setAttribute("message13", "您已经添加过好友，请勿重复添加!!");
				return mapping.findForward("message");
			}

		}
		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");
	}

	public ActionForward addSpecialfriend(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {
			int friendId = Integer.parseInt(request.getParameter("friendId"));
			Specialfriend specialfriend = new Specialfriend();
			specialfriend.setUser1((Users) userService.getObjectById(Users.class, user.getId()));
			specialfriend.setUser2((Users) userService.getObjectById(Users.class, friendId));
			try {
				specialfriendService.save(specialfriend);
				request.setAttribute("message13", "设置成功!!");
				return mapping.findForward("message");

			} catch (Exception e) {
				e.printStackTrace();

				request.setAttribute("message13", "设置失败!!");
				return mapping.findForward("message");
			}

		}
		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");
	}

	
}
