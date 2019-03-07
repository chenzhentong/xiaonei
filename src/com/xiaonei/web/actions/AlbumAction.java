package com.xiaonei.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import com.xiaonei.domain.Album;
import com.xiaonei.domain.Albumsort;
import com.xiaonei.domain.Users;
import com.xiaonei.service.interfaces.AlbumServiceInter;
import com.xiaonei.service.interfaces.AlbumsortServiceInter;
import com.xiaonei.service.interfaces.UserServiceInter;
import com.xiaonei.util.RenameImagesTool;
import com.xiaonei.util.UploadPhotoTool;
import com.xiaonei.web.forms.AlbumForm;
import com.xiaonei.web.forms.AlbumsortForm;

public class AlbumAction extends DispatchAction {
	private AlbumsortServiceInter albumsortService;
	private AlbumServiceInter albumService;
	private UserServiceInter userService;

	public AlbumsortServiceInter getAlbumsortService() {
		return albumsortService;
	}

	public void setAlbumsortService(AlbumsortServiceInter albumsortService) {
		this.albumsortService = albumsortService;
	}

	public AlbumServiceInter getAlbumService() {
		return albumService;
	}

	public void setAlbumService(AlbumServiceInter albumService) {
		this.albumService = albumService;
	}

	public UserServiceInter getUserService() {
		return userService;
	}

	public void setUserService(UserServiceInter userService) {
		this.userService = userService;
	}

	public ActionForward goAddAlbum(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {
			List<Albumsort> albumsortList = albumsortService.executeQuery("from Albumsort", null);
			request.setAttribute("albumsortList", albumsortList);
			return mapping.findForward("goAddAlbum");
		}
		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");
	}

	public ActionForward addPhoto(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {
			AlbumForm albumForm = (AlbumForm) form;
			System.out.println("albumForm:" + albumForm);
			String sort = albumForm.getSort();
			System.out.println("sort:" + sort);
			String title = albumForm.getTitle();
			System.out.println("title:" + title);
			FormFile photo = albumForm.getPhoto();
			System.out.println("photo:" + photo);
			String photoName = photo.getFileName();

			if (photo != null) {

				String newPhotoName = RenameImagesTool.getNewName(photoName);
				String allPath = "C:\\Users\\恒信科技\\workspace\\.metadata\\xiaoneinew\\WebContent\\images\\photos" + "\\"
						+ newPhotoName;

				UploadPhotoTool.uploadFile(photo, allPath);
				Album album = new Album();
				album.setPhoto(photoName);
				album.setPhoto2(newPhotoName);
				album.setPublihDate(new java.util.Date());
				Albumsort albumsort = (Albumsort) albumsortService.getObjectById(Albumsort.class,
						Integer.parseInt(sort));
				album.setSort(albumsort);
				album.setPublisher(user);
				album.setTitle(title);
				try {
					albumService.save(album);
					request.setAttribute("message12", "上传成功!!");
					return mapping.findForward("message");
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("message5", "上传失败!!");
					return mapping.findForward("message");

				}

			}
		}
		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");

	}

	public ActionForward myPhoto(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Users user = (Users) request.getSession().getAttribute("user");
		
		if (user != null) {
			int pageNow=1;
			int pageSize=1;
			String strPageNow=request.getParameter("pageNow");
			if(strPageNow!=null)
			{
				pageNow=Integer.parseInt(strPageNow);
			}
			String hql="from Album as album where album.publisher.id="+user.getId();
			int pageCount=albumService.getPageCount(hql, pageSize);
		
		    List<Album> albumList=albumService.executeQueryByPage(hql, null, pageNow, pageSize);
		   
		    request.setAttribute("pageCount", pageCount);
		    request.setAttribute("pageNow", pageNow);
		    request.setAttribute("albumList", albumList);
		    return mapping.findForward("myPhoto");
		}
		
		
		request.setAttribute("message2", "您的登录已失效!!");
		return mapping.findForward("message");
	}

}
