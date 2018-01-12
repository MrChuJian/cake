package zzw.service;

import java.util.List;

import zzw.entity.Cake;
import zzw.entity.Picture;

public interface PictureService {

	void add(Picture picture);

	List<Picture> findByCake(Cake cake);

}
