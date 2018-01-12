package zzw.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import zzw.dao.CardDao;
import zzw.entity.Card;
import zzw.entity.User;
import zzw.service.CardService;

@Transactional
public class CardServiceImpl implements CardService{

	private CardDao cardDao;
	public void setCardDao(CardDao cardDao) {
		this.cardDao = cardDao;
	}
	@Override
	public void add(Card card) {
		cardDao.add(card);
	}
	@Override
	public List<Card> findByUser(User user) {
		return cardDao.findByUser(user);
	}
	@Override
	public void delete(Card card) {
		cardDao.delete(card);
		
	}
	@Override
	public Card findById(Integer cid) {
		return cardDao.findById(cid);
	}
	@Override
	public void update(Card cardExist) {
		cardDao.update(cardExist);
	}
}
