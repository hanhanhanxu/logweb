package hx.insist.dao;

import hx.insist.domain.User;

public interface UserDao {
	//ע��ʱ�����û�
	boolean add(User user);
	//ע��ʱ������Ƿ��Ѵ����û���
	boolean find(String username);
	//��½ʱ������û�����������ȷ��
	User find(String username,String password);
	//ͨ��usernam�õ��û���Ϣ
	User getUser(String username);
}