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
	//�����û�
	@Override
	public boolean add(User user) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into Users(id,username,password,email,birthday,nickname) values(?,?,?,?,?,?)";
			PreparedStatement ps  = conn.prepareStatement(sql);
			
			ps.setString(1, user.getId());//1  ��Ӧ��һ�� ?   ----sqlע��
			ps.setString(2, user.getUsername());//1  ��Ӧ��һ�� ?   ----sqlע��
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
	//ע��ʱ������Ƿ��Ѵ����û���
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
	//��½ʱ������û�����������ȷ��
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
				user.setPassword(null);						//��Щ��Ϣ����
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
