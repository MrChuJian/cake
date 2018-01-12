package zzw.vo;

import java.util.HashSet;
import java.util.Set;

import zzw.entity.Picture;
import zzw.entity.Variety;

public class CakeVO {

	private Integer cid;
	private String name;//蛋糕名字
	private Integer price;//单价
	private Integer size;//大小
	private String wish;//祝福语
	private Integer sweetness;//甜度
	private Integer num;//数量
	private String title;//标题
	private Integer totalFee;//总价

	private Variety variety;
	private Set<Picture> pictures = new HashSet<>();

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

	public String getWish() {
		return wish;
	}

	public void setWish(String wish) {
		this.wish = wish;
	}

	public Integer getSweetness() {
		return sweetness;
	}

	public void setSweetness(Integer sweetness) {
		this.sweetness = sweetness;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPrice() {
		return price;
	}

	public Integer getSize() {
		return size;
	}

	public Integer getNum() {
		return num;
	}

	public Integer getTotalFee() {
		return totalFee;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public Variety getVariety() {
		return variety;
	}

	public void setVariety(Variety variety) {
		this.variety = variety;
	}

	public Set<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(Set<Picture> pictures) {
		this.pictures = pictures;
	}

}
