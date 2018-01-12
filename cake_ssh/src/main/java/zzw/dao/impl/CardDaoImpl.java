package zzw.dao.impl;

import java.util.List;

import zzw.dao.CardDao;
import zzw.entity.Card;
import zzw.entity.User;

public class CardDaoImpl extends BaseDaoImpl<Card> implements CardDao {

	@Override
	public List<Card> findByUser(User user) {
		List<Card> cardList = (List<Card>) this.getHibernateTemplate().find("from Card where user = ?", user);
		return cardList;
	}

}
