package zzw.dao;

import java.util.List;

import zzw.entity.OrderForGoods;
import zzw.entity.User;

public interface OrderForGoodsDao extends BaseDao<OrderForGoods> {

	List<OrderForGoods> findByUser(User user);

}
