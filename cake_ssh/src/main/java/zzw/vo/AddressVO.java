package zzw.vo;

import java.util.Date;
import java.util.Set;

public class AddressVO {

	private Integer aid;
	private String addressee;
	private String address;
	private String code;
	private String addressee_phone;
	private String telephone;
	private Boolean addr_default;
	private String user_color;
	private Date gmt_create;
	private Date gmt_modified;

	private UserVO user;
	private Set<OrderForGoodsVO>  orderForGoodss;

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAddressee() {
		return addressee;
	}

	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAddressee_phone() {
		return addressee_phone;
	}

	public void setAddressee_phone(String addressee_phone) {
		this.addressee_phone = addressee_phone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Boolean getAddr_default() {
		return addr_default;
	}

	public void setAddr_default(Boolean addr_default) {
		this.addr_default = addr_default;
	}

	public String getUser_color() {
		return user_color;
	}

	public void setUser_color(String user_color) {
		this.user_color = user_color;
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

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public Set<OrderForGoodsVO> getOrderForGoodss() {
		return orderForGoodss;
	}

	public void setOrderForGoodss(Set<OrderForGoodsVO> orderForGoodss) {
		this.orderForGoodss = orderForGoodss;
	}

}
