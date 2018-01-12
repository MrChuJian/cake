package zzw.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import zzw.entity.Card;
import zzw.entity.TradeRecord;
import zzw.entity.User;
import zzw.service.TradeRecordService;
import zzw.service.UserService;

public class TradeRecordAction extends ActionSupport implements ModelDriven<TradeRecord>{

	private TradeRecord tradeRecord = new TradeRecord();
	private TradeRecordService tradeRecordService;
	private UserService userService;
	private List<TradeRecord> tradeRecords;
	private  HttpServletResponse response;
	private  HttpServletRequest request;
	
	public TradeRecordAction() {
		response = ServletActionContext.getResponse();
		request = ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", "*");
	}
	
	public String getTradeRecordInformation() {
//		String phone = (String) ServletActionContext.getRequest().getSession().getAttribute("phone");
		String phone = "15815410203";
		User user = userService.findByPhone(phone);
		tradeRecords = tradeRecordService.findByUser(user);
		return "getTradeRecordInformation";
	}
	
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setTradeRecordService(TradeRecordService tradeRecordService) {
		this.tradeRecordService = tradeRecordService;
	}
	public TradeRecord getModel() {
		return tradeRecord;
	}
	public List<TradeRecord> getTradeRecords() {
		return tradeRecords;
	}
	public void setTradeRecords(List<TradeRecord> tradeRecords) {
		this.tradeRecords = tradeRecords;
	}
}
