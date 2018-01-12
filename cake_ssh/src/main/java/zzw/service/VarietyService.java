package zzw.service;

import java.util.List;

import zzw.entity.User;
import zzw.entity.Variety;

public interface VarietyService{

	void add(Variety variety);


	Variety findByVariety(String string);


	List<Variety> findAll();
}
