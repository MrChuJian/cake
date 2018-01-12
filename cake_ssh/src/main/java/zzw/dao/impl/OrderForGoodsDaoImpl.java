package zzw.dao.impl;

import java.util.List;

import zzw.dao.OrderForGoodsDao;
import zzw.entity.OrderForGoods;
import zzw.entity.User;

public class OrderForGoodsDaoImpl extends BaseDaoImpl<OrderForGoods> implements OrderForGoodsDao {

	@Override
	public List<OrderForGoods> findByUser(User user) {
		List<OrderForGoods> orderForGoodsList = (List<OrderForGoods>) this.getHibernateTemplate().find("from OrderForGoods where user = ?", user);
		return orderForGoodsList;
	}


}
