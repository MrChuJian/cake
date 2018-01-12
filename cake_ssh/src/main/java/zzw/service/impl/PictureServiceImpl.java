package zzw.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import zzw.dao.PictureDao;
import zzw.entity.Cake;
import zzw.entity.Picture;
import zzw.service.PictureService;

@Transactional
public class PictureServiceImpl implements PictureService {

	private PictureDao pictureDao;
	public void setPictureDao(PictureDao pictureDao) {
		this.pictureDao = pictureDao;
	}
	@Override
	public void add(Picture picture) {
		pictureDao.add(picture);
	}
	@Override
	public List<Picture> findByCake(Cake cake) {
		return pictureDao.findByCake(cake);
	}
}
