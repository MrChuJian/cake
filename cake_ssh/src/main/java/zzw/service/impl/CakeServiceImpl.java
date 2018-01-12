package zzw.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.transaction.annotation.Transactional;

import zzw.dao.AddressDao;
import zzw.dao.CakeDao;
import zzw.dao.OrderForGoodsDao;
import zzw.dao.ShopCarCakeDao;
import zzw.dao.ShopCarDao;
import zzw.dao.UserDao;
import zzw.entity.Address;
import zzw.entity.Cake;
import zzw.entity.OrderCake;
import zzw.entity.OrderForGoods;
import zzw.entity.Picture;
import zzw.entity.ShopCar;
import zzw.entity.ShopCarCake;
import zzw.entity.User;
import zzw.entity.Variety;
import zzw.service.CakeService;
import zzw.vo.CakeVO;

@Transactional
public class CakeServiceImpl implements CakeService {

	private CakeDao cakeDao;
	private UserDao userDao;
	private ShopCarDao shopCarDao;
	private ShopCarCakeDao shopCarCakeDao;
	private OrderForGoodsDao orderForGoodsDao;
	private AddressDao addressDao;
	private DozerBeanMapper dozer;
	
	@Override
	public CakeVO getDetail(Integer cid) {
		Cake cake = cakeDao.findById(cid);
		CakeVO cakeVO = dozer.map(cake, CakeVO.class);
		return cakeVO;
	}

	@Override
	public void add(CakeVO cakeVO, List<File> upload, List<String> uploadFileName) {
		Cake cake = dozer.map(cakeVO, Cake.class);
		Date date = new Date();
		cake.setGmt_create(date);
		cake.setGmt_modified(date);
		if (upload != null) {
			for (int i = 0; i < upload.size(); i++) {
				Picture picture = new Picture();
				// 在服务器文件夹里创建文件
				File serverFile = new File("." + "\\target\\picture\\" + uploadFileName.get(i));
				// 把上传文件复制到服务器文件
				try {
					FileUtils.copyFile(upload.get(i), serverFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
				picture.setGmt_create(date);
				picture.setGmt_modified(date);
				picture.setFile(serverFile);
				picture.setCake(cake);
				cake.getPictures().add(picture);
			}
		}
		cakeDao.add(cake);
	}

	@Override
	public List<CakeVO> findAll() {
		List<Cake> cakes = cakeDao.findAll();
		List<CakeVO> cakeVOs = new LinkedList<>();
		for (Cake cake : cakes) {
			cakeVOs.add(dozer.map(cake, CakeVO.class));
		}
		return null;
	}

	@Override
	public List<CakeVO> findByVariety(Variety variety) {
		List<Cake> cakes = cakeDao.findByVariety(variety);
		List<CakeVO> cakeVOs = new LinkedList<>();
		for (Cake cake : cakes) {
			cakeVOs.add(dozer.map(cake, CakeVO.class));
		}
		return cakeVOs;
	}

	@Override
	public void addToShopCar(CakeVO cakeVO, HttpSession session) {
		ShopCarCake shopCarCake = dozer.map(cakeVO, ShopCarCake.class);
		Cake cake = dozer.map(cakeVO, Cake.class);
		String phone = (String) session.getAttribute("phone");
		User user = userDao.findByPhone(phone);
		ShopCar shopCar = shopCarDao.findByUser(user);
		cake = cakeDao.findById(cake.getCid());
		Date date = new Date();
		shopCarCake.setGmt_create(date);
		shopCarCake.setGmt_modified(date);
		shopCarCake.setCake(cake);
		shopCarCake.setShopCar(shopCar);
		shopCarCakeDao.save(shopCarCake);
	}
	
	@Override
	public CakeVO findById(Integer cid) {
		Cake cake = cakeDao.findById(cid);
		CakeVO cakeVO = dozer.map(cake, CakeVO.class);
		return cakeVO;
	}
	
	@Override
	public String generateOrder(HttpSession session, List<CakeVO> cakeVOs, Address address) {
		String phone = (String) session.getAttribute("phone");
		User user = userDao.findByPhone(phone);
		OrderForGoods orderForGoods = new OrderForGoods();
		orderForGoods.setUser(user);
		List<Cake> cakes = new LinkedList<>();
		if (cakeVOs != null && cakeVOs.size() > 0) {
			for (CakeVO cakeVO : cakeVOs) {
				Cake cake = cakeDao.findById(cakeVO.getCid());
				if (cake != null) {
					cakes.add(cake);
				}
			} 
		}
		Set<OrderCake> orderCakes = new HashSet<>();
		if (cakes != null && cakes.size() > 0) {
			for (Cake cake : cakes) {
				OrderCake orderCake = new OrderCake();
				orderCake.setCake(cake);
				orderCakes.add(orderCake);
			} 
		}
		orderForGoods.setOrderCakes(orderCakes);
		address = addressDao.findById(address.getAid());
		orderForGoods.setAddress(address);
		Date date = new Date();
		orderForGoods.setBuyerName(address.getAddressee());
		orderForGoods.setState("1");
		orderForGoods.setGmt_create(date);
		orderForGoods.setGmt_modified(date);
		
		orderForGoodsDao.save(orderForGoods);
		return "111";
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setCakeDao(CakeDao cakeDao) {
		this.cakeDao = cakeDao;
	}

	public void setShopCarDao(ShopCarDao shopCarDao) {
		this.shopCarDao = shopCarDao;
	}

	public void setShopCarCakeDao(ShopCarCakeDao shopCarCakeDao) {
		this.shopCarCakeDao = shopCarCakeDao;
	}

	public void setDozer(DozerBeanMapper dozer) {
		this.dozer = dozer;
	}

	public CakeDao getCakeDao() {
		return cakeDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public ShopCarDao getShopCarDao() {
		return shopCarDao;
	}

	public ShopCarCakeDao getShopCarCakeDao() {
		return shopCarCakeDao;
	}

	public OrderForGoodsDao getOrderForGoodsDao() {
		return orderForGoodsDao;
	}

	public DozerBeanMapper getDozer() {
		return dozer;
	}

	public void setOrderForGoodsDao(OrderForGoodsDao orderForGoodsDao) {
		this.orderForGoodsDao = orderForGoodsDao;
	}

	public AddressDao getAddressDao() {
		return addressDao;
	}

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	

	

	
}
