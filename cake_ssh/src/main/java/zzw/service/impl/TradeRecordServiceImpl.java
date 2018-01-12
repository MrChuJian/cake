package zzw.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import zzw.dao.TradeRecordDao;
import zzw.entity.TradeRecord;
import zzw.entity.User;
import zzw.service.TradeRecordService;

@Transactional
public class TradeRecordServiceImpl implements TradeRecordService {

	private TradeRecordDao tradeRecordDao;
	public void setTradeRecordDao(TradeRecordDao tradeRecordDao) {
		this.tradeRecordDao = tradeRecordDao;
	}
	@Override
	public void add(TradeRecord tradeRecord) {
		tradeRecordDao.add(tradeRecord);
	}
	@Override
	public List<TradeRecord> findByUser(User user) {
		return tradeRecordDao.findByUser(user);
	}
}
