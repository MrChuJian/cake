package zzw.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aopalliance.intercept.Invocation;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor{

//	拦截逻辑
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		response.setHeader("Access-Control-Allow-Origin", "*");
		String phone = (String) session.getAttribute("phone");
		
		if (phone == null) {
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equalsIgnoreCase("phone")) {
						phone = cookie.getValue();
						session.setAttribute("phone", phone);
						break;
					}
				} 
			}
		}
		
		if(phone != null) {
//			是登陆状态，做类似放行操作
			return invocation.invoke();
		} else {
//			不是登陆状态，不执行action方法，直接到result标签找返回值
			return "noLogin";
		}
	}
}
