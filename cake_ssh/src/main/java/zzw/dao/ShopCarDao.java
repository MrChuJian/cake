package zzw.dao;

import zzw.entity.ShopCar;
import zzw.entity.User;

public interface ShopCarDao extends BaseDao<ShopCar>{

	ShopCar findByUser(User user);

}
