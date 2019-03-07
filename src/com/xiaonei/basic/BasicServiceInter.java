package com.xiaonei.basic;

import java.util.List;

public interface BasicServiceInter {
	// 统一的查询方法
	public List executeQuery(String hql, Object[] parameters);

	// 统一的修改方法
	public int executeUpdate(String hql, Object[] parameters);

	public Object uniqueQuery(String hql, Object[] parameters);

	// 通过id获取对象
	public Object getObjectById(Class clazz, java.io.Serializable id);

	// 统一的添加方法
	public void save(Object obj);

	// 分页查询
	public List executeQueryByPage(String hql, Object[] parameters, int pageNow, int pageSize);

	public int getPageCount(String hql, int pageSize);

	public int getRowCount(String hql, int pageSize);

	public boolean deleteById(Class clazz, java.io.Serializable id);

	public Object getObjectByName(Class clazz, String name);

}
