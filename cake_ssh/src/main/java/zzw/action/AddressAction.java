package zzw.action;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import zzw.entity.Address;
import zzw.entity.User;
import zzw.service.AddressService;
import zzw.service.UserService;
/*
 * @author zzw
 */
public class AddressAction extends ActionSupport implements ModelDriven<Address>{
	private Address address = new Address();
	private AddressService addressService;
	private UserService userService;
	private List<Address> addresss;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private HttpSession session;
	private String msg;
	
	public AddressAction() {
		response = ServletActionContext.getResponse();
		request = ServletActionContext.getRequest();
		session = request.getSession();
		response.setHeader("Access-Control-Allow-Origin", "*");
	}
	
	
	public String getAddressInformation() {
		String phone = (String) session.getAttribute("phone");
		User user = userService.findByPhone(phone);
		addresss = addressService.findByUser(user);
		return "getAddressInformation";
	}
	
	public String add() {
//		String phone = (String) ServletActionContext.getRequest().getSession().getAttribute("phone");
		
		addressService.addOrUpdate(address, session);
		return "add";
	}
	
	public String update() {
		return null;
	}
	
	public String delete() {
		addressService.delete(address);
		msg = "删除成功";
		return "delete";
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	public Address getModel() {
		return address;
	}
	public List<Address> getAddresss() {
		return addresss;
	}
	public void setAddresss(List<Address> addresss) {
		this.addresss = addresss;
	}
	public String getMsg() {
		return msg;
	}
}