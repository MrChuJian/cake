package zzw.service;

import java.util.List;

import zzw.entity.Card;
import zzw.entity.User;

public interface CardService {

	void add(Card card);

	List<Card> findByUser(User user);

	void delete(Card card);

	Card findById(Integer cid);

	void update(Card cardExist);

}
