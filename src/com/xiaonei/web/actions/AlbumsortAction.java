package com.xiaonei.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.xiaonei.domain.Albumsort;
import com.xiaonei.service.interfaces.AlbumsortServiceInter;
import com.xiaonei.web.forms.AlbumsortForm;

public class AlbumsortAction extends DispatchAction{
	private AlbumsortServiceInter albumsortService;
	
	public AlbumsortServiceInter getAlbumsortService() {
		return albumsortService;
	}

	public void setAlbumsortService(AlbumsortServiceInter albumsortService) {
		this.albumsortService = albumsortService;
	}

	public ActionForward addAlbum(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		AlbumsortForm albumsortForm=(AlbumsortForm)form;
		System.out.println("albumSortForm:"+albumsortForm);
		String sort=albumsortForm.getSort();
		
		System.out.println("sort:"+sort);
		Albumsort albumsort=new Albumsort();
		albumsort.setSort(sort);
		try
		{
			albumsortService.save(albumsort);
			request.setAttribute("message5", "创建成功");
			return mapping.findForward("message");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			request.setAttribute("message11", "创建失败");
			return mapping.findForward("message");
		}
		
	}
	public ActionForward goAddPhoto(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		AlbumsortForm albumsortForm=(AlbumsortForm)form;
		String sort=albumsortForm.getSort();
		Albumsort albumsort=(Albumsort) albumsortService.getObjectById(Albumsort.class, Integer.parseInt(sort));
		System.out.println("sort:"+sort);
        request.setAttribute("albumsort", albumsort);
		return mapping.findForward("addPhoto");
	}

}
