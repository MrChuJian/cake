package zzw.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	private HttpServletResponse response;
	private HttpServletRequest request;
	private HttpSession session;
	
	public BaseAction() {
		response = ServletActionContext.getResponse();
		request = ServletActionContext.getRequest();
		session = request.getSession();
		response.setHeader("Access-Control-Allow-Origin", "*");
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

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}
}
