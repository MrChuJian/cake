package zzw.dao.impl;

import java.util.List;

import zzw.dao.AddressDao;
import zzw.entity.Address;
import zzw.entity.User;

public class AddressDaoImpl extends BaseDaoImpl<Address> implements AddressDao {

	@Override
	public List<Address> findByUser(User user) {
		List<Address> addressList = (List<Address>) this.getHibernateTemplate().find("from Address where user = ?", user);
		return addressList;
	}

}
