package zzw.dao;

import java.util.List;

import zzw.entity.User;
import zzw.entity.Variety;

public interface VarietyDao extends BaseDao<Variety> {

	List<Variety> findByUser(User user);

	Variety findByVatiety(String variety);
}
