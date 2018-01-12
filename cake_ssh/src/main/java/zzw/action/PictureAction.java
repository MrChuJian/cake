package zzw.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import zzw.entity.Cake;
import zzw.entity.Picture;
import zzw.service.CakeService;
import zzw.service.PictureService;

public class PictureAction extends ActionSupport implements ModelDriven<Picture>{

	private Picture picture = new Picture();
	private PictureService pictureService;
	private CakeService cakeService;
	private InputStream inputStream;
	private String fileName;
	private List<Picture> pictures;
	private HttpServletResponse response;
	private HttpServletRequest request;
	
	public PictureAction() {
		response = ServletActionContext.getResponse();
		request = ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", "*");
	}
	
	public String show() {
		Cake cake = new Cake();
		cake.setCid(7);
		List<Picture> pictures = pictureService.findByCake(cake);
		try {
			inputStream = new FileInputStream(pictures.get(0).getFile());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return "show";
	}
	
	public String findByFileName() {
		if (fileName != null) {
			File file = new File("." + "\\target\\picture\\" + fileName);
			try {
				inputStream = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
		}
		return "findByFileName";
	}
	
	public String findByCake() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer cid = Integer.valueOf(request.getParameter("cid"));
		Cake cake = new Cake();
		cake.setCid(cid);
		pictures = pictureService.findByCake(cake);
		return "findByCake";
	}
	
	
	
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public Picture getModel() {
		return picture;
	}
	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}
	public void setCakeService(CakeService cakeService) {
		this.cakeService = cakeService;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public List<Picture> getPictures() {
		return pictures;
	}
	
}
