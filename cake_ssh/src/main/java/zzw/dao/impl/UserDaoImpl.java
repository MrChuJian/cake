package zzw.dao.impl;

import java.util.List;
import zzw.dao.UserDao;
import zzw.entity.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public User findByPhoneAndPassword(String phone, String password) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where phone = ? and password = ?", phone, password);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public User findByPhone(String phone) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where phone = ?", phone);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
