package zzw.dao.impl;

import java.util.List;

import zzw.dao.VarietyDao;
import zzw.entity.User;
import zzw.entity.Variety;

public class VarietyDaoImpl extends BaseDaoImpl<Variety> implements VarietyDao {

	@Override
	public List<Variety> findByUser(User user) {
		List<Variety> varietyList = (List<Variety>) this.getHibernateTemplate().find("from Variety where user = ?",
				user);
		return varietyList;
	}

	@Override
	public Variety findByVatiety(String variety) {
		List<Variety> varietys = (List<Variety>) this.getHibernateTemplate().find("from Variety where variety = ?",
				variety);
		if (varietys.size() > 0) {
			return varietys.get(0);
		} else {
			return null;
		}
	}
}
