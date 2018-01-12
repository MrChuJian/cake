package zzw.dao.impl;

import java.util.List;

import zzw.dao.TradeRecordDao;
import zzw.entity.TradeRecord;
import zzw.entity.User;

public class TradeRecordDaoImpl extends BaseDaoImpl<TradeRecord> implements TradeRecordDao {

	@Override
	public List<TradeRecord> findByUser(User user) {
		List<TradeRecord> tradeRecordList = (List<TradeRecord>) this.getHibernateTemplate().find("from TradeRecord where user = ?", user);
		return tradeRecordList;
	}


}
