package zzw.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import zzw.entity.User;
import zzw.entity.Variety;
import zzw.service.VarietyService;

public class VarietyAction extends ActionSupport implements ModelDriven<Variety> {

	private Variety variety = new Variety();
	private VarietyService varietyService;
	private List<Variety> varietys;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private HttpSession session;
	private List<User> list = new LinkedList<>();
	private Set<User> set = new HashSet<>();
	private Map<String, User> map = new HashMap<>();
	private User user;

	public VarietyAction() {
		response = ServletActionContext.getResponse();
		request = ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", "*");
		session = request.getSession();
	}

	public String test() throws IOException {
		response.setHeader( "Cache-Control" , "no-store" );   
        response.setDateHeader( "Expires" , 0);   
        response.setHeader( "Pragma" , "no-cache" );
		System.out.println("1");
		varietys = varietyService.findAll();
		return "test";
	}

	public String findAll() {
		varietys = varietyService.findAll();
		return "findAll";
	}

	public String add() {
		varietyService.add(variety);
		return "add";
	}

	public String update() {

		return "update";
	}

	public String delete() {

		return "delete";
	}

	public void setVarietyService(VarietyService varietyService) {
		this.varietyService = varietyService;
	}

	public Variety getModel() {
		return variety;
	}

	public List<Variety> getVarietys() {
		return varietys;
	}

	public Variety getVariety() {
		return variety;
	}

	public VarietyService getVarietyService() {
		return varietyService;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setVariety(Variety variety) {
		this.variety = variety;
	}

	public void setVarietys(List<Variety> varietys) {
		this.varietys = varietys;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public List<User> getList() {
		return list;
	}

	public Set<User> getSet() {
		return set;
	}

	public Map<String, User> getMap() {
		return map;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public void setSet(Set<User> set) {
		this.set = set;
	}

	public void setMap(Map<String, User> map) {
		this.map = map;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
