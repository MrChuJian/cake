package zzw.dao.impl;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import zzw.dao.BaseDao;

/**
 * 
 * @author zzw
 *
 * @param <T>
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{

	private Class pClass;
	
//	构造方法获得实际类型参数Class
	public BaseDaoImpl() {
//		1得到当前运行类Class
		Class clazz = this.getClass();
		
//		2得到当前运行类的父类的参数化类型BaseDaoImpl<Customer>
//		Type getGenericSuperclass()
		Type type = clazz.getGenericSuperclass();
//		使用Type子接口ParameterizedType
		ParameterizedType ptype = (ParameterizedType) type;
		
//		3得到实际类型参数<Customer>里面的Customer
		Type[] types = ptype.getActualTypeArguments();
		this.pClass = (Class) types[0];
	}

//	添加
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}
	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}
	
	public void saveOrUpdate(T t) {
		this.getHibernateTemplate().saveOrUpdate(t);
	}

//	修改
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

//	删除
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

//	查询全部
	public List<T> findAll() {
//		System.out.println("findAll");
//		System.out.println(pClass.getSimpleName());
//		System.out.println(pClass.getName());
		return (List<T>) this.getHibernateTemplate().find("from "+pClass.getSimpleName());
	}

//	根据id查询
	public T findById(int id) {
//		System.out.println("findOne");
		return (T) this.getHibernateTemplate().get(pClass,id);
	}
}