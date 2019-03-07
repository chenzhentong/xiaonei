package com.xiaonei.web.actions;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import com.xiaonei.domain.Users;
import com.xiaonei.service.interfaces.CityServiceInter;
import com.xiaonei.service.interfaces.ProvinceServiceInter;
import com.xiaonei.service.interfaces.UserServiceInter;
import com.xiaonei.util.RenameImagesTool;
import com.xiaonei.util.UploadPhotoTool;
import com.xiaonei.web.forms.UserForm;

public class ModifyAction extends DispatchAction {
	private UserServiceInter userService;

	public UserServiceInter getUserService() {
		return userService;
	}

	public void setUserService(UserServiceInter userService) {
		this.userService = userService;
	}

	public ActionForward goModifyBaseInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {

			/*
			 * System.out.println(user.getHomePro().getName());
			 * System.out.println(user.getHomeCity().getName());
			 */
			request.setAttribute("user", user);
			return mapping.findForward("baseInfo");
		}
		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");

	}

	public ActionForward modifyBaseInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {

			UserForm userForm = (UserForm) form;
			int id = user.getId();
			String name = userForm.getName();
			System.out.println(name);
			String sex = userForm.getSex();
			System.out.println(sex);
			String homePro = userForm.getHomePro();
			System.out.println(homePro);
			String homeCity = userForm.getHomeCity();
			System.out.println(homeCity);
			String birthday = userForm.getBirthday();
			System.out.println(birthday);
			int index1 = birthday.lastIndexOf(".");
			String birthday1 = birthday.substring(0, index1);
			System.out.println(birthday1);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date date = new java.util.Date();
			try {
				date = sdf.parse(birthday);

				System.out.println(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Object[] parameters = { name, sex, date, id };
			int flag = userService.executeUpdate("update Users  set name=?,sex=?,birthday=? where id=?", parameters);
			if (flag == 1) {
				request.setAttribute("message6", "修改成功!!");
				return mapping.findForward("message");
			}
			request.setAttribute("message6", "修改失败!!");
			return mapping.findForward("message");
		}
		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");

	}

	public ActionForward goModifyContractInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {

			request.setAttribute("user", user);
			return mapping.findForward("contractInfo");
		}

		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");

	}

	public ActionForward modifyContractInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {
			UserForm userForm = (UserForm) form;
			int id = user.getId();
			String tel = userForm.getTel();
			String website = userForm.getWebsite();
			String email = userForm.getEmail();
			String mobile = userForm.getMobile();
			String oicq = userForm.getOicq();
			String msn = userForm.getMsn();
			Object[] parameters = { tel, website, email, mobile,oicq,msn,id };
			int flag = userService.executeUpdate("update Users  set tel=?,website=?,email=?,mobile=?,oicq=?,msn=? where id=?", parameters);
			if (flag == 1) {
				request.setAttribute("message6", "修改成功!!");
				return mapping.findForward("message");
			}
			request.setAttribute("message6", "修改失败!!");
			return mapping.findForward("message");
		}

		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");

	}

	public ActionForward goModifySelfInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {

			request.setAttribute("user", user);
			return mapping.findForward("selfInfo");
		}
		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");

	}
	public ActionForward modifySelfInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {

			UserForm userForm = (UserForm) form;
			int id = user.getId();
			String interset = userForm.getInterset();
			String music=userForm.getMusic();
			String game = userForm.getGame();
			String cartoon = userForm.getCartoon();
			String sport = userForm.getSport();
			String book = userForm.getBook();
			Object[] parameters = { interset, music, game, cartoon,sport,book,id };
			int flag = userService.executeUpdate("update Users  set interset=?,music=?,game=?,cartoon=?,sport=?,book=? where id=?", parameters);
			if (flag == 1) {
				request.setAttribute("message6", "修改成功!!");
				return mapping.findForward("message");
			}
			request.setAttribute("message6", "修改失败!!");
			return mapping.findForward("message");
		}
		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");

	}

	public ActionForward goModifySchoolInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {
			request.setAttribute("user", user);
			return mapping.findForward("schoolInfo");
		}
		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");

	}

	public ActionForward goModifyWorkInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {

			request.setAttribute("user", user);
			return mapping.findForward("workInfo");
		}

		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");
	}

	public ActionForward goUploadPhoto(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {
			request.setAttribute("user", user);
			return mapping.findForward("uploadPhoto");
		}
		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");

	}

	public ActionForward uploadPhoto(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {

			int id = user.getId();
			UserForm userForm = (UserForm) form;
			System.out.println(userForm);
			FormFile photo = userForm.getPhoto();
			String photoName1 = photo.getFileName();
			if (photoName1 == null || photoName1.equals("")) {
				request.setAttribute("message4", "请选择文件!!");
				return mapping.findForward("message");
			}
			System.out.println("newPhoto:" + photo);

			String photoName = photo.getFileName();
			int size = photo.getFileSize();
			System.out.println(photoName + " " + size + "B");
			if (size > 1024 * 1024) {
				request.setAttribute("message4", "修改失败,您上传文件大小不要超过1M!!");
				return mapping.findForward("message");
			}
			String newName = RenameImagesTool.getNewName(photoName);
			String path = "C:\\Users\\恒信科技\\workspace\\.metadata\\xiaoneinew\\WebContent\\images\\userhead2";
			String allPath = path + "\\" + newName;
			UploadPhotoTool.uploadFile(photo, allPath);
			Object[] parameters = { photoName, newName, id };
			int flag = userService.executeUpdate("update Users  set photo=?,photo2=? where id=?", parameters);
			if (flag == 1) {
				

				request.setAttribute("message3", "修改成功!!");
				return mapping.findForward("message");
			} else {
				request.setAttribute("message3", "修改失败!!");
				return mapping.findForward("message");
			}

		}
		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");
	}

	public ActionForward modifyAssign(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {
			UserForm userForm=(UserForm)form;
			String assh=userForm.getAssh();
			System.out.println("assh:"+assh);
			Object []parameters= {assh,user.getId()};
			int flag=userService.executeUpdate("update  Users set assh=?  where id=?", parameters);
			if (flag == 1) {
				ActionForward actionForward=new ActionForward();
				actionForward.setPath("/profile.do?flag=goHome");
				return actionForward;

				/*request.setAttribute("message3", "修改成功!!");
				return mapping.findForward("message");*/
			} else {
				request.setAttribute("message3", "修改失败!!");
				return mapping.findForward("message");
			}
		}
		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");
	}
}
