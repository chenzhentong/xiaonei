package com.xiaonei.basic;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class BasicService implements BasicServiceInter {
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		System.out.println("BasicµÄsessionFactoy:"+sessionFactory);
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List executeQuery(String hql, Object[] parameters) {
		
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		if(parameters!=null&&parameters.length>0)
		{
			for(int i=0;i<parameters.length;i++)
			{
				query.setParameter(i, parameters[i]);
			}
			
		}
		List list=query.list();
		
		return list;
	}

	@Override
	public int executeUpdate(String hql, Object[] parameters) {

		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		if(parameters!=null&&parameters.length>0)
		{
			for(int i=0;i<parameters.length;i++)
			{
				query.setParameter(i, parameters[i]);
			}
			
		}
		int flag=query.executeUpdate();
		
		return flag;
	}

	@Override
	public Object getObjectById(Class clazz, Serializable id) {
		String name=clazz.toString();
		int beginIndex=name.lastIndexOf(".");
		name=name.substring(beginIndex,name.length());
		name=(String) name.subSequence(1, name.length());
		String hql="from "+name+" where id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, id);
		Object obj=query.uniqueResult();
		return obj;
	}
	@Override
	public void save(Object obj) {
		this.sessionFactory.getCurrentSession().save(obj);
		//sessionFactory.openSession().save(obj);
		
	}

	@Override
	public List executeQueryByPage(String hql, Object[] parameters, int pageNow, int pageSize) {
	
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		if(parameters!=null&&!parameters.equals(""))
		{
			for(int i=0;i<parameters.length;i++)
			{
				query.setParameter(i, parameters[i]);
			}
			
		}
		query.setFirstResult((pageNow-1)*pageSize);
		query.setMaxResults(pageSize);
		List list=query.list();
		
		return list;
	}

	@Override
	public Object uniqueQuery(String hql, Object[] parameters) {
		System.out.println("uniqueQuery"+sessionFactory);
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		if(parameters!=null&&parameters.length>0)
		{
			for(int i=0;i<parameters.length;i++)
			{
				query.setParameter(i, parameters[i]);
			}
			
		}
		Object obj=query.uniqueResult();
		//Hibernate.initialize(obj);
		return obj;
	}

	@Override
	public int getPageCount(String hql,int pageSize) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List list=query.list();
		int rowCount=list.size();
		int pageCount=0;
		if(rowCount!=0)
		{
			if(rowCount%pageSize==0)
			{
				pageCount=rowCount/pageSize;
			}
			else
			{
				pageCount=(rowCount/pageSize)+1;
			}
			
		}
		return pageCount;
	}

	@Override
	public boolean deleteById(Class clazz, Serializable id) {
		
		Object obj=this.getObjectById(clazz, id);
		if(obj!=null)
		{
			sessionFactory.getCurrentSession().delete(obj);
			return  true;
			
		}
		return false;
	}

	@Override
	public Object getObjectByName(Class clazz, String name) {
		String name1=clazz.toString();
		int beginIndex=name1.lastIndexOf(".");
		name1=name1.substring(beginIndex,name1.length());
		name1=(String) name1.subSequence(1, name1.length());
		String hql="from "+name1+" where name=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		Object obj=query.uniqueResult();
		
		return obj;
	}

	@Override
	public int getRowCount(String hql, int pageSize) {
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List list=query.list();
		int rowCount=list.size();
		return rowCount;
	}
	

}
