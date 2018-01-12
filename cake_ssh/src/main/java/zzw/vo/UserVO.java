package zzw.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UserVO {
	private Integer uid;
	private String username;
	private String password;
	private String phone;
	private String sex;
	private Boolean isLunar;
	private Date birth;
	private String email;
	private Integer balance;
	private Date gmt_create;
	private Date gmt_modified;

	private Set<AddressVO> addressSet = new HashSet<AddressVO>();
	private Set<CardVO> cardSet = new HashSet<CardVO>();
	private Set<TradeRecordVO> tradeRecord = new HashSet<TradeRecordVO>();
	private ShopCarVO shopCar;

	public Set<TradeRecordVO> getTradeRecord() {
		return tradeRecord;
	}

	public void setTradeRecord(Set<TradeRecordVO> tradeRecord) {
		this.tradeRecord = tradeRecord;
	}

	public Set<CardVO> getCardSet() {
		return cardSet;
	}

	public void setCardSet(Set<CardVO> cardSet) {
		this.cardSet = cardSet;
	}

	public Set<AddressVO> getAddressSet() {
		return addressSet;
	}

	public void setAddressSet(Set<AddressVO> addressSet) {
		this.addressSet = addressSet;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Boolean getIsLunar() {
		return isLunar;
	}

	public void setIsLunar(Boolean isLunar) {
		this.isLunar = isLunar;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public ShopCarVO getShopCar() {
		return shopCar;
	}

	public void setShopCar(ShopCarVO shopCar) {
		this.shopCar = shopCar;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", phone=" + phone + ", sex="
				+ sex + ", isLunar=" + isLunar + ", birth=" + birth + ", email=" + email + ", balance=" + balance + "]";
	}

}
