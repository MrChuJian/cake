package zzw.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.dozer.DozerBeanMapper;
import org.springframework.transaction.annotation.Transactional;

import zzw.dao.ShopCarCakeDao;
import zzw.dao.ShopCarDao;
import zzw.dao.UserDao;
import zzw.entity.ShopCar;
import zzw.entity.ShopCarCake;
import zzw.entity.User;
import zzw.service.ShopCarService;
import zzw.vo.ShopCarCakeVO;
import zzw.vo.ShopCarVO;

@Transactional
public class ShopCarServiceImpl implements ShopCarService {

	private ShopCarDao shopCarDao;
	private UserDao userDao;
	private ShopCarCakeDao shopCarCakeDao;
	private DozerBeanMapper dozer;

	@Override
	public List<ShopCarCakeVO> findAll(HttpSession session) {
//		String phone = (String) session.getAttribute("phone");
		String phone = "13333333333";
		User user = userDao.findByPhone(phone);
		ShopCar shopCar = shopCarDao.findByUser(user);
		List<ShopCarCake> shopCarCakes = shopCarCakeDao.findByShopCar(shopCar);
		List<ShopCarCakeVO> shopCarCakeVOs = new LinkedList<ShopCarCakeVO>();
		for (ShopCarCake shopCarCake : shopCarCakes) {
			shopCarCakeVOs.add(dozer.map(shopCarCake, ShopCarCakeVO.class));
		}
		return shopCarCakeVOs;
	}
	
	@Override
	public String delete(ShopCarVO shopCarVO, List<Integer> scid) {
		if (scid != null && scid.size() > 0) {
			for (Integer id : scid) {
				List<ShopCarCake> shopCarCakes = new LinkedList<>();
//				shopCarCakes.add(shopCarCakeDao.findById(id));
				ShopCarCake shopCarCake = new ShopCarCake();
				shopCarCake.setScid(id);
				shopCarCakes.add(shopCarCake);
				shopCarCakeDao.deleteAll(shopCarCakes);
			}
		}
		return "100";
	}
	
	
	public void setShopCarDao(ShopCarDao shopCarDao) {
		this.shopCarDao = shopCarDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setShopCarCakeDao(ShopCarCakeDao shopCarCakeDao) {
		this.shopCarCakeDao = shopCarCakeDao;
	}
	public void setDozer(DozerBeanMapper dozer) {
		this.dozer = dozer;
	}


	


}
