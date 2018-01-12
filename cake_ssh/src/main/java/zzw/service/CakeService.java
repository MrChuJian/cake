package zzw.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import zzw.entity.Address;
import zzw.entity.Cake;
import zzw.entity.Variety;
import zzw.vo.CakeVO;

public interface CakeService {

	void add(CakeVO cakeVO, List<File> upload, List<String> uploadFileName);

	List<CakeVO> findAll();

	List<CakeVO> findByVariety(Variety variety);

	void addToShopCar(CakeVO cakeVO, HttpSession session);

	CakeVO findById(Integer cid);

	String generateOrder(HttpSession session, List<CakeVO> cakeVOs, Address address);

	CakeVO getDetail(Integer cid);

}
