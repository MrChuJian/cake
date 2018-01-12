package zzw.entity;

import java.util.Date;

public class TradeRecord {

	private Integer tid;
	private Date time;
	private String out_in;
	private String sum;
	private String form_num;
	private Date gmt_create;
	private Date gmt_modified;
	
	private User user;
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getOut_in() {
		return out_in;
	}

	public void setOut_in(String out_in) {
		this.out_in = out_in;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getForm_num() {
		return form_num;
	}

	public void setForm_num(String form_num) {
		this.form_num = form_num;
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
