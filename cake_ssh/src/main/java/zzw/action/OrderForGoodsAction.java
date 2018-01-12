package zzw.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import zzw.entity.OrderForGoods;
import zzw.entity.User;
import zzw.service.OrderForGoodsService;
import zzw.service.UserService;
import zzw.vo.CakeVO;
import zzw.vo.OrderForGoodsVO;

public class OrderForGoodsAction extends BaseAction implements ModelDriven<OrderForGoodsVO> {

	private OrderForGoodsVO orderForGoodsVO;
	private OrderForGoodsService orderForGoodsService;
	private List<OrderForGoods> orderForGoodss;
	private List<OrderForGoodsVO> orderForGoodsVOs;
	private String msg;

	public OrderForGoodsAction() {
		super();
	}

	public String getOrderForGoodsInformation() {
		orderForGoodss = orderForGoodsService.findByUser(orderForGoodsVO.getUser());
		return "getOrderForGoodsInformation";
	}

	public String delete() {
		orderForGoodsService.delete(orderForGoodsVO);
		msg = "删除成功";
		return "delete";
	}

	public void setOrderForGoodsService(OrderForGoodsService orderForGoodsService) {
		this.orderForGoodsService = orderForGoodsService;
	}

	public List<OrderForGoods> getOrderForGoodss() {
		return orderForGoodss;
	}

	public void setOrderForGoodss(List<OrderForGoods> orderForGoodss) {
		this.orderForGoodss = orderForGoodss;
	}

	public String getMsg() {
		return msg;
	}

	@Override
	public OrderForGoodsVO getModel() {
		return orderForGoodsVO;
	}

	public OrderForGoodsVO getOrderForGoodsVO() {
		return orderForGoodsVO;
	}

	public OrderForGoodsService getOrderForGoodsService() {
		return orderForGoodsService;
	}

	public void setOrderForGoodsVO(OrderForGoodsVO orderForGoodsVO) {
		this.orderForGoodsVO = orderForGoodsVO;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<OrderForGoodsVO> getOrderForGoodsVOs() {
		return orderForGoodsVOs;
	}

	public void setOrderForGoodsVOs(List<OrderForGoodsVO> orderForGoodsVOs) {
		this.orderForGoodsVOs = orderForGoodsVOs;
	}
	
}
