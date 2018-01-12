package zzw.entity;

import java.util.Date;

public class ShopCarCake {

	private Integer scid;
	private Integer num;
	private String title;
	private Integer price;
	private Integer totalFee;
	private Date gmt_create;
	private Date gmt_modified;

	private ShopCar shopCar;
	private Cake cake;

	public Integer getScid() {
		return scid;
	}

	public void setScid(Integer scid) {
		this.scid = scid;
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

	public ShopCar getShopCar() {
		return shopCar;
	}

	public void setShopCar(ShopCar shopCar) {
		this.shopCar = shopCar;
	}

	public Cake getCake() {
		return cake;
	}

	public void setCake(Cake cake) {
		this.cake = cake;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getNum() {
		return num;
	}

	public Integer getPrice() {
		return price;
	}

	public Integer getTotalFee() {
		return totalFee;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

}
