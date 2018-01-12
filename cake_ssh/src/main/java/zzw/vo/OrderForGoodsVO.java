package zzw.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import zzw.entity.Address;
import zzw.entity.OrderCake;
import zzw.entity.User;

/**
 * 
 * @author zzw
 *
 */

public class OrderForGoodsVO {

	private Integer oid; // id
	private String payment; // 实付金额
	private String paymentType; // 支付类型
	private String postage; // 邮费
	private Date paymentTime; // 付款时间
	private Date consignTime; // 发货时间
	private Date finishTime; // 完成时间
	private String buyerMessage;// 买家留言
	private String buyerName; // 买家昵称
	private String buyerRate; // 买家是否评论
	private String state; // 状态：1未付款，2已付款，3未发货，4已发货，5交易成功

	private Address address;
	private Set<OrderCake> orderCakes = new HashSet<>();
	private User user;

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPostage() {
		return postage;
	}

	public void setPostage(String postage) {
		this.postage = postage;
	}

	public Date getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

	public Date getConsignTime() {
		return consignTime;
	}

	public void setConsignTime(Date consignTime) {
		this.consignTime = consignTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public String getBuyerMessage() {
		return buyerMessage;
	}

	public void setBuyerMessage(String buyerMessage) {
		this.buyerMessage = buyerMessage;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerRate() {
		return buyerRate;
	}

	public void setBuyerRate(String buyerRate) {
		this.buyerRate = buyerRate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Address getAddress() {
		return address;
	}

	public Set<OrderCake> getOrderCakes() {
		return orderCakes;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setOrderCakes(Set<OrderCake> orderCakes) {
		this.orderCakes = orderCakes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
