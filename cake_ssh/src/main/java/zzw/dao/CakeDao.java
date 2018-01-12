package zzw.dao;

import java.util.List;

import zzw.entity.Cake;
import zzw.entity.Variety;

public interface CakeDao extends BaseDao<Cake> {

	List<Cake> findByVariety(Variety variety);

}
