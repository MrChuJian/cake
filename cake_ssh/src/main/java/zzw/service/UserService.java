package zzw.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import zzw.entity.User;

public interface UserService {


	User findByPhone(String phone);

	void update(User user, HttpSession session);

	User findByPhoneAndPassword(String phone, String password);

	void register(User user);

	User getBasicInformation(HttpSession session);

	boolean isLogin(HttpServletRequest request, HttpSession session);


}
