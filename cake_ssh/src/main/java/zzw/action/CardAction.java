package zzw.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import zzw.entity.Card;
import zzw.entity.User;
import zzw.service.CardService;
import zzw.service.UserService;

public class CardAction extends ActionSupport implements ModelDriven<Card>{

	private Card card = new Card();
	private CardService cardService;
	private UserService userService;
	private List<Card> cards;
	private  HttpServletResponse response;
	private  HttpServletRequest request;
	private String msg;
	
	public CardAction() {
		response = ServletActionContext.getResponse();
		request = ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", "*");
	}
	
	public String getCardInformation() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
//		String phone = (String) ServletActionContext.getRequest().getSession().getAttribute("phone");
		String phone = "15815410203";
		User user = userService.findByPhone(phone);
		cards = cardService.findByUser(user);
		return "getCardInformation";
	}
	
	public String delete() {
		cardService.delete(card);
		msg = "删除成功";
		return "delete";
	}
	
	public String update() {
		Card cardExist = cardService.findById(card.getCid());
		cardExist.setState(card.getState());
		cardService.update(cardExist);
		msg = "激活成功";
		return "update";
	}
	
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setCardService(CardService cardService) {
		this.cardService = cardService;
	}
	public Card getModel() {
		return card;
	}
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	public String getMsg() {
		return msg;
	}
}
