package zzw.vo;

import java.io.File;
import java.util.Date;

public class PictureVO {

	private Integer pid;
	private File file;
	private Date gmt_create;
	private Date gmt_modified;
	
	private CakeVO cake;
	
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public CakeVO getCake() {
		return cake;
	}
	public void setCake(CakeVO cake) {
		this.cake = cake;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
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
