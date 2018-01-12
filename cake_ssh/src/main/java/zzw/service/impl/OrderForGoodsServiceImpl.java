package zzw.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.dozer.DozerBeanMapper;
import org.springframework.transaction.annotation.Transactional;

import zzw.dao.OrderForGoodsDao;
import zzw.entity.OrderForGoods;
import zzw.entity.User;
import zzw.service.OrderForGoodsService;
import zzw.vo.OrderForGoodsVO;

@Transactional
public class OrderForGoodsServiceImpl implements OrderForGoodsService {

	private OrderForGoodsDao orderForGoodsDao;
	private DozerBeanMapper dozer;
	
	
	@Override
	public void delete(OrderForGoodsVO orderForGoodsVO) {
		OrderForGoods orderForGoods = dozer.map(orderForGoodsVO, OrderForGoods.class);
		orderForGoodsDao.delete(orderForGoods);
		
	}
	@Override
	public List<OrderForGoods> findByUser(User user) {
		return orderForGoodsDao.findByUser(user);
	}
	
	
	
	
	public void setOrderForGoodsDao(OrderForGoodsDao orderForGoodsDao) {
		this.orderForGoodsDao = orderForGoodsDao;
	}
	public OrderForGoodsDao getOrderForGoodsDao() {
		return orderForGoodsDao;
	}
	public DozerBeanMapper getDozer() {
		return dozer;
	}
	public void setDozer(DozerBeanMapper dozer) {
		this.dozer = dozer;
	}
	
	
	
}
