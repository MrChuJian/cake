package zzw.action;

import java.util.LinkedList;
import java.util.List;
import com.opensymphony.xwork2.ModelDriven;

import zzw.service.ShopCarService;
import zzw.vo.ShopCarCakeVO;
import zzw.vo.ShopCarVO;

public class ShopCarAction extends BaseAction implements ModelDriven<ShopCarVO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4340048389245921901L;
	private ShopCarVO shopCarVO = new ShopCarVO();
	private ShopCarService shopCarService;
	private String msg;
	private List<ShopCarCakeVO> shopCarCakeVOs;
	private List<Integer> scid = new LinkedList<>();

	public ShopCarAction() {
		super();
	}

	/**
	 * 查找购物车中所有的蛋糕详情
	 * 
	 * @return
	 */
	public String findAll() {
		shopCarCakeVOs = shopCarService.findAll(getSession());
		return "findAll";
	}

	/**
	 * 删除购物车中的蛋糕详情
	 * 
	 * @return
	 */
	public String delete() {
		msg = shopCarService.delete(shopCarVO, scid);
		return "delete";
	}
	
	/**
	 * 更新购物车
	 * 
	 * @return
	 */
	public String update() {
		
		return null;
	}

	@Override
	public ShopCarVO getModel() {
		return shopCarVO;
	}

	public void setShopCarService(ShopCarService shopCarService) {
		this.shopCarService = shopCarService;
	}

	public String getMsg() {
		return msg;
	}

	public List<ShopCarCakeVO> getShopCarCakeVOs() {
		return shopCarCakeVOs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ShopCarVO getShopCarVO() {
		return shopCarVO;
	}

	public ShopCarService getShopCarService() {
		return shopCarService;
	}

	public List<Integer> getScid() {
		return scid;
	}

	public void setShopCarVO(ShopCarVO shopCarVO) {
		this.shopCarVO = shopCarVO;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setShopCarCakeVOs(List<ShopCarCakeVO> shopCarCakeVOs) {
		this.shopCarCakeVOs = shopCarCakeVOs;
	}

	public void setScid(List<Integer> scid) {
		this.scid = scid;
	}
	
}
