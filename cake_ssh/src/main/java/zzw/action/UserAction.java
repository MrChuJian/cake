package zzw.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import zzw.captcha.Captcha;
import zzw.entity.User;
import zzw.service.UserService;
import zzw.sms.SMS;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();
	private UserService userService;
	private SMS sms = new SMS();
	private HttpServletResponse response;
	private HttpServletRequest request;
	private HttpSession session;
	private HttpContext context;
	private Integer loginVerificationCode;
	private Integer registerVerifyCode;
	private String msg;
	private InputStream inputStream;

	public static final String CAPTCHA_IMAGE_FORMAT = "jpeg";

	public UserAction() {
		System.out.println("世界第一帅");
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		session = request.getSession();
		response.setHeader("Access-Control-Allow-Origin", "*");
	}

	public String getCaptcha() throws IOException {
		// 获得验证码code和验证码图片codePic的Map集合
		Map<String, Object> map = Captcha.generateCaptcha();

		System.out.println("验证码的值为：" + map.get("code"));

		// 将codePic放入输入流
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ImageIO.write((BufferedImage) map.get("codePic"), "jpg", outputStream);
		inputStream = new ByteArrayInputStream(outputStream.toByteArray());

		Cookie Cookie = new Cookie("captcha", (String) map.get("code"));
		Cookie.setMaxAge(60);
		Cookie.setPath("/");
		response.addCookie(Cookie);

		return "getCaptcha";
	}

	public String getRegisterVerificationCode() {
		User userExist = userService.findByPhone(user.getPhone());
		if (userExist == null) {
			do {
				registerVerifyCode = (int) (Math.random() * 10000);
			} while (registerVerifyCode < 1000);
			System.out.println(registerVerifyCode);
			// sms.sendSMS(user.getPhone(), registerVerifyCode);
			msg = String.valueOf(registerVerifyCode);
		} else {
			msg = "该手机号已被注册!";
		}
		return "getRegisterVerificationCode";
	}

	public String getLoginVerificationCode() {
		User userExist = userService.findByPhone(user.getPhone());
		if (userExist != null) {
			while (loginVerificationCode == null || loginVerificationCode < 1000) {
				loginVerificationCode = (int) (Math.random() * 10000);
			}
			System.out.println(loginVerificationCode);
			// sms.sendSMS(user.getPhone(), loginVerifyCode);
			msg = String.valueOf(loginVerificationCode);
		} else {
			msg = "该号码还未注册";
		}
		return "getLoginVerificationCode";
	}

	public String register() {
		userService.register(user);
		return "registerSuccess";
	}

	public String nomalLogin() throws IOException {
		User userExist = userService.findByPhoneAndPassword(user.getPhone(), user.getPassword());
		if (userExist == null) {
			response.sendRedirect("http://192.168.1.109:8080/cake_ssh/HTML/login.html?msg=error");
			return null;
		} else {
			Cookie phoneCookie = new Cookie("phone", user.getPhone());
			phoneCookie.setMaxAge(60 * 60 * 24);
			phoneCookie.setPath("/cake_ssh/");
			response.addCookie(phoneCookie);
			request.getSession().setAttribute("phone", user.getPhone());
			return "LoginSuccess";
		}
	}

	public String verificationCodeLogin() {
		Cookie phoneCookie = new Cookie("phone", user.getPhone());
		phoneCookie.setMaxAge(60 * 60 * 24);
		phoneCookie.setPath("/cake_ssh/");
		response.addCookie(phoneCookie);
		session.setAttribute("phone", user.getPhone());
		return "LoginSuccess";
	}

	public String logout() {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase("phone")) {
					cookie.setValue(null);
					cookie.setMaxAge(0);
					cookie.setPath("/cake_ssh/");
					response.addCookie(cookie);
					break;
				}
			}
		}
		session.removeAttribute("phone");
		msg = "注销成功！";
		return "logout";
	}

	public String toUserCenter() {
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
		response.setHeader("Pragma", "no-cache");
		boolean isLogin = userService.isLogin(request, session);
		if (isLogin == true) {
			return "toUserCenter";
		} else {
			return "noLogin";
		}
	}

	public String update() {
		userService.update(user, session);
		return "update";
	}

	public String getBasicInformation() {
		user = userService.getBasicInformation(session);
		return "getBasicInformation";
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getModel() {
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setLoginVerificationCode(Integer loginVerificationCode) {
		this.loginVerificationCode = loginVerificationCode;
	}

	public String getMsg() {
		return msg;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setRegisterVerifyCode(Integer registerVerifyCode) {
		this.registerVerifyCode = registerVerifyCode;
	}
}