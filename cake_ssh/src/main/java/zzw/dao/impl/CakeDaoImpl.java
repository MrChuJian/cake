package zzw.dao.impl;

import java.util.List;

import zzw.dao.CakeDao;
import zzw.entity.Cake;
import zzw.entity.Variety;

public class CakeDaoImpl extends BaseDaoImpl<Cake> implements CakeDao {

	@Override
	public List<Cake> findByVariety(Variety variety) {
		return (List<Cake>) this.getHibernateTemplate().find("from Cake where variety = ?", variety);
	}

}
