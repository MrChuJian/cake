package zzw.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ShopCar {

	private Integer sid;
	private Date gmt_create;
	private Date gmt_modified;
	
	private User user;
	private Set<ShopCarCake> shopCarCakes = new HashSet<>();

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<ShopCarCake> getShopCarCakes() {
		return shopCarCakes;
	}

	public void setShopCarCakes(Set<ShopCarCake> shopCarCakes) {
		this.shopCarCakes = shopCarCakes;
	}
	
	
}
