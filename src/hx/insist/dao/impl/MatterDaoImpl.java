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
//Daoʵ�ֲ� �� ���ݿ�򽻵� 
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
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//matter���date��Date���͵�
			
			ps.setString(1, sdf.format(matter.getMatter_date()));//���String�浽���ݿ���
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
				matter.setMatter_date(sdf.parse(rs.getString("matter_date")));//���ݿ���ȡ����Stringת��ΪDate�������
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

	//��������matter_id
	@Override
	public Matter find() {
		return null;
	}

	//�õ���������
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
				matter.setMatter_date(sdf.parse(rs.getString("matter_date")));//���ݿ���ȡ����Stringת��ΪDate�������
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

	////����matter_id�õ����Matter����Ϣ
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
				matter.setMatter_date(sdf.parse(rs.getString("matter_date")));//�������ݿ���ȡ����String����ת��ΪDate����
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
