package test;

import org.dozer.DozerBeanMapper;

import zzw.entity.User;

public class dozer {

	public static void main(String[] args) {
		DozerBeanMapper dozer = new DozerBeanMapper();
		UserList user = new UserList();
		user.getUsers().add(new User());
		user.setA("1");
		UserSet set = dozer.map(user, UserSet.class);
		System.out.println("1");
	}
}
