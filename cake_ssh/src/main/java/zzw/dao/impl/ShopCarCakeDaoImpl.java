package zzw.dao.impl;

import java.util.List;

import zzw.dao.ShopCarCakeDao;
import zzw.entity.ShopCar;
import zzw.entity.ShopCarCake;

public class ShopCarCakeDaoImpl extends BaseDaoImpl<ShopCarCake> implements ShopCarCakeDao {

	@Override
	public List<ShopCarCake> findByShopCar(ShopCar shopCar) {
		return (List<ShopCarCake>) this.getHibernateTemplate().find("from ShopCarCake where shopCar = ?", shopCar);
		
	}

	@Override
	public void deleteAll(List<ShopCarCake> shopCarCakes) {
		this.getHibernateTemplate().deleteAll(shopCarCakes);
	}

}
