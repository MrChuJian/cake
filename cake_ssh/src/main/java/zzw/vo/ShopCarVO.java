package zzw.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.util.Element;
import com.opensymphony.xwork2.util.KeyProperty;

import zzw.entity.ShopCarCake;
import zzw.entity.User;

public class ShopCarVO {

	private Integer sid;
	
	private User user;
	@KeyProperty("scid")
	@Element(ShopCarCake.class)
	private Set<ShopCarCake> shopCarCakes = new HashSet<>();

	
	
	
	public Integer getSid() {
		return sid;
	}

	public User getUser() {
		return user;
	}

	public Set<ShopCarCake> getShopCarCakes() {
		return shopCarCakes;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setShopCarCakes(Set<ShopCarCake> shopCarCakes) {
		this.shopCarCakes = shopCarCakes;
	}

	
}
