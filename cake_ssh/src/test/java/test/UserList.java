package test;

import java.util.LinkedList;
import java.util.List;

import zzw.entity.User;

public class UserList{
	private List<User> users = new LinkedList<>();
	private String a;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
	
	
}