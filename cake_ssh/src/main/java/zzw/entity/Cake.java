package zzw.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Cake {
	
	private Integer cid;
	private String name;		//蛋糕名字
	private Integer price;		//单价
	private Integer size;		//大小
	private String wish;		//祝福语
	private String sweetness;	//甜度
	private Date gmt_create;
	private Date gmt_modified;

	private Variety variety;
	private Set<Picture> pictures = new HashSet<>();
	private Set<OrderCake> orderCakes = new HashSet<>();
	private Set<ShopCarCake> shopCarCakes = new HashSet<>();

	public Set<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(Set<Picture> pictures) {
		this.pictures = pictures;
	}

	public Set<ShopCarCake> getShopCarCakes() {
		return shopCarCakes;
	}

	public void setShopCarCakes(Set<ShopCarCake> shopCarCakes) {
		this.shopCarCakes = shopCarCakes;
	}

	public Variety getVariety() {
		return variety;
	}

	public void setVariety(Variety variety) {
		this.variety = variety;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public Integer getSize() {
		return size;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getWish() {
		return wish;
	}

	public void setWish(String wish) {
		this.wish = wish;
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

	public String getSweetness() {
		return sweetness;
	}

	public void setSweetness(String sweetness) {
		this.sweetness = sweetness;
	}

	public Set<OrderCake> getOrderCakes() {
		return orderCakes;
	}

	public void setOrderCakes(Set<OrderCake> orderCakes) {
		this.orderCakes = orderCakes;
	}
}
