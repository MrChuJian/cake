package zzw.dao.impl;

import static org.junit.Assert.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import zzw.dao.UserDao;
import zzw.entity.User;

@Transactional
public class UserDaoImplTest extends BaseDaoImpl<User>{

	@Before
	public void setUp() throws Exception {
		AbstractXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        //从spring容器中把对象提取出来
        setSessionFactory((SessionFactory) context.getBean("sessionFactory"));;
		
	}

	@Test
	public void testFind() {
		User user = new User();
		user.setPhone("15815410203");
		List<User> list = (List<User>) this.getHibernateTemplate().findByExample(user);
		for (User user2 : list) {
			System.out.println("1");
			System.out.println(user2);
		}
	}
	
	@Test
	public void testquery() {
		List<User> users = (List<User>) this.getHibernateTemplate().find("from User where phone = ?", "15815410203");
		User user = users.get(0);
		System.out.println(user);
		user.setUsername("zhizhang");
		this.getHibernateTemplate().update(user);
		System.out.println(user);
	}

}
