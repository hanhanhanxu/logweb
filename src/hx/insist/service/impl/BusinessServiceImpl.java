package hx.insist.service.impl;


import hx.insist.dao.UserDao;

import hx.insist.domain.User;
import hx.insist.exception.UserExistException;
import hx.insist.factory.DaoFactory;
import hx.insist.utils.ServiceUtils;

public class BusinessServiceImpl {
	
	//private UserDao udao = new UserDaoImpl();
	private UserDao udao = DaoFactory.getInstance().createDao(UserDao.class); //工厂模式
	//注册
	public void  register(User user) throws UserExistException {
		if(udao.find(user.getUsername())==true) {
			throw new  UserExistException(); //注册用户已存在，抛出编译时异常，必须处理
		}else {
			user.setPassword(ServiceUtils.md5(user.getPassword()));//加密password
			udao.add(user);
		}
	}
	
	//登陆
	public User login(String username,String password) {
		password = ServiceUtils.md5(password);//对password加密  (数据库中存的password是经过加密的)
		return udao.find(username, password);//查找
	}
}
