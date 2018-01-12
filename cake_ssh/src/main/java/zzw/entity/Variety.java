package zzw.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

public class Variety {

	private Integer vid;
	private String variety;
	private Date gmt_create;
	private Date gmt_modified;
	
	private Set<Cake> cakes;
	
	
	public Set<Cake> getCakes() {
		return cakes;
	}

	public void setCakes(Set<Cake> cakes) {
		this.cakes = cakes;
	}

	public Integer getVid() {
		return vid;
	}

	public void setVid(Integer vid) {
		this.vid = vid;
	}

	public String getVariety() {
		return variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
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
	
	
}
