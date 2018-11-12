package hx.insist.dao.impl;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import hx.insist.dao.MatterDao;
import hx.insist.domain.Matter;
import hx.insist.domain.Reply;
import hx.insist.utils.JdbcUtils;
//Dao实现层 与 数据库打交道 
public class MatterDaoImpl implements MatterDao {

	@Override
	public boolean add(Matter matter) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into Matter(matter_date,matter_text,user_username,matter_content) values(?,?,?,?);";
			PreparedStatement ps  = conn.prepareStatement(sql);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//matter里的date是Date类型的
			
			ps.setString(1, sdf.format(matter.getMatter_date()));//变成String存到数据库中
			ps.setString(2, matter.getMatter_text());
			ps.setString(3, matter.getUser_username());
			ps.setString(4, matter.getMatter_content());
			
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

	@Override
	public boolean delete(int matter_id) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from Matter where matter_id = ?";
			PreparedStatement ps  = conn.prepareStatement(sql);
			
			ps.setInt(1, matter_id);
			
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

	@Override
	public List<Matter> search(String user_id) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from Matter where user_username = ? order by matter_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			rs = ps.executeQuery();
			List<Matter> list = new ArrayList<Matter>();
			while(rs.next()){
				Matter matter = new Matter();
				matter.setMatter_id(rs.getInt("matter_id"));
				matter.setMatter_date(sdf.parse(rs.getString("matter_date")));//数据库中取出的String转化为Date存入变量
				matter.setMatter_text(rs.getString("matter_text"));
				matter.setMatter_content(rs.getString("matter_content"));
				matter.setUser_username(rs.getString("user_username"));
				
				list.add(matter);
			}
			return list.isEmpty()==true?null:list;
		}catch (Exception e) {
			throw new RuntimeException(e); 
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}

	//查找最大的matter_id
	@Override
	public Matter find() {
		return null;
	}

	//得到所有帖子
	@Override
	public List<Matter> getAll() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from Matter order by matter_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			rs = ps.executeQuery();
			List<Matter> list = new ArrayList<Matter>();
			while(rs.next()){
				Matter matter = new Matter();
				matter.setMatter_id(rs.getInt("matter_id"));
				matter.setMatter_date(sdf.parse(rs.getString("matter_date")));//数据库中取出的String转化为Date存入变量
				matter.setMatter_text(rs.getString("matter_text"));
				matter.setMatter_content(rs.getString("matter_content"));
				matter.setUser_username(rs.getString("user_username"));
				
				list.add(matter);
			}
			return list.isEmpty()==true?null:list;
		}catch (Exception e) {
			throw new RuntimeException(e); 
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}

	////根据matter_id得到这个Matter的信息
	@Override
	public Matter getmatter(int matter_id) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from Matter where matter_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, matter_id);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			rs = ps.executeQuery();
			if(rs.next()){
				Matter matter = new Matter();
				matter.setMatter_id(rs.getInt("matter_id"));
				matter.setMatter_date(sdf.parse(rs.getString("matter_date")));//将从数据库中取出的String类型转化为Date类型
				matter.setMatter_text(rs.getString("matter_text"));
				matter.setMatter_content(rs.getString("matter_content"));
				matter.setUser_username(rs.getString("user_username"));
				
				return matter;
			}
			return null;
		}catch (Exception e) {
			throw new RuntimeException(e); 
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
}
