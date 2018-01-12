package zzw.dao.impl;

import java.util.List;

import zzw.dao.PictureDao;
import zzw.entity.Cake;
import zzw.entity.Picture;

public class PictureDaoImpl extends BaseDaoImpl<Picture> implements PictureDao {

	@Override
	public List<Picture> findByCake(Cake cake) {
		List<Picture> pictures = (List<Picture>) this.getHibernateTemplate().find("from Picture where cake = ?", cake);
		return pictures;
	}

	
}
