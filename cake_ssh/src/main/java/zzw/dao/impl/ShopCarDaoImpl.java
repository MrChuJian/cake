package zzw.dao.impl;

import java.util.List;

import zzw.dao.ShopCarDao;
import zzw.entity.ShopCar;
import zzw.entity.User;

public class ShopCarDaoImpl extends BaseDaoImpl<ShopCar> implements ShopCarDao{

	@Override
	public ShopCar findByUser(User user) {
		List<ShopCar> shopCars = (List<ShopCar>) this.getHibernateTemplate().find("from ShopCar where user = ?", user);
		if (shopCars != null && shopCars.size() > 0) {
			return shopCars.get(0);
		}
		return null;
	}

}
