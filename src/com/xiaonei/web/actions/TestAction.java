package com.xiaonei.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.xiaonei.domain.Country;
import com.xiaonei.service.TestService;

public class TestAction extends Action {
	private TestService testService;
	
	public TestService getTestService() {
		return testService;
	}

	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//System.out.println("µ÷");
		List<Country> list=testService.showAllCountry();
		request.setAttribute("list", list);
		return mapping.findForward("showAllCountry");
	}

}
