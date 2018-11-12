package junit.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import hx.insist.dao.impl.MatterDaoImpl;
import hx.insist.dao.impl.ReplyDaoImpl;
import hx.insist.domain.Matter;
import hx.insist.domain.Reply;

public class ReplyDaoTest {
	//测试对帖子的评论----通过
	@Test
	public void testadd1() {
		ReplyDaoImpl rdao = new ReplyDaoImpl();
		
		Reply reply = new Reply();
		reply.setMatter_id(1);//评论在m1这个标题上
		reply.setReply_date(new Date());
		reply.setReply_content("有什么问题都可以来问我噢");
		reply.setSend_username("111111");//评论者是111111   即这是楼主的评论
		rdao.add(reply,0);//标识0是指无receive_reply_id，即这是一条评论
		
		Reply reply2 = new Reply();
		reply2.setMatter_id(1);//评论在m1这个标题上
		reply2.setReply_date(new Date());
		reply2.setReply_content("也随便问我,我是大佬");
		reply2.setSend_username("222222");//评论者是222222
		rdao.add(reply2,0);//标识0是指无receive_reply_id，即这是一条评论
		
		Reply reply3 = new Reply();
		reply3.setMatter_id(1);//评论在m1这个标题上
		reply3.setReply_date(new Date());
		reply3.setReply_content("萌新求带，默默看着就好");
		reply3.setSend_username("333333");//评论者是333333
		rdao.add(reply3,0);//标识0是指无receive_reply_id，即这是一条评论
	}
	
	//测试对帖子的评论进行回复
	@Test
	public void testadd2() {
		ReplyDaoImpl rdao = new ReplyDaoImpl();
		
		Reply reply = new Reply();
		reply.setMatter_id(1);//评论在m1这个标题上
		reply.setReply_date(new Date());
		reply.setReply_content("转发和重定向的区别是什么呢");
		reply.setSend_username("444444");//评论者是333333
		reply.setReceive_reply_id(1);//回复评论id为1的评论内容
		rdao.add(reply,1);//标识1是指有receive_reply_id，即这是一条评论的回复
		
		Reply reply2 = new Reply();
		reply2.setMatter_id(1);//评论在m1这个标题上
		reply2.setReply_date(new Date());
		reply2.setReply_content("对呀,我也不知道");
		reply2.setSend_username("555555");//评论者是555555
		reply2.setReceive_reply_id(2);//回复评论id为2的评论内容
		rdao.add(reply2,1);//标识1是指有receive_reply_id，即这是一条评论的回复
	}
	
	@Test
	public void testfind() {

	}
	
	//测试得到一条评论或回复(传入id)
	@Test
	public void testgetReply() {
		ReplyDaoImpl rdao = new ReplyDaoImpl();
		Reply reply = rdao.getReply(1);
		System.out.println(reply.getMatter_id());
		System.out.println(reply.getReply_id());
		System.out.println(reply.getReply_date());
		System.out.println(reply.getReply_content());
		System.out.println(reply.getSend_username());
		System.out.println(reply.getReceive_reply_id());
	}
	
	//测试得到所有评论，不包括回复
	@Test
	public void testsearchAllReply() {
		ReplyDaoImpl rdao = new ReplyDaoImpl();
		List<Reply> list = rdao.searchAllComment(1);//查看标题编号为m1下面的所有评论。不包括评论回复
		
		for(Reply reply : list) {
			System.out.println(reply.getMatter_id());
			System.out.println(reply.getReply_id());
			System.out.println(reply.getReply_date());
			System.out.println(reply.getReply_content());
			System.out.println(reply.getSend_username());
			System.out.println(reply.getReceive_reply_id());
		}
	}
	
	//测试得到一条评论的所有回复
	@Test
	public void testsearchReply() {//searchReply//大错误，不包括自己，，，，，，
		ReplyDaoImpl rdao = new ReplyDaoImpl();
		Reply reply = rdao.getReply(1);//先得到1这条评论或回复
		List<Reply> list = rdao.searchAllReply(reply);//把某条评论传进去，即可得到
		
		for(Reply reply2 : list) {
			System.out.println(reply2.getMatter_id());
			System.out.println(reply2.getReply_id());
			System.out.println(reply2.getReply_date());
			System.out.println(reply2.getReply_content());
			System.out.println(reply2.getSend_username());
			System.out.println(reply2.getReceive_reply_id());
		}
		
	}
}
