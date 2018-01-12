package zzw.service;

import java.util.List;

import zzw.entity.TradeRecord;
import zzw.entity.User;

public interface TradeRecordService {

	void add(TradeRecord tradeRecord);

	List<TradeRecord> findByUser(User user);

}
