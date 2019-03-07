package com.xiaonei.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xiaonei.domain.City;
import com.xiaonei.domain.Province;
import com.xiaonei.domain.University;
import com.xiaonei.service.interfaces.CityServiceInter;
import com.xiaonei.service.interfaces.ProvinceServiceInter;
import com.xiaonei.service.interfaces.UniversityServiceInter;

/**
 * Servlet implementation class ChangeInfo
 */
@WebServlet("/ChangeInfo")
public class ChangeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/xml;charset=utf-8");

		PrintWriter pw = response.getWriter();
		String flag = request.getParameter("flag");
		if (flag.equals("uni")) {
			int proId = Integer.parseInt(request.getParameter("proId"));
			int countryId = Integer.parseInt(request.getParameter("countryId"));
			System.out.println("省份编号" + proId);
			System.out.println("国家编号" + countryId);

			WebApplicationContext wcx = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
			UniversityServiceInter universityService = (UniversityServiceInter) wcx.getBean("universityService");
			Object[] parameters = { proId, countryId };
			List<University> uniList = universityService.executeQuery(
					"from University as university where university.province.id=? and university.country.id=? ",
					parameters);
			String res = "<allUniversities>";
			for (University u : uniList) {
				// System.out.println(u.getId()+" "+u.getName());
				res += "<unis><id>" + u.getId() + "</id>" + "<name><![CDATA[" + u.getName() + "]]></name></unis>";
			}
			res += "</allUniversities>";
			pw.print(res);
		} else if (flag.equals("pro")) {

			System.out.println("根据国家id获取省份,并显示第一个省份的第一个城市的大学");
			int countryId = Integer.parseInt(request.getParameter("countryId"));
			System.out.println(countryId);
			WebApplicationContext wcx = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
			ProvinceServiceInter provinceService = (ProvinceServiceInter) wcx.getBean("provinceService");
			Object[] parameters = { countryId };
			List<Province> provinceList = provinceService
					.executeQuery("from Province as province where  province.country.id=?", parameters);
			String res = "<allProvinces>";

			int i = 0;
			String res2 = "";
			UniversityServiceInter universityService = (UniversityServiceInter) wcx.getBean("universityService");
			for (Province pro : provinceList) {
				//查询第一个国家的所有大学
				if (i == 0) {
					System.out.println("省份id" + pro.getId());
					System.out.println("国家id" + pro.getCountry().getId());

					Object[] parameters2 = { pro.getId(), pro.getCountry().getId() };
					List<University> uniList = universityService.executeQuery(
							"from University as university where university.province.id=? and university.country.id=?",
							parameters2);
					
					for (University u : uniList) {
						System.out.println(u.getId() + " " + u.getName());
						res += "<pro><unis><id>" + u.getId() + "</id>" + "<name><![CDATA[" + u.getName()
								+ "]]></name></unis></pro>";
					}
			
				}

				// System.out.println(pro.getId()+" "+pro.getName());
				res += "<pro><id>" + pro.getId() + "</id><name><![CDATA[" + pro.getName() + "]]></name><cid>"
						+ pro.getCountry().getId() + "</cid></pro>";
				i++;

			}
			res += "</allProvinces>";
			// res+=res2;
			System.out.println();
			System.out.println(res);
			pw.print(res);

		}
		else if(flag.equals("city"))
		{
		
			
			WebApplicationContext wcx = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
			CityServiceInter cityService=(CityServiceInter) wcx.getBean("cityService");
			int cityId = Integer.parseInt(request.getParameter("cityId"));
			Object []parameters= {cityId};
			List<City> cityList=cityService.executeQuery("from City as city where city.pro.id=?", parameters);
			String res="<allCities>";
			for(City city:cityList)
			{
				res+="<city><id>"+city.getId()+"</id><name>"+city.getName() +"</name></city>";
			}
			res+="</allCities>";
			System.out.println(res);
			pw.print(res);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
