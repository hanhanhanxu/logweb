package hx.insist.service.impl;


import hx.insist.dao.UserDao;

import hx.insist.domain.User;
import hx.insist.exception.UserExistException;
import hx.insist.factory.DaoFactory;
import hx.insist.utils.ServiceUtils;

public class BusinessServiceImpl {
	
	//private UserDao udao = new UserDaoImpl();
	private UserDao udao = DaoFactory.getInstance().createDao(UserDao.class); //����ģʽ
	//ע��
	public void  register(User user) throws UserExistException {
		if(udao.find(user.getUsername())==true) {
			throw new  UserExistException(); //ע���û��Ѵ��ڣ��׳�����ʱ�쳣�����봦��
		}else {
			user.setPassword(ServiceUtils.md5(user.getPassword()));//����password
			udao.add(user);
		}
	}
	
	//��½
	public User login(String username,String password) {
		password = ServiceUtils.md5(password);//��password����  (���ݿ��д��password�Ǿ������ܵ�)
		return udao.find(username, password);//����
	}
}
