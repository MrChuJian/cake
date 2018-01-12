package zzw.dao;
import java.util.List;

/**
 * 
 * @author zzw
 *
 * @param <T>
 */
public interface BaseDao<T> {

//	添加
	public void add(T t);
	public void save(T t);
	
//	添加或更新
	public void saveOrUpdate(T t);
	
//	修改
	public void update(T t);
	
//	删除
	public void delete(T t);
	
//	根据id查询
	public T findById(int id);
	
//	查询全部
	public List<T> findAll();
}