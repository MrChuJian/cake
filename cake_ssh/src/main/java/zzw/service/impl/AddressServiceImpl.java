package zzw.service.impl;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.transaction.annotation.Transactional;
import zzw.dao.AddressDao;
import zzw.dao.UserDao;
import zzw.entity.Address;
import zzw.entity.User;
import zzw.service.AddressService;

@Transactional
public class AddressServiceImpl implements AddressService {

	private AddressDao addressDao;
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}
	@Override
	public void add(Address address) {
		addressDao.add(address);
		
	}
	@Override
	public List<Address> findByUser(User user) {
		return addressDao.findByUser(user);
	}
	@Override
	public Address findByid(Integer aid) {
		return addressDao.findById(aid);
	}
	@Override
	public void update(Address address) {
		addressDao.update(address);
	}
	@Override
	public void delete(Address address) {
		addressDao.delete(address);
	}
	@Override
	public void addOrUpdate(Address address, HttpSession session) {
		Address addressDo;
		String phone;
		User user;
		Date date;
		
		date = new Date();
		
		
		if (address.getAid() == null) {
			addressDo = address;
			address.setGmt_create(date);
		} else {
			addressDo = addressDao.findById(address.getAid());
			addressDo.setAddressee(address.getAddressee());
			addressDo.setAddress(address.getAddress());
			addressDo.setUser_color(address.getUser_color());
			addressDo.setAddressee_phone(address.getAddressee_phone());
			addressDo.setTelephone(address.getTelephone());
			addressDo.setAddr_default(address.getAddr_default());
		}
		addressDo.setGmt_modified(date);
		phone = (String) session.getAttribute("phone");
		user = userDao.findByPhone(phone);
		addressDo.setUser(user);
		addressDao.saveOrUpdate(addressDo);
	}
	
}
