package hx.insist.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import hx.insist.exception.DaoException;
import hx.insist.utils.JdbcUtils;
import hx.insist.dao.UserDao;
import hx.insist.domain.User;

public class UserDaoImpl implements UserDao {
	//增加用户
	@Override
	public boolean add(User user) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into Users(id,username,password,email,birthday,nickname) values(?,?,?,?,?,?)";
			PreparedStatement ps  = conn.prepareStatement(sql);
			
			ps.setString(1, user.getId());//1  对应第一个 ?   ----sql注入
			ps.setString(2, user.getUsername());//1  对应第一个 ?   ----sql注入
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getEmail());
			ps.setDate(5, user.getBirthday());
			ps.setString(6, user.getNickname());
			
			int num = ps.executeUpdate();
			if(num<1){
				return false;
			}else {
				return true;
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}	
	}
	//注册时，检查是否已存在用户名
	public boolean find(String username) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from Users where username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
			return false;
		}catch (Exception e) {
			throw new DaoException(e); 
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	//登陆时，检查用户名与密码正确性
	@Override
	public User find(String username,String password) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from Users where username=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setId(rs.getString("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));
				user.setNickname(rs.getString("nickname"));
				return user;
			}
			return null;
		}catch (Exception e) {
			throw new DaoException(e); 
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	@Override
	public User getUser(String username) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from Users where username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			rs = ps.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setId(null);
				user.setUsername(rs.getString("username"));
				user.setPassword(null);						//这些信息保留
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));
				user.setNickname(rs.getString("nickname"));
				return user;
			}
			return null;
		}catch (Exception e) {
			throw new DaoException(e); 
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
}
