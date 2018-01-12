package zzw.entity;

import java.util.Date;

public class OrderCake {

	private Integer ocid;
	private String num;
	private String title;
	private String price;
	private String totalFee;
	private Date gmt_create;
	private Date gmt_modified;

	private OrderForGoods orderForGoods;
	private Cake cake;

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

	public OrderForGoods getOrderForGoods() {
		return orderForGoods;
	}

	public void setOrderForGoods(OrderForGoods orderForGoods) {
		this.orderForGoods = orderForGoods;
	}

	public Cake getCake() {
		return cake;
	}

	public void setCake(Cake cake) {
		this.cake = cake;
	}

}
