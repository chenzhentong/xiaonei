package com.xiaonei.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.xiaonei.domain.City;
import com.xiaonei.domain.Country;
import com.xiaonei.domain.Province;
import com.xiaonei.domain.University;
import com.xiaonei.domain.UserUniversity;
import com.xiaonei.domain.Users;
import com.xiaonei.service.interfaces.CityServiceInter;
import com.xiaonei.service.interfaces.CountryServiceInter;
import com.xiaonei.service.interfaces.ProvinceServiceInter;
import com.xiaonei.service.interfaces.UniversityServiceInter;
import com.xiaonei.service.interfaces.UserServiceInter;
import com.xiaonei.service.interfaces.UserUniversityServiceInter;
import com.xiaonei.web.forms.UserForm;

public class RegisterAction extends DispatchAction {
	private CountryServiceInter countryService;
	private ProvinceServiceInter provinceService;
	private CityServiceInter cityService;
	private UniversityServiceInter universityService;
	private UserUniversityServiceInter userUniversityService;
	private UserServiceInter userService;
	public CountryServiceInter getCountryService() {
		return countryService;
	}

	public void setCountryService(CountryServiceInter countryService) {
		this.countryService = countryService;
	}

	public ProvinceServiceInter getProvinceService() {
		return provinceService;
	}

	public void setProvinceService(ProvinceServiceInter provinceService) {
		this.provinceService = provinceService;
	}

	public UniversityServiceInter getUniversityService() {
		return universityService;
	}

	public void setUniversityService(UniversityServiceInter universityService) {
		this.universityService = universityService;
	}

	public UserUniversityServiceInter getUserUniversityService() {
		return userUniversityService;
	}

	public void setUserUniversityService(UserUniversityServiceInter userUniversityService) {
		this.userUniversityService = userUniversityService;
	}

	public UserServiceInter getUserService() {
		return userService;
	}

	public void setUserService(UserServiceInter userService) {
		this.userService = userService;
	}

	public CityServiceInter getCityService() {
		return cityService;
	}

	public void setCityService(CityServiceInter cityService) {
		this.cityService = cityService;
	}

	public ActionForward goToRegister(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// System.out.println("去注册");
		String hql = "from Country";
		List<Country> countryList = countryService.executeQuery(hql, null);

		hql = "from Province as province where province.country.id=1";
		List<Province> provinceList = provinceService.executeQuery(hql, null);

		hql = "from University as university where university.province.id=1";
		List<University> universityList = universityService.executeQuery(hql, null);
		hql = "from City as city where city.pro.id=1";
		System.out.println("cityService：" + cityService);
		List<City> cityList = cityService.executeQuery(hql, null);

		request.setAttribute("countryList", countryList);
		request.setAttribute("provinceList", provinceList);
		request.setAttribute("cityList", cityList);
		request.setAttribute("universityList", universityList);
		return mapping.findForward("goToRegister");
	}

	public ActionForward register(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;
		String email = userForm.getEmail();
		String pwd = userForm.getPwd();
		String identity = userForm.getIdentity();
		String name = userForm.getName();
		String sex = userForm.getSex();
		Users user = new Users();

		user.setEmail(email);
		user.setLogindate(new java.util.Date());
		user.setPwd(pwd);
		user.setRegisterDate(new java.util.Date());
		user.setName(name);
		user.setSex(sex);

		if (identity.equals("worker")) {
			System.out.println("worker");
			
				City homeCity = (City) cityService.getObjectById(City.class, Integer.parseInt(userForm.getHomeCity()));
				Province homePro = (Province) provinceService.getObjectById(Province.class,
						Integer.parseInt(userForm.getHomePro()));
				user.setHomePro(homePro);
				user.setHomeCity(homeCity);

				System.out.println("finish");
				userService.save(user);

				return mapping.findForward("goHome");

			

		} else if (identity.equals("graduate")) {
			University university = new University();
			// university
			System.out.println("graduate");
			String universityId = userForm.getUniversityId();
			String userType = userForm.getUsersType();
			System.out.println(universityId);
			System.out.println(userType);
			if ((universityId != null && !universityId.equals("")) && (userType != null && !userType.equals(""))) {
				university = (University) universityService.getObjectById(University.class,
						Integer.parseInt(universityId));
				UserUniversity userUniversity = new UserUniversity();
				userUniversity.setUsers(user);
				userUniversity.setUniversity(university);
				userUniversity.setUserType(userType);
				System.out.println("finish");
				userService.save(user);
				userUniversityService.save(userUniversity);
				return mapping.findForward("goHome");

			} else {
				request.setAttribute("message", "请输入完整的信息");
				return mapping.findForward("message");
			}

		} else if (identity.equals("midstu")) {
			System.out.println("midstu");
		}
		if (identity.equals("nothing")) {
			System.out.println("nothing");

			userService.save(user);
			System.out.println("finish");
		}

		return mapping.findForward("goHome");
	}

}
