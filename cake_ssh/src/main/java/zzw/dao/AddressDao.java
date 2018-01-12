package zzw.dao;

import java.util.List;

import zzw.entity.Address;
import zzw.entity.User;

public interface AddressDao extends BaseDao<Address> {

	List<Address> findByUser(User user);

}
