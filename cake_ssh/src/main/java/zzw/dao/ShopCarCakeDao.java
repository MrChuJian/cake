package zzw.dao;

import java.util.List;

import zzw.entity.ShopCar;
import zzw.entity.ShopCarCake;

public interface ShopCarCakeDao extends BaseDao<ShopCarCake>{

	List<ShopCarCake> findByShopCar(ShopCar shopCar);

	void deleteAll(List<ShopCarCake> shopCarCakes);

}
