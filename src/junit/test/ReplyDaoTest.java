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
	//���Զ����ӵ�����----ͨ��
	@Test
	public void testadd1() {
		ReplyDaoImpl rdao = new ReplyDaoImpl();
		
		Reply reply = new Reply();
		reply.setMatter_id(1);//������m1���������
		reply.setReply_date(new Date());
		reply.setReply_content("��ʲô���ⶼ������������");
		reply.setSend_username("111111");//��������111111   ������¥��������
		rdao.add(reply,0);//��ʶ0��ָ��receive_reply_id��������һ������
		
		Reply reply2 = new Reply();
		reply2.setMatter_id(1);//������m1���������
		reply2.setReply_date(new Date());
		reply2.setReply_content("Ҳ�������,���Ǵ���");
		reply2.setSend_username("222222");//��������222222
		rdao.add(reply2,0);//��ʶ0��ָ��receive_reply_id��������һ������
		
		Reply reply3 = new Reply();
		reply3.setMatter_id(1);//������m1���������
		reply3.setReply_date(new Date());
		reply3.setReply_content("���������ĬĬ���žͺ�");
		reply3.setSend_username("333333");//��������333333
		rdao.add(reply3,0);//��ʶ0��ָ��receive_reply_id��������һ������
	}
	
	//���Զ����ӵ����۽��лظ�
	@Test
	public void testadd2() {
		ReplyDaoImpl rdao = new ReplyDaoImpl();
		
		Reply reply = new Reply();
		reply.setMatter_id(1);//������m1���������
		reply.setReply_date(new Date());
		reply.setReply_content("ת�����ض����������ʲô��");
		reply.setSend_username("444444");//��������333333
		reply.setReceive_reply_id(1);//�ظ�����idΪ1����������
		rdao.add(reply,1);//��ʶ1��ָ��receive_reply_id��������һ�����۵Ļظ�
		
		Reply reply2 = new Reply();
		reply2.setMatter_id(1);//������m1���������
		reply2.setReply_date(new Date());
		reply2.setReply_content("��ѽ,��Ҳ��֪��");
		reply2.setSend_username("555555");//��������555555
		reply2.setReceive_reply_id(2);//�ظ�����idΪ2����������
		rdao.add(reply2,1);//��ʶ1��ָ��receive_reply_id��������һ�����۵Ļظ�
	}
	
	@Test
	public void testfind() {

	}
	
	//���Եõ�һ�����ۻ�ظ�(����id)
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
	
	//���Եõ��������ۣ��������ظ�
	@Test
	public void testsearchAllReply() {
		ReplyDaoImpl rdao = new ReplyDaoImpl();
		List<Reply> list = rdao.searchAllComment(1);//�鿴������Ϊm1������������ۡ����������ۻظ�
		
		for(Reply reply : list) {
			System.out.println(reply.getMatter_id());
			System.out.println(reply.getReply_id());
			System.out.println(reply.getReply_date());
			System.out.println(reply.getReply_content());
			System.out.println(reply.getSend_username());
			System.out.println(reply.getReceive_reply_id());
		}
	}
	
	//���Եõ�һ�����۵����лظ�
	@Test
	public void testsearchReply() {//searchReply//����󣬲������Լ�������������
		ReplyDaoImpl rdao = new ReplyDaoImpl();
		Reply reply = rdao.getReply(1);//�ȵõ�1�������ۻ�ظ�
		List<Reply> list = rdao.searchAllReply(reply);//��ĳ�����۴���ȥ�����ɵõ�
		
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
