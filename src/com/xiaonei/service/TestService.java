package com.xiaonei.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.xiaonei.domain.Country;
@Transactional
public class TestService {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		System.out.println(sessionFactory);
		this.sessionFactory = sessionFactory;
	}
	public List<Country> showAllCountry()
	{
		//System.out.println("µ÷ÓÃ");
		
		String hql="from Country";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Country> list=query.list();
		return list;
	}
}
