package zzw.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import zzw.dao.VarietyDao;
import zzw.dao.impl.VarietyDaoImpl;
import zzw.entity.User;
import zzw.entity.Variety;
import zzw.service.VarietyService;

@Transactional
public class VarietyServiceImpl implements VarietyService {

	private VarietyDao varietyDao = new VarietyDaoImpl();
	public void setVarietyDao(VarietyDao varietyDao) {
		this.varietyDao = varietyDao;
	}
	@Override
	public void add(Variety variety) {
		varietyDao.add(variety);
		
	}
	@Override
	public Variety findByVariety(String variety) {
		return varietyDao.findByVatiety(variety);
	}
	@Override
	public List<Variety> findAll() {
		return varietyDao.findAll();
	}
}
