package zzw.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import zzw.entity.OrderForGoods;
import zzw.entity.User;
import zzw.vo.OrderForGoodsVO;

public interface OrderForGoodsService {


	List<OrderForGoods> findByUser(User user);

	void delete(OrderForGoodsVO orderForGoodsVO);

}
