package zzw.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import zzw.vo.ShopCarCakeVO;
import zzw.vo.ShopCarVO;

public interface ShopCarService {

	List<ShopCarCakeVO> findAll(HttpSession session);

	String delete(ShopCarVO shopCarVO, List<Integer> scid);


}
