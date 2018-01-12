package zzw.vo;

import java.util.Date;

public class OrderCakeVO {

	private Integer ocid;
	private String num;
	private String title;
	private String price;
	private String totalFee;
	private Date gmt_create;
	private Date gmt_modified;

	private OrderForGoodsVO orderForGoods;
	private CakeVO cake;

	public Integer getOcid() {
		return ocid;
	}

	public void setOcid(Integer ocid) {
		this.ocid = ocid;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public Date getGmt_create() {
		return gmt_create;
	}

	public void setGmt_create(Date gmt_create) {
		this.gmt_create = gmt_create;
	}

	public Date getGmt_modified() {
		return gmt_modified;
	}

	public void setGmt_modified(Date gmt_modified) {
		this.gmt_modified = gmt_modified;
	}

	public OrderForGoodsVO getOrderForGoods() {
		return orderForGoods;
	}

	public void setOrderForGoods(OrderForGoodsVO orderForGoods) {
		this.orderForGoods = orderForGoods;
	}

	public CakeVO getCake() {
		return cake;
	}

	public void setCake(CakeVO cake) {
		this.cake = cake;
	}

}
