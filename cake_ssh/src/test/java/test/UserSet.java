package test;

import java.util.HashSet;
import java.util.Set;

import zzw.entity.User;

public class UserSet{
	private Set<User> users = new HashSet<>();
	private String a;

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
	
}