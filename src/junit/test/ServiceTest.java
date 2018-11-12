package junit.test;

import java.util.Date;

import org.junit.Test;

import hx.insist.domain.User;
import hx.insist.exception.UserExistException;
import hx.insist.service.impl.BusinessServiceImpl;

public class ServiceTest {
	@Test
	public void testregister() {
		BusinessServiceImpl bser = new BusinessServiceImpl();
		User user = new User();
		/*user.setBirthday(new Date());
		user.setEmail("11@foxmail.com");
		user.setId("999");
		user.setNickname("zhinum");*/
		//user.setPassword("222");
		user.setUsername("333");
		
		try {
			bser.register(user);
		} catch (UserExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testlogin() {
		BusinessServiceImpl bser = new BusinessServiceImpl();
		if(bser.login("", "222 ")==null) {
			System.out.println("no");
		}else {
			System.out.println("cunzai");
		}
	}
}
