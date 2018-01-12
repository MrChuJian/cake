package zzw.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.dozer.DozerBeanMapper;

import com.opensymphony.xwork2.ModelDriven;

import zzw.entity.Address;
import zzw.entity.Cake;
import zzw.entity.OrderForGoods;
import zzw.service.CakeService;
import zzw.vo.CakeVO;

public class CakeAction extends BaseAction implements ModelDriven<CakeVO> {

	private CakeVO cakeVO = new CakeVO();
	private CakeService cakeService;
	private List<File> upload;
	private List<String> uploadFileName;
	private List<CakeVO> cakeVOs;
	private DozerBeanMapper dozer;
	private String msg;
	private Address address;
	private OrderForGoods orderForGoods;

	public CakeAction() {
		super();
	}

	/**
	 * 添加到购物车
	 * 
	 * @return
	 */
	public String addToShopCar() {
		cakeService.addToShopCar(cakeVO, getSession());
		return null;
	}

	/**
	 * 添加蛋糕
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		getResponse().setHeader("Cache-Control", "no-store");
		getResponse().setDateHeader("Expires", 0);
		getResponse().setHeader("Pragma", "no-cache");
		cakeService.add(cakeVO, upload, uploadFileName);
		return "add";
	}

	public String buy() {
		CakeVO cakeVO = new CakeVO();
		cakeVO.setName("12");
		cakeVO.setNum(23);
		Cake cake = dozer.map(cakeVO, Cake.class);
		System.out.println(cake.getName());
		return null;
	}

	public String findAll() {
		cakeVOs = cakeService.findAll();
		return "findAll";
	}

	public String findByVariety() {
		cakeVOs = cakeService.findByVariety(cakeVO.getVariety());
		return "findByVariety";
	}

	public String toDetail() throws IOException {
		getResponse().sendRedirect("http://192.168.1.109:8080/cake_ssh/HTML/cake1.html?cid=" + cakeVO.getCid());
		return NONE;
	}
	
	public String getDetail() {
		cakeVO = cakeService.getDetail(cakeVO.getCid());
		return "getDetail";
	}

	public String generateOrder() {
		msg = cakeService.generateOrder(getSession(), cakeVOs, address);
		return "generateOrder";
	}

	public void setCakeService(CakeService cakeService) {
		this.cakeService = cakeService;
	}

	public CakeVO getModel() {
		return cakeVO;
	}

	public List<File> getUpload() {
		return upload;
	}

	public void setUpload(List<File> upload) {
		this.upload = upload;
	}

	public List<String> getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public CakeService getCakeService() {
		return cakeService;
	}

	public void setDozer(DozerBeanMapper dozer) {
		this.dozer = dozer;
	}

	public CakeVO getCakeVO() {
		return cakeVO;
	}

	public void setCakeVO(CakeVO cakeVO) {
		this.cakeVO = cakeVO;
	}

	public List<CakeVO> getCakeVOs() {
		return cakeVOs;
	}

	public DozerBeanMapper getDozer() {
		return dozer;
	}

	public void setCakeVOs(List<CakeVO> cakeVOs) {
		this.cakeVOs = cakeVOs;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public OrderForGoods getOrderForGoods() {
		return orderForGoods;
	}

	public void setOrderForGoods(OrderForGoods orderForGoods) {
		this.orderForGoods = orderForGoods;
	}

}
