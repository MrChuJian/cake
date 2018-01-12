package zzw.vo;

import zzw.entity.Cake;
import zzw.entity.ShopCar;

public class ShopCarCakeVO {

	private Integer scid;
	private Integer num;			//数量
	private String title;		//标题
	private Integer price;		//单价
	private Integer totalFee;	//总价

	private ShopCar shopCar;	//购物车
	private Cake cake;			//蛋糕

	public Integer getScid() {
		return scid;
	}

	public void setScid(Integer scid) {
		this.scid = scid;
	}

	public ShopCar getShopCar() {
		return shopCar;
	}

	public Cake getCake() {
		return cake;
	}

	public void setShopCar(ShopCar shopCar) {
		this.shopCar = shopCar;
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
