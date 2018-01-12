package zzw.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import zzw.entity.Address;
import zzw.entity.User;

public interface AddressService{

	void add(Address address);

	List<Address> findByUser(User user);

	Address findByid(Integer aid);

	void update(Address address);

	void delete(Address address);

	void addOrUpdate(Address address, HttpSession session);

}
