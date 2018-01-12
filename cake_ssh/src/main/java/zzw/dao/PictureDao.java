package zzw.dao;

import java.util.List;

import zzw.entity.Cake;
import zzw.entity.Picture;

public interface PictureDao extends BaseDao<Picture> {

	List<Picture> findByCake(Cake cake);

}
