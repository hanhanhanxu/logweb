package hx.insist.dao.impl;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import hx.insist.dao.ReplyDao;
import hx.insist.domain.Matter;
import hx.insist.domain.Reply;
import hx.insist.utils.JdbcUtils;

public class ReplyDaoImpl implements ReplyDao {

	@Override
	public boolean add(Reply reply,int n) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql;
			if(n==0) {
				sql = "insert into Reply(matter_id,reply_date,reply_content,send_username) values(?,?,?,?)";
			}else {
				sql = "insert into Reply(matter_id,reply_date,reply_content,send_username,receive_reply_id) values(?,?,?,?,?)";
			}
			PreparedStatement ps  = conn.prepareStatement(sql);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			ps.setInt(1, reply.getMatter_id());//1  ��Ӧ��һ�� ?   ----sqlע��
			ps.setString(2, sdf.format(reply.getReply_date()));//��reply�е�Date����ת��ΪString���ʹ�����ݿ�
			ps.setString(3, reply.getReply_content());
			ps.setString(4, reply.getSend_username());
			if(n!=0) {
				ps.setInt(5, reply.getReceive_reply_id());
			}
			
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
	public boolean delete(int reply_id) {
		return false;
	}
	//��������reply_id,Ϊ��д��һ��reply_id
	@Override
	public Reply find() {
		return null;
	}
	
	//����ĳ�������µ���������
	@Override
	public List<Reply> searchAllComment(int matter_id) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from Reply where matter_id=? and receive_reply_id is null";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, matter_id);//1  ��Ӧ��һ�� ?   ----sqlע��
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			rs = ps.executeQuery();
			List<Reply> list = new ArrayList<Reply>();
			while(rs.next()){
				Reply reply = new Reply();
				reply.setMatter_id(rs.getInt("matter_id"));
				reply.setReply_id(rs.getInt("reply_id"));
				reply.setReply_date(sdf.parse(rs.getString("reply_date")));//�������ݿ���ȡ����String����ת��ΪDate����
				reply.setReply_content(rs.getString("reply_content"));
				reply.setSend_username(rs.getString("send_username"));
				reply.setReceive_reply_id(rs.getInt("receive_reply_id"));
				
				list.add(reply);
			}
			return list.isEmpty()==true?null:list;
		}catch (Exception e) {
			throw new RuntimeException(e); 
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	//����ĳ�������µ���������
	@Override
	public List<Reply> searchAll(int matter_id) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from Reply where matter_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, matter_id);//1  ��Ӧ��һ�� ?   ----sqlע��
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			rs = ps.executeQuery();
			List<Reply> list = new ArrayList<Reply>();
			while(rs.next()){
				Reply reply = new Reply();
				reply.setMatter_id(rs.getInt("matter_id"));
				reply.setReply_id(rs.getInt("reply_id"));
				reply.setReply_date(sdf.parse(rs.getString("reply_date")));//�������ݿ���ȡ����String����ת��ΪDate����
				reply.setReply_content(rs.getString("reply_content"));
				reply.setSend_username(rs.getString("send_username"));
				reply.setReceive_reply_id(rs.getInt("receive_reply_id"));
				
				list.add(reply);
			}
			return list.isEmpty()==true?null:list;
		}catch (Exception e) {
			throw new RuntimeException(e); 
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
		
	//����ĳ�����ۻ�ظ�(reply)�õ������лظ�
	@Override
	public List<Reply> searchAllReply(Reply reply) {
		//receive_reply_id��reply_id��ͬ
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from Reply where matter_id=? and receive_reply_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			//����matter_id=reply��matter_id ��  receive_reply_id=reply��reply_id   ����Ϣ������
			ps.setInt(1, reply.getMatter_id());
			ps.setInt(2, reply.getReply_id());
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			rs = ps.executeQuery();
			List<Reply> list = new ArrayList<Reply>();
			while(rs.next()){
				Reply replyrs = new Reply();
				replyrs.setMatter_id(rs.getInt("matter_id"));
				replyrs.setReply_id(rs.getInt("reply_id"));
				replyrs.setReply_date(sdf.parse(rs.getString("reply_date")));//�������ݿ���ȡ����String����ת��ΪDate����
				replyrs.setReply_content(rs.getString("reply_content"));
				replyrs.setSend_username(rs.getString("send_username"));
				replyrs.setReceive_reply_id(rs.getInt("receive_reply_id"));
				
				list.add(replyrs);
			}
			return list.isEmpty()==true?null:list;
		}catch (Exception e) {
			throw new RuntimeException(e); 
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}

	//����reply_id�õ����Reply��������Ϣ
	@Override
	public Reply getReply(int reply_id) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from Reply where reply_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reply_id);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			rs = ps.executeQuery();
			if(rs.next()){
				Reply reply = new Reply();
				reply.setMatter_id(rs.getInt("matter_id"));
				reply.setReply_id(rs.getInt("reply_id"));
				reply.setReply_date(sdf.parse(rs.getString("reply_date")));//�������ݿ���ȡ����String����ת��ΪDate����
				reply.setReply_content(rs.getString("reply_content"));
				reply.setSend_username(rs.getString("send_username"));
				reply.setReceive_reply_id(rs.getInt("receive_reply_id"));
				
				return reply;
			}
			return null;
		}catch (Exception e) {
			throw new RuntimeException(e); 
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
}
