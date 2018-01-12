package zzw.service.impl;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.transaction.annotation.Transactional;
import zzw.dao.UserDao;
import zzw.entity.ShopCar;
import zzw.entity.User;
import zzw.service.UserService;

@Transactional
public class UserServiceImpl implements UserService{
	

	private UserDao userDao;
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public User findByPhone(String phone) {
		return userDao.findByPhone(phone);
	}
	@Override
	public void update(User user, HttpSession session) {
		String phone = (String) session.getAttribute("phone");
		User userExist = userDao.findByPhone(phone);
		userExist.setGmt_modified(new Date());
		userExist.setUsername(user.getUsername());
		userExist.setSex(user.getSex());
		userExist.setIsLunar(user.getIsLunar());
		userExist.setBirth(user.getBirth());
		userDao.update(userExist);
		
	}
	@Override
	public User findByPhoneAndPassword(String phone, String password) {
		return userDao.findByPhoneAndPassword(phone, password);
	}
	@Override
	public void register(User user) {
		Date date = new Date();
		user.setGmt_create(date);
		user.setGmt_modified(date);
		ShopCar shopCar = new ShopCar();
		shopCar.setGmt_create(date);
		shopCar.setGmt_modified(date);
		shopCar.setUser(user);
		user.setShopCar(shopCar);
		userDao.add(user);
	}

	@Override
	public User getBasicInformation(HttpSession session) {
		String phone = (String) session.getAttribute("phone");
		User user = userDao.findByPhone(phone);
		return user;
	}

	@Override
	public boolean isLogin(HttpServletRequest request, HttpSession session) {
		String phone = (String) session.getAttribute("phone");
		System.out.println(phone);
		if(phone != null) {
			System.out.println("已登录");
			return true;
		} else {
			System.out.println("未登录");
			return false;
		}
	}
}
