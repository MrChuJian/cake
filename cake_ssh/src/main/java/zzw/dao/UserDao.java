package zzw.dao;

import zzw.entity.User;

public interface UserDao extends BaseDao<User>{

	User findByPhoneAndPassword(String phone, String password);

	User findByPhone(String phone);

}
