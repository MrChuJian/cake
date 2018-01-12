package zzw.dao;

import java.util.List;

import zzw.entity.TradeRecord;
import zzw.entity.User;

public interface TradeRecordDao extends BaseDao<TradeRecord> {

	List<TradeRecord> findByUser(User user);

}
