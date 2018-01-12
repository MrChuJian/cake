package zzw.dao;

import java.util.List;

import zzw.entity.Card;
import zzw.entity.User;

public interface CardDao extends BaseDao<Card> {

	List<Card> findByUser(User user);

}
