package hx.insist.dao;

import hx.insist.domain.User;

public interface UserDao {
	//注册时增加用户
	boolean add(User user);
	//注册时，检查是否已存在用户名
	boolean find(String username);
	//登陆时，检查用户名与密码正确性
	User find(String username,String password);
	//通过usernam得到用户信息
	User getUser(String username);
}