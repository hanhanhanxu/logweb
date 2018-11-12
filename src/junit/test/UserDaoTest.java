package junit.test;

import java.sql.Date;

import org.junit.Test;

import hx.insist.dao.UserDao;
import hx.insist.dao.impl.UserDaoImpl;
import hx.insist.domain.User;

public class UserDaoTest {
	@Test
	public void testAdd(){
		User user = new User();
		user.setBirthday(new Date(0));
		user.setEmail("123@foxmail.com");
		user.setId("123");
		user.setNickname("lonelylove");
		user.setPassword("123456");
		user.setUsername("123456");
		
		UserDao dao = new UserDaoImpl();
		dao.add(user);
		
	}
	@Test
	public void testFind1() {
		UserDao dao = new UserDaoImpl();
		if(dao.find("aaa","123")==null) {
			System.out.println("no");
		}else {
			System.out.println("cunzai");
		}
		
	}
	@Test
	public void testFind2() {
		UserDao dao = new UserDaoImpl();
		if(dao.find("123456")==false) {
			System.out.println("no");
		}else {
			System.out.println("cunzai");
		}
		
	}
	@Test
	public void testgetUser() {
		UserDao dao = new UserDaoImpl();
		User user = dao.getUser("111111");
		System.out.println(user.getNickname());
		System.out.println(user.getBirthday());
	}
}
